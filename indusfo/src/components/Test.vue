<template>
    <div class="demo">
      <dv-border-box-11 title="生产大数据展示">
      <!-- header -->
      <div class="header">
          <!-- <div class="bg_header">
              <div class="header_nav">
              </div> 
          </div> -->
      </div>
      <div class="main">
        <div class="main_demo">
        <div class="main_text"> 
                <el-row :gutter="8">
                  <el-col :lg="4"><div class="grid-content bg-purple">计划单号</div></el-col>
                  <el-col :lg="3"><div class="grid-content bg-purple">客户代码</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">规格型号</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">建单日期</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">交货日期</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">计划米数</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">完工米数</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">计划状态</div></el-col>
                  <el-col :lg="5"><div class="grid-content bg-purple">生产要求</div></el-col>
                </el-row>
        </div>
        <div class="main_text2" ref="scroll">
        <div class="free-scroll-container">
          <div class="free-scroll-wrapper">
            <div class="scroll-wrapper" ref="wrapper">
              <div class="scroll-content">
                <div class="main_text2_1" v-for="(item,Production) in Proselect" :key="Production">
                  <el-row :gutter="10">
                  <el-col :lg="4"><div class="grid-content bg-purple2">{{item.po}}</div>      </el-col>
                  <el-col :lg="3"><div class="grid-content bg-purple2">{{item.cname}}</div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.prdtName}}</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.cdate}}</div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.jdate}}</div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.mcount}}</div>  </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.fqty}}</div>    </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.postatus}}</div></el-col>
                  <div class="grid-content bg-purple3">{{item.permark}}</div>
                </el-row>
                </div>
              </div>
            </div>
          </div>
        </div> 
      </div> 
    </div>  
  </div>
 </dv-border-box-11> 
</div>
</template>
<script>
import bg10 from "@/assets/images/10.png";
import BScroll from '@better-scroll/core';
export default {
name: 'ProduCtion',
data(){
  return{
     Proselect:[],
     loading :true
    }
  },
methods: {
get() { 
   this.$axios.get("/Proselectss").then(res => {
         let Proselect = res.data;
         let vo203 = (this.Proselect.length)*42-720;
         this.init();
         
         let text=[];
         for (let i = 0; i < Proselect.length; i++) {
            text.push(Proselect[i]);
          }
         // console.log(text.values(Proselect[0]))
        //  if(this.proction==true){
          //  console.log(Object.values(Proselect[0]))
          this.scroll.scrollTo(0, -vo203,vo203*100)     
        //  }
        //  var that =this;
        //  setTimeout(function () { 
        //   that.scroll.scrollTo(0, 0,vo203*150)
        //  }, vo203*150);
        
  })
},
init () {
        this.scroll = new BScroll(this.$refs.wrapper, {
          scrollY: true,
          click: true,
          probeType: 3, // listening scroll hook
          HWCompositing: true,
          momentum    :true,
          deceleration :0.01,         
          bounce: {
          top: true,
          bottom: false,
          bounceTime:300
            }, 
// 滚动到某个位置，x,y 代表坐标，time 表示动画时间，easing 表示缓动函数
        }   )     
},
},
mounted() { 
  // this.$axios.get("/Proselect").then(res => {
  //   let Proselect = res.data;
  //   let vo203 = (Proselect.length)*42-720;
  //   let vo202 = (vo203*160)*2
  //   let that = this;
  //     that.init();
  //     setTimeout(function () { 
  //     that.get();
  //   console.log("我执行了")}, 1000);
  //   that.timer = setInterval(that.get, vo202);
  // })
  this.get();
 }, 
beforeDestroy() {
    clearInterval(this.timer);
  },
    }
</script>
<style scoped>
.demo{
 width: 90%;
 height: 950px;
 margin-left: 10%;
 position:absolute;
}

/*header开始*/
.header{
    width: 100%;
    height: 6%;
    /* /* padding:0 20px; */
    min-width: 1366px; 
    
}
.bg_header{
    width: 100%;
    height: 80px;
    background: url(..\assets\images\title.png) no-repeat;
    background-size: 100% 100%;
}
.header_nav{
    text-align: center;
    font-size: 32px;
    color: rgb(180, 251, 253);
    font-family: cursive;
    line-height: 70px;
}
.main{
  width:auto;
  height: 90%;
  /* background:
            linear-gradient(to bottom,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to right,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to bottom,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to left,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to top,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to right,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to top,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right bottom no-repeat,
            linear-gradient(to left,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right bottom no-repeat;
    background-size: 18px 18px; */
    padding:4px;
    position:relative;
    /* background:rgba(43, 43, 43, 0.5); */
}

.main_demo{
    border:1px solid #383e61;
    /* border-top: none; */
    width:98%;
    height:100%;
    margin: auto;
    background:rgba(43, 43, 43, 0.5);
    background:url(..\assets\images\10.png);
}

/* .el-col {
    border-radius: 4px;
  } */
.bg-purple-dark {
    background: #99a9bf;
  }
.bg-purple {
    background: #39485799;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    color: #FFF;
    text-align: center;
    line-height: 40px;
  }
.bg-purple2{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    color: #FFF;
    text-align: center;
    line-height: 40px;} 
.bg-purple3{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    color: #FFF;
    text-align: center;
    line-height: 40px;
    width: 20%;
    float: right;
    overflow-x: auto;    /*x轴超出后可滚动*/
    white-space: nowrap;   /*实现子元素不换行*/
} 
.grid-content {
    border-radius: 4px;
    min-height: 36px;
}
.main_text{
  width: 100%;
  height: 5%;
}
.main_text2{
  width: 100%;
  height: 95%;
  overflow: hidden;
}

::-webkit-scrollbar {
    display: none;
}
.main_text2_1{
  width: 100%;
  height: 5%;
  background: rgba(107, 107, 107, 0.1);
  border:1px solid #979799;
  border-top: none;
  border-left: none;
  border-right: none;
  margin-top: 2px;
}
.xiantiao{
 background:linear-gradient(to bottom,#dd2926,#a82724) no-repeat right / 1px 20px;
}

.free-scroll-container{
  position: relative;
  width: 100%;
  height: 100%;
  }
  .free-scroll-wrapper{
    position: relative;
    width: 100%;
    height: 100%;
    box-sizing: border-box;
    }
    .scroll-wrapper{
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      overflow: hidden;
      }
</style>