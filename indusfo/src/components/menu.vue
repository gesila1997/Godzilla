<template>
<div>
    <div class="menu">     
     <el-menu
        :default-active="this.$route.path"
        class="el-menu-vertical-demo"
        text-color='#FFF'
        router
      >
        <p class="indextext">可视化工程</p>
        <el-menu-item @click='indexclick'>
          <i class="el-icon-s-home"></i>
          <span slot="title">首页看板</span>
        </el-menu-item>
        
        <el-menu-item @click='Productionclick'>
          <i class="el-icon-monitor"></i>
          <span slot="title">生产看板</span>
        </el-menu-item>

        <el-menu-item @click='Submittedclick'>
          <i class="el-icon-view"></i>
          <span slot="title">报工看板</span>
        </el-menu-item>
        
        <el-menu-item @click='Badnessclick'>
          <i class="el-icon-info"></i>
          <span slot="title">不良看板</span>
        </el-menu-item>
 
      </el-menu>
    </div> 
</div>  
</template>
<script>
export default {
    name: 'IndexMenu',
    data() {
    return {
    production   :2,
    index        :1,
    submitted    :3,
    Badness      :4
    }
    },
    methods:{
    Productionclick(){          
           this.$emit('closeMain',this.production);
       },
    indexclick(){          
           this.$emit('closeMain',this.index);
      },
    Submittedclick(){
           this.$emit('closeMain',this.submitted);
    },
    Badnessclick(){
           this.$emit('closeMain',this.Badness);
    },   
    }
}
</script>
<style>
.menu {
  width: 9%;
  height: 950px;
  position:absolute;
}

.el-menu-vertical-demo{
  width: 100%;
  height: 100%; 
 background:rgba(43, 43, 43, 0.5);  
}

.indextext{
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 20px;
  color: rgb(180, 251, 253);
  line-height: 50px;
  text-align: center;
}
.el-menu-item:hover{
  background-color: rgba(14, 221, 240, 0.32) !important;
}
.el-menu-item:focus{
  background-color: rgba(53, 121, 128, 0.32) !important;
}
</style>