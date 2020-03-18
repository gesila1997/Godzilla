<template>
  <div class="demo">
    <div slot="zhengqing">
     <!-- <Select v-model="zqListQuery.username" placeholder="全部" clearable style="width:200px">
        <Option v-for="item in userNameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>-->
      <Input v-model="zqListQuery.username" placeholder="用户名" style="width: 200px" />
      <Input v-model="zqListQuery.password" placeholder="密码" style="width: 200px" />
      <Button type="primary" @click="getListPage">查询</Button>
      <Button type="primary" @click="handleCreate">添加</Button>
    </div>
    <Table :columns="columns" size="small" style="margin-top:10px" :loading="listLoading" :data="list" disabled-hover>
      <template slot-scope="{row}" slot="action">
        <text-Button @click="handleDetail(row)">详情</text-Button>
        <Divider type="vertical" />
        <text-Button @click="handleUpdate(row)">编辑</text-Button>
        <Divider type="vertical" />
        <text-Button @click="handleDelete(row)">删除</text-Button>
      </template>
    </Table>
    <!-- 分页 -->
    <cus-page @pageChange="handleCurrentChange" @pageSizeChange="handleSizeChange" :pageSize="zqListQuery.pageSize" :total="total"></cus-page>

    <!--  添加和编辑弹出抽屉  +++++++++++++++++++++++++++++++++++++++++++++++++++++     -->
    <!--  :title 加:为绑定数据 即实现自定义标题  -->
    <Drawer :title="titleValue[dialogStatus]" v-model="drawer" width="30%" :mask-closable="true" :styles="drawerStyles">
      <Form ref="zq_formData" :model="zq_formData" label-position="right" :label-width="120" :rules="ruleFormData">
        <Row>
          <i-Col span="24">
            <!-- TODO prop：校验  与v-model对应 外加上面的:rules和下面的2个方法配置使用 即可 -->
            <FormItem label="用户名：" prop="username" label-position="top">
<!--          <Select v-model="zq_formData.username" placeholder="遍历" clearable>
                <Option v-for="item in userNameList" :value="item.value" :key="item.value">{{ item.label }}</Option>
              </Select>-->
<!--          <DatePicker v-model="zq_formData.dateTime" type="datetime" placeholder="日期"></DatePicker>-->
              <Input v-model="zq_formData.username" placeholder="请输入用户名" />
            </FormItem>
          </i-Col>
        </Row>
        <Row>
          <i-Col span="24">
            <FormItem label="密码：" prop="password" label-position="top">
              <Input v-model="zq_formData.password" placeholder="请输入密码" />
            </FormItem>
          </i-Col>
        </Row>
      </Form>
      <div class="demo-drawer-footer">
        <Button type="primary" @click="ok">保存</Button>
        <Button style="margin-right: 8px" @click="drawer = false">关闭</Button>
      </div>
    </Drawer>

    <!--  详情弹出抽屉  +++++++++++++++++++++++++++++++++++++++++++++++++++++     -->
    <Drawer ref="zq_zq_formData_detail" :title="titleValue[dialogStatus]" v-model="drawer_detail" width="30%" :mask-closable="true" :styles="drawerStyles">
      <Form :model="zq_zq_formData_detail" label-position="right" :label-width="120">
        <Row>
          <i-Col span="24">
            <FormItem label="用户名：">
              <i-input v-model="zq_zq_formData_detail.username" disabled></i-input>
            </FormItem>
          </i-Col>
        </Row>
        <Row>
          <i-Col span="24">
            <FormItem label="密码：">
              <i-Input v-model="zq_zq_formData_detail.password" disabled></i-Input>
            </FormItem>
          </i-Col>
        </Row>
        <Row>
          <i-Col span="24">
            <FormItem label="性别：">
              <i-Input v-model="zq_zq_formData_detail.sex" disabled></i-Input>
            </FormItem>
          </i-Col>
        </Row>
      </Form>
    </Drawer>
  </div>
</template>
<script>
  import {
    getDemoListPage,
    getDemoList,
    saveOrUpdateDemo,
    deleteDemo
  } from '@/api/zhengqing/demo' //抽取出去的js  -> 作用：发送请求
  import {forEach} from '../../libs/tools'

  export default {
    name: 'zq-app',
    data () {
      //校验
      const validateUsername = (rule, value, callback) => {
        if (!value) {
          callback(new Error('请输入用户名！！！'))
        } else {
          callback()
        }
      };
      const validatePassword = (rule, value, callback) => {
        if (!value) {
          callback(new Error('请输入密码！！！'))
        } else {
          callback()
        }
      };
      return {
        //高级查询需要传到后端的参数
        zqListQuery: {
          page: 1,
          pageSize: 10,
          username: undefined,
          password: undefined,
        },
        list: undefined,//表格数据
        total: undefined,//总数据条数
        drawer: false, // 添加和编辑抽屉弹出页
        drawer_detail: false, // 详情抽屉弹出页
        listLoading: false,//是否加载
        dialogStatus: '',//title自定义标题
        titleValue:{
          create:"新增",
          detail:"详情",
          update:"编辑"
        },//title信息
        zq_formData: {
          username: undefined, // 用户名
          password: undefined, // 密码
          sex: undefined // 性别
        },
        zq_zq_formData_detail: {
          username: undefined, // 用户名
          password: undefined, // 密码
          sex: undefined // 性别
        },
        //表格数据
        columns: [
          {
            title: '用户名',
            key: 'username',
            align: 'center',
            width: 300
          },
          {
            title: '密码',
            key: 'password',
            align: 'center'
          },
          {
            title: '性别',
            key: 'sex',
            align: 'center'
          },
          {
            title: '操作',
            align: 'center',
            slot: 'action'
          }
        ],
        // 抽屉样式
        drawerStyles: {
          height: 'calc(100% - 55px)',
          overflow: 'auto',
          paddingBottom: '53px',
          position: 'static'
        },
        //校验
        ruleFormData: {
          username: [
            {
              required: true,
              validator: validateUsername,
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              validator: validatePassword,
              trigger: 'blur'
            }
          ]
        }
      }
    },
    created () {
      this.getListPage();//高级查询
      this.getFormatList();//这里可以放一些需要format的请求或者其它
    },
    methods: {
      getFormatList () {
        getDemoList().then(res => {
          this.userNameList = res.data.data;// 对应选择器 value和label
        });
      },
      getListPage () {
        this.listLoading = true;
        getDemoListPage(this.zqListQuery).then(res => {
          var records = res.data.data.records;
          /*if (records.length > 0) {
            for (var i = 0; i < records.length; i++) {
              records[i].dateTime = new Date(records[i].dateTime);// TODO 处理时间格式化滴
              //TODO 处理状态滴
              if (records[i].state == 0){
                records[i].state = "未处理";
              }
            }
          }*/
          this.list = records;
          this.total = res.data.data.total;
          this.listLoading = false
        })
      },
      handleCreate () {
        this.dialogStatus = 'create';//对应标题
        this.getFormatList();
        this.resetFormColumns();//重置
        this.drawer = true;//弹出抽屉修改为显示状态
      },
      handleUpdate (row) {
        this.zq_formData = Object.assign({}, row);//回显数据
        this.dialogStatus = 'update';
        this.getFormatList();
        this.drawer = true;
      },
      handleDetail (row) {
        this.zq_zq_formData_detail = Object.assign({}, row);
        this.dialogStatus = 'detail';
        this.drawer_detail = true
      },
      handleDelete (row) {
        deleteDemo({ id: row.id })
          .then(response => {
            if (response.data.status == 1) {
              this.getListPage();
              this.$notify({
                title: '成功',
                message: '删除成功',
                type: 'success',
                duration: 2000
              })
            } else {
              this.$message({
                message: response.data.message,
                type: 'error'
              })
            }
          })
          .catch(err => {
            this.fetchSuccess = false;
            console.log(err);
          })
      },
      ok () {
        this.$refs.zq_formData.validate(valid => {
          if (valid) {
            saveOrUpdateDemo(this.zq_formData)
              .then(response => {
                if (response.data.status == 1) {
                  this.getListPage();
                  this.$Notice.success({
                    title: '成功',
                    desc: '保存成功',
                    duration: 2
                  });
                  this.drawer = false;
                } else {
                  this.$message({
                    message: response.data.message,
                    type: 'error'
                  })
                }
              })
              .catch(err => {
                this.fetchSuccess = false;
                console.log(err);
              })
          }
        })
      },
      cancel () {
        this.drawer = false;
      },
      handleSizeChange (val) {
        this.zqListQuery.pageSize = val;
        this.getListPage();
        this.getFormatList();
      },
      handleCurrentChange (val) {
        this.zqListQuery.page = val;
        this.getListPage();
        this.getFormatList();
      },
      resetFormColumns () {
        this.zq_formData = {
          username: undefined, // 用户名
          password: undefined, // 密码
          sex: undefined // 性别
        }
      }
    }
  }
</script>
<!-- 样式 -->
<style lang="less" scoped>
  .demo {
    .demo-title {
      height: 70px;
      line-height: 70px;
      background: #2b3b65;
      padding-left: 20px;
      font-size: 24px;
      color: #fff;
    }
  }
  .demo-drawer-footer {
    width: 100%;
    position: absolute;
    bottom: 0;
    left: 0;
    border-top: 1px solid #e8e8e8;
    padding: 10px 16px;
    text-align: center;
    background: #fff;
  }
</style>
