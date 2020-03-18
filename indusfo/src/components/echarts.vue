<template>
<div class="Demo">
        <div class="Text" >
            <div class="Text_1">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <dv-border-box-12>  
                <div class="Text_1_1"  v-if="loading">
                  <div class="Text_1_1_1">
                    &nbsp;今日生产:<span class="num">{{this.todaysum.prac}}</span>米<span class="textstryle">达成率{{this.todaysum.ratio}}</span>
                  </div>
                  <div class="Text_1_1_2">
                    &nbsp;<span>今日交付:<span class="num">{{this.todaysum.plans}}</span>米</span>
                  </div>
                  </div>
                <div class="Text_1_2"  v-if="loading">
                  <div class="Text_1_1_1">
                    <p class="posum">{{this.pnosum.no1}}米</p>
                  </div>
                  <div class="Text_1_1_2">
                    <div class="style2"></div>
                    <span class="yield">1号机台今日产量</span>
                  </div></div>
                <div class="Text_1_3"  v-if="loading">
                  <div class="Text_1_1_1">
                    <p class="posum">{{this.pnosum.no2}}米</p>
                  </div>
                  <div class="Text_1_1_2">
                    <div class="style2"></div>
                    <span class="yield">2号机台今日产量</span>
                    </div>
                  </div>
                <div class="Text_1_4"  v-if="loading">
                  <div class="Text_1_1_1">
                    <p class="posum">{{this.pnosum.no3}}米</p>
                  </div>
                  <div class="Text_1_1_2">
                    <div class="style2"></div>
                    <span class="yield">3号机台今日产量</span>
                  </div>
                </div>
              </dv-border-box-12>  
            </div>
            <div class="Text_2"> 
              <dv-loading v-if="!loading">Loading...</dv-loading>  
              <!-- <dv-border-box-8> -->
              <div class="map" id="mapcharts" v-if="loading"></div>
              <!-- </dv-border-box-8> -->
            </div>
            <div class="Text_3">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <dv-border-box-7>
              <div class="ring" id="ring"  v-if="loading"></div>
              <div class="stylering"></div>
              </dv-border-box-7>
            </div>  
            <div class="Text_4">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <dv-border-box-7>
              <div class="Text_4_1" id="main"  v-if="loading"></div>
              </dv-border-box-7>
            </div>
        </div>
        <div class="Text2">
            <div class="Text2_1">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <ve-histogram
                :data="chartData5"
                :height="height"
                :extend="chartExtendhi"
                :settings="settingshi"
                 v-if="loading"
              ></ve-histogram>
            </div>
            <div class="Text2_2">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <div class="style"></div>
              <ve-ring
                :data="chartData2"
                :settings="chartSettings2"
                :extend="chartExtend"
                :height="height"
                :width="width"
                 v-if="loading"
              ></ve-ring>
            </div>
            <div class="Text2_3">
              <dv-loading v-if="!loading">Loading...</dv-loading>
              <ve-histogram
                :data="chartData"
                :settings="chartSettings"
                :height="height"
                :extend="hi2chartExtend"
                 v-if="loading"
              ></ve-histogram>
            </div>
        </div>
</div>      
</template>
<script>
import echarts from "echarts";
require('echarts/map/js/china')
export default {
  name: "EchaRts",
  components:{
  },
  data() {
    (this.chartSettings4 = {
      metrics: ["访问用户"],
      dataOrder: {
        label: "访问用户",
        order: "asc"
      },
      itemStyle: {
        barWidth: "10%"
      }
      }),
    (this.chartSettings  = {
        showLine: ["num"],
        axisSite: { right: ["num"] },
        yAxisType: ["KMB", "percent"],
        yAxisName: ["米数", "完工率"],
        yAxis:[{
         type:'KMB',
         name:'米数'
        },
        {
         type:'percent',
         name:'完工率'
        }
        ],
        labelMap: {
          pnum: "计划数量",
          anum: "实际完成数量",
          num: "完工率"
        }
        }
        ),
    (this.chartSettings2 = {
        dataType: "KMB",
        series: [
          {
            showLegendSymbol: false
          }
        ]
        // dimension: 'productName',
        // metrics: 'rate'
      }),
    (this.chartExtend    = {
        series: {
          type: "pie",
          radius: ["50%", "80%"],
          center: ["35%", "50%"],
          avoidLabelOverlap: false,
          label: {
            //去除饼图的指示折线label
            show: false
          }
        },

        legend: {
          show: true,
          orient: "vertical",
          x: "70%",
          y: "center",
          data: [],
          textStyle: {
            color: "#fff",
            fontStyle: "normal",
            borderRadius: "80%",
            padding: [2, 2, 2, 6]
          }
        }
      }),
    (this.settingshi     = {
        yAxisType: ["normal"],
        yAxisName: ["米数"],
        labelMap: {
          times: "时间",
          no1: "1号机台",
          no2: "2号机台",
          no3: "3号机台"
        }
      }),
    (this.chartExtendhi  = {
        xAxis: {
          type: "category",
          //设置坐标轴字体颜色和宽度
          axisLine: {
            //这是x轴文字颜色
            lineStyle: {
              color: "#fff"
            }
          }
        },
        yAxis: {
          type: "value",
          //设置坐标轴字体颜色和宽度
          axisLine: {
            //这是y轴文字颜色
            lineStyle: {
              color: "#fff"
            }
          }
        },
        legend: {
          textStyle: {
            color: "#fff"
          }
        },
        grid: {
          top: 50,
          left: 10,
          right: 15,
          bottom: 5
        }
      }),

   
    (this.barchartExtend = {
        yAxis: {
          axisLine: {
            //这是y轴文字颜色
            lineStyle: {
              color: "#fff"
            }
          }
        },
        xAxis: {
          axisLine: {
            //这是x轴文字颜色
            lineStyle: {
              color: "#fff"
            }
          }
        },
        series: [
          {
            type: "bar",
            barWidth: "10%",
            encode: {
              // Map the "amount" column to X axis.
              x: "amount",
              // Map the "product" column to Y axis
              y: "product"
            }
          }
        ],
        grid: {
          top: 60,
          left: 10,
          right: 10,
          bottom: 20
        }
      }),
    (this.hi2chartExtend = {
        // barWidth : 15,//柱图宽度
        yAxis: {
          axisLine: {
            //这是y轴文字颜色
            lineStyle: {
              color: "#FFF"
            }
          },
        },
        xAxis: {
          axisLine: {
            //这是x轴文字颜色
            lineStyle: {
              color: "#FFF"
            }
          },
          axisLabel: {
            interval: 0 //代表显示所有x轴标签
            // rotate:10,
          }
        },
        grid: {
          top: 60,
          left: 10,
          right: 10,
          bottom: 20
        },
        legend: {
          show: true,
          textStyle: {
            color: "#fff",
            fontStyle: "normal",
            borderRadius: "80%",
            padding: [1, 1, 1, 2]
          }
        },
        label: {
    		show: true, //开启显示
    		position: 'top', //在上方显示
    		textStyle: { //数值样式
    		    color: 'black',
    			fontSize: 14,
    			fontWeight: 600
    			}
    		}
        // tooltip: {
        // formatter: function (params) {
        //       //格式化函数
        //     //  console.log(as+"我都没有打印")
        //     return '计划数量：'+params.pnum+'</br>'+'实际数量：'+params.anum
        //   }
        // }
      })
    return {
      chartData : {
        columns: ["time", "pnum", "anum", "num"],
        rows: []},
      chartData2: {
        columns: ["productName", "rate"],
        rows: []},

      chartData5: {
        columns: ["times", "no1", "no2", "no3"],
        rows: []},
      fuck:     [],
      fuckyou:  [],
      ringdata: [],
      ringdata2:[],
      data     :[],
      todaysum :[],
      pnosum   :[],
      fixStyle : '',
      loading  :false
    };
    },
    methods: {
    // closeMain(val){
    //     let result = val;
    //     console.log(result+'我是爸爸组件')
    //     if(result=='production'){
    //       console.log(result+'我是生产页面,请让我显示')
    //       this.index=false
    //       this.proction=true
    //       this.submitted=false
    //     }
    //     if(result=='index'){
    //       console.log(result+'我是首页页面,请让我显示')
    //       this.index    =true
    //       this.proction =false
    //       this.submitted=false
    //     }
    //     if(result=='submitted'){
    //       console.log(result+'我是报工页面,请让我显示')
    //       this.index    =false
    //       this.proction =false
    //       this.submitted=true
    //     }
    // },
    drawChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("main"));
      // 指定图表的配置项和数据
      var option = {
        title: {
          show: true,
          text: "月产量",
          x: "center",
          textStyle: {
            //主标题文本样式
            fontfamily: "italic",
            fontSize: 16,
            color: "#fff"
          }
        },
        color: ["#00E5EE"],
        tooltip: {
          trigger: "axis",
          axisPointer: {
            // 坐标轴指示器，坐标轴触发有效
            type: "line" // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          show: false,
          data: ["总产量"],
          textStyle: {
            color: "#fff"
          },
          x: "2%"
        },
        grid: {
          left: "3%",
          right: "8%",
          bottom: "12%",
          top: "10%",
          containLabel: true
        },
        xAxis: {
          type: "value",
          name: "米数",
          axisLine: {
            //这是y轴文字颜色
            lineStyle: {
              color: "#FFF"
            }
          }
        },
        yAxis: {
          type: "category",
          data: this.fuckyou,
          axisLine: { 
            lineStyle: { 
              color: "#FFF" 
              } 
            }
        },
        visualMap: {
          orient: "horizontal",
          left: "center",
          min: 0,
          max: 50000,
          // text: ['低', '高'],
          // Map the score column to color
          dimension: 0,
          inRange: {
            color: ["#5F9EA0","#87CEFA"]
          }
        },
        series: [
          {
            name: "总产量",
            type: "bar",
            barWidth: "80%",
            stack: "总量",
            label: {
              normal: {
                show: true, //显示柱状图上的数值
                position: "insideRight"
              }
            },
            encode: {
              // Map the "amount" column to X axis.
              x: "amount",
              // Map the "product" column to Y axis
              y: "product"
            },
            data: this.fuck
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    ringChart() {
      let myChart = this.$echarts.init(document.getElementById("ring")); 
      var option = {
         title: [{
          text: "不良占比",
          x: "35%",
          textStyle: {
            //主标题文本样式
            fontfamily: "italic",
            fontSize: 20,
            color: "#fff"
          }
          },
          {
          subtext:"历史不良占比",
          x:'13%',
          y:'8%',
          subtextStyle:{
            color: "#fff"
          }
          },
          {
          subtext:"今日不良占比",
          x:'68%',
          y:'8%',
          subtextStyle:{
            color: "#fff"
          }
          },
         ] ,
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "38%",
          y: "center",
          icon: "circle",
          textStyle: {
                color: "#fff"
              },
          data: [ '对花','接头','刀线','打皱']
        },
        // color :['#9dfbfb','#009E8E','#06799F','#CCFFFF','#5df9f8','#6699cc','#66CCCC'],
        series: [
          {
            name: "不良占比",
            type: "pie",
            radius: ["50%", "75%"],
            center: ["20%", "60%"],
            avoidLabelOverlap: false,
            itemStyle: {
                emphasis: {
                    shadowBlur: 1,
                    shadowOffsetX: 0,
                    shadowColor: '#fff',
                },  
                normal: {
                    label: {
                        show: true,
                        formatter: '{c}M',
                        position: 'inner',
                        textStyle:{
                         color:'#FFF',
                         fontSize:'11'
                        }
                    },
                    labelLine: {
                        show: true,
                    }
                },

            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: this.ringdata2
          },
          {
            name: "今日不良",
            type: "pie",
            radius: ["50%", "75%"],
            center: ["75%", "60%"],
            avoidLabelOverlap: true,
            itemStyle: {
                emphasis: {
                    shadowBlur: 1,
                    shadowOffsetX: 0,
                    shadowColor: '#fff',
                },  
                normal: {
                    label: {
                        show: true,
                        formatter: '{c}M',
                        position: 'outside',
                        textStyle:{
                         color:'#FFF',
                         fontSize:'11'
                        }
                    },
                    labelLine: {
                        show: true,
                    }
                },

            },
            emphasis : {
              label :{
                show: true,
                position : 'center',
                textStyle :{
                  fontSize : '18',
                  fontWeight : 'bold'
                }
              }
            },
            data:this.ringdata
          }
        ]
      };
      myChart.setOption(option);
    },
    mapChart () {
      let myChart = this.$echarts.init(document.getElementById("mapcharts"));  
      var yData = [];
      this.data.sort(function(o1, o2) {
          if (isNaN(o1.value) || o1.value == null) return -1;
          if (isNaN(o2.value) || o2.value == null) return 1;
          return o1.value - o2.value;
      });
      for (var i = 0; i < this.data.length; i++) {
          yData.push(this.data[i].name);
      }
      var option = {
          title: {
              text: '全国客户分布图',
              textStyle: {
                  fontSize: 26,
                  color:"#FFF"
              },
              x: '30%',
              y: '10%'
          },
          tooltip: {
              show: false,
              formatter: function(params) {
                  return params.name + '：' + params.data['value']+'个'
              },
          },
          visualMap: {
              type: 'continuous',
              text: ['', ''],
              showLabel: true,
              seriesIndex: [0],
              min: 0,
              max: 20,
              inRange: {
                  color: ['#87CEFA',"#5F9EA0","#2F4F4F"]
              },
              textStyle: {
                  color: '#000'
              },
              bottom: 30,
              left: '5%'
          },
          grid: {
              right: 10,
              top: 80,
              bottom: 30,
              width: '20%'
          },
          xAxis: {
              type: 'value',
              scale: true,
              position: 'top',
              splitNumber: 1,
              boundaryGap: false,
              splitLine: {
                  show: false
              },
              axisLine: {
                  show: false
              },
              axisTick: {
                  show: false
              },
              axisLabel: {
                  margin: 2,
                  textStyle: {
                      color: '#FFF'
                  }
              }
          },
          yAxis: {
              type: 'category',
              nameGap: 16,
              axisLine: {
                  show: false,
                  lineStyle: {
                      color: '#ddd'
                  }
              },
              axisTick: {
                  show: false,
                  lineStyle: {
                      color: '#ddd'
                  }
              },
              axisLabel: {
                  interval: 0,
                  textStyle: {
                      color: '#FFF'
                  }
              },
              data: yData
          },
          geo: {
              roam: false,
              map: 'china',
              aspectScale: 0.75,
              zoom: 1.2,
              x   : "15%",
              layoutSize: '60%',
              itemStyle:{
              normal:{
              label:{show:true},
              areaStyle:{
              color:'green'
              }, //设置地图背景色的颜色设置
              color:'#8EE5EE' //刚才说的图例颜色设置
              },
              emphasis:{
                areaColor :'#00FFFF',
                label:{show:true}}
              },
              regions: [{
                  name: '南海诸岛',
                  value: 0,
                  itemStyle: {
                      normal: {
                          opacity: 0,
                          label: {
                              show: true
                          }
                      }
                  }
              }],
          },
          series: [{
              name: 'mapSer',
              type: 'map',
              roam: false,
              geoIndex: 0,
              label: {
                  show: false,
              },       
              data: this.data
          }, {
              name: 'barSer',
              type: 'bar',
              roam: false,
              visualMap: true,
              zlevel: 2,
              barMaxWidth: 20,
              itemStyle: {
                  normal: {
                      color: "#A6FFFF"
                  },
                  emphasis: {
                      color: "#3596c0"
                  },                     
              },
              label: {
                  normal: {
                      show: false,
                      position: 'right',
                      offset: [0, 10]
                  },
                  emphasis: {
                      show: true,
                      position: 'right',
                      offset: [10, 0]
                  },                 
              },
              data: this.data
          }]
      };
       myChart.setOption(option);
    },
  get() { 
      this.$axios.get("/select"    ).then(response => {
        let res = response.data;
        this.chartData2.rows = [];
        for (let i = 0; i < res.length; i++) {
          this.chartData2.rows.push(res[i]);
          this.chartExtend.legend.data.push(res[i].productName);
        }}),
      this.$axios.get("/Psumselect").then(res => {
          let Psumselect = res.data;
          //  console.log(Psumselect)
          this.chartData.rows = [];
          for (let i = 0; i < Psumselect.length; i++) {
            this.chartData.rows.push(Psumselect[i]);
          }
        }),
      this.$axios.get("/Pnoselect" ).then(res => {
          let Pnoselect = res.data;
          this.pnosum   = Pnoselect[0]
          //  console.log(this.pnosum)
          this.chartData5.rows = [];
          for (let i = 0; i < Pnoselect.length; i++) {
            this.chartData5.rows.push(Pnoselect[i]);
          }
        });
      this.$axios.get("/Todayselect" ).then(res => {
           let Todayselect = res.data
           this.todaysum =Todayselect[0]})
         },
  async  demoTest() {
      this.fuck     = await this.demo();
      this.fuckyou  = await this.demo3();
      this.ringdata = await this.demo4();
      this.ringdata2= await this.demo5();
      this.data     = await this.demo6();
      this.drawChart();
      this.ringChart();
      this.mapChart ();
    },
  demo() {
      return new Promise((resolve, reject) => {
        this.$axios.get("/Pmoselect").then(res => {
          let Pmoselect = res.data;
          var a = [];
          for (let i=Pmoselect.length-1;i>=0;i--) {
            //循环数组
            a.push(Pmoselect[i].sum);
          }
          resolve(a);
        });
      });
    },
  demo3(){
     return new Promise((resolve, reject) => {
        this.$axios.get("/Pmoselect").then(res => {
          let Pmoselect = res.data;
          let b = [];
          for (let i=Pmoselect.length-1;i>=0;i--) {
            //循环数组
            b.push(Pmoselect[i].time);
          }
          resolve(b)
        });
      });
      },
  demo4(){
    return new Promise((resolve, reject) => {
        this.$axios.get("/Pdaselect").then(res => {
          let Pdaselect = res.data;
          var arr = [];
          for(var i =0;i<Pdaselect.length;i++){
              var obj ={
                    '对花' : Pdaselect[i].duihua,
                    '刀线' : Pdaselect[i].daoxian,
                    '接头' : Pdaselect[i].jietou,
                    '打皱' : Pdaselect[i].dazou
              }
              arr.push(obj);
                }
          let result = arr[0];
          var arr2 = [];  
          for(let i in result){
              let o={name:i,value:result[i]};
              arr2.push(o);
          }
          resolve(arr2)
        });
      });
    },
  demo5(){
     return new Promise((resolve, reject) => {
      this.$axios.get("/PHiselect").then(res => {
          let PHiselect = res.data;
          var arr = [];
          for(var i =0;i<PHiselect.length;i++){
              var obj ={
                    '对花' : PHiselect[i].duihua,
                    '刀线' : PHiselect[i].daoxian,
                    '接头' : PHiselect[i].jietou,
                    '打皱' : PHiselect[i].dazou
              }
              arr.push(obj);
                }
          let result = arr[0];
          var arr2 = [];      
          for(let i in result){
              let o={name:i,value:result[i]};
              arr2.push(o);
          }
          resolve(arr2)
        });
     })
     },
  demo6(){
      return new Promise((resolve, reject) => {
          this.$axios.get("/PClselect" ).then(res => {
          let PClselect = res.data;   
          var arr=[]
          for (let i = 0; i < PClselect.length; i++) {
           arr.push(PClselect[i]);   
          }
          this.loading=true
          resolve(arr)
       });     
      });
    } 
    },
  mounted() {
    this.get();
    this.demoTest();
    this.timer = setInterval(this.get, 300000);  
  },
  beforeDestroy() {
    clearInterval(this.timer);
  },
  created() {
    (this.height = "100%"), (this.width = "100%"); 
  }
};
</script>
<style scoped>
.map{
  width: 100%;
  height: 100%;
}
* {
  margin: 0;
  padding: 0;
}
.Demo {
  width: 90%;
  height: 950px;
  margin-left:10%;
  position:absolute;
}
.Text {
  width: 75%;
  height: 98%;
  float: left;
}

.Text2 {
  width: 23%;
  height: 98%;
  float: left;
  margin-left: 1%;
}
.Text_1 {
  width: 100%;
  height: 10%;
  background:rgba(43, 43, 43, 0.5);
}

.Text_2 {
  width: 100%;
  height: 62%;
  margin-top: 1%;
  background:rgba(43, 43, 43, 0.4);
  /* background-size: 109% 176%;
  url(..\assets\images\border.png) 
  background-position-x: 52%;
  background-position-y: 37%; */
}
.Text_3 {
  width: 49%;
  height: 25%;
  margin-top: 1%;
  float: left;
  background:rgba(43, 43, 43, 0.4);
}

.Text_4 {
  width: 49%;
  height: 25%;
  margin-top: 1%;
  float: right;
  margin-left: 1%;
  background:rgba(43, 43, 43, 0.5);
}
.Text_4_1{
  width: 100%;
  height: 100%;
}
.Text2_1 {
  width: 100%;
  height: 25%;
  margin-top: 9%;
  background:rgba(43, 43, 43, 0.5);
}

.Text2_2 {
  width: 100%;
  height: 25%;
  margin-top: 5%;
  background:rgba(43, 43, 43, 0.5);
}

.Text2_3 {
  width: 100%;
  height: 42.2%;
  margin-top: 5%;
  background:rgba(43, 43, 43, 0.5);
}
.posum{
  text-align: center;
}
.ring {
  width: 99%;
  height: 100%;
  float: left;
}

.Text_1_1 {
  width: 24%;
  height: 100%;
  float: left;
}
.Text_1_2 {
  width: 23%;
  height: 100%;
  margin-left: 2%;
  float: left;
}
.num{
  color: rgb(66, 185, 42);
  font-size: 18px;
  margin-left: 1%
}
.Text_1_3 {
  width: 23%;
  height: 100%;
  margin-left: 2%;
  float: left;
}

.Text_1_4 {
  width: 24%;
  height: 100%;
  float: right;
}

.Text_1_1_1 {
  width: 100%;
  height: 50%;
  margin-left: 2%;
  font-size: 16x;
  font-family: cursive;
  color: rgb(255, 255, 255);
  line-height: 50px;
}
 .textstryle{
  font-family: "Courier New", Courier, monospace;
  font-size: 18px;
  color: rgb(255, 255, 255);
  line-height: 55px;
  /* margin-left: 18%; */
  float: right;
 }


  .yield{
  
  font-family: cursive;
  font-size: 16px;
  color: rgb(255, 255, 255);
  line-height: 40px;
  margin-left: 25%;
  float: left;

  }

.Text_1_1_2 {
  width: 95%;
  height: 50%;
  margin-left: 2%;
  border:2px solid #535a83;
  border-left: none;
  border-right: none;
  border-bottom: none;
  font-family: cursive;
  line-height:40px;
  font-size: 16x;
  color: rgb(255, 255, 255);
}
</style>