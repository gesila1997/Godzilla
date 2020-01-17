<template>
 <div class="demo">
      <!--header-->
      <div class="header">
          <div class="bg_header">
              <div class="header_nav">
                  报工数据展示
              </div> 
          </div>
      </div>

      <div class="main">
  
        <div class="main_demo">
        <div class="main_text"> 
                <el-row :gutter="6">
                  <el-col :lg="3"><div class="grid-content bg-purple">工单批号</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">膜型号</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">客户</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">完工时间</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">机台</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">领料数量</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">破损公斤</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">成品数量</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">样卷</div></el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple">打样次数</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">对花</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">刀线</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">接头</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">打皱</div></el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple">其它</div></el-col>
                </el-row>
        </div>
        <div class="main_text2" ref="scroll">


        <div class="free-scroll-container">
          <div class="free-scroll-wrapper">
            <div class="scroll-wrapper" ref="wrapper">
              <div class="scroll-content">
                <div class="main_text2_1" v-for="(item,submitted) in Conselect" :key="submitted">
                    <!-- v-for="(item,Production) in Proselect" :key="Production" -->
                  <el-row :gutter="10">
                  <el-col :lg="3"><div class="grid-content bg-purple2">{{item.poId}}   </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.mtype}}  </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.client}} </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.acctime}}</div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.no}}     </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.getnum}}     </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.damageNum}}  </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.madeNumb}}   </div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.sampleNumb}} </div>   </el-col>
                  <el-col :lg="2"><div class="grid-content bg-purple2">{{item.samplecount}}</div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.duihua}}  </div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.daoxian}} </div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.jitou}}   </div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.dazou}}   </div>   </el-col>
                  <el-col :lg="1"><div class="grid-content bg-purple2">{{item.other}}   </div>   </el-col>
                </el-row>
                </div>
              </div>
            </div>
          </div>
        </div> 
      </div> 
    </div>  
  </div>
</div>
</template>
<script>
import bg10 from "@/assets/images/10.png";
import BScroll from '@better-scroll/core';
export default {
 name: 'SubMitted', 
 data(){
     return{     
      Conselect:[]         
     }
 },
methods: {
get() { 
   this.$axios.get("/Conselect").then(res => {
         this.Conselect = res.data;
        //  console.log(this.Conselect)
        //  let vo203 = (this.Proselect.length)*42-720;
        //  if(this.proction==true){
        //   this.scroll.scrollTo(0, -vo203,vo203*150)
        //   // console.log("我要下去"+vo203+"px"+vo203*15)         
        //  }
        //  var that =this;
        //  setTimeout(function () { 
        //   that.scroll.scrollTo(0, 0,vo203*150)
        //   // console.log("我要上去"+vo203+"px"+vo203*15)
        //  }, vo203*150);
  })
  var that =this;
  setTimeout(function () { 
      that.init();
         }, 1000); 
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
          bottom: true,
          bounceTime:300
            }, 
        }   )     
}
},
mounted(){
  this.get();
}
}
</script>
<style scoped>
.demo{
 width: 90%;
 height: 950px;
 margin-left: 10%;
 position:absolute;
 background-image: url(..\assets\images\10.png);
 
}

/*header开始*/
.header{
    width: 100%;
    height: 80px;
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
      background:
            linear-gradient(to bottom,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to right,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to bottom,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to left,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to top,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to right,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to top,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right bottom no-repeat,
            linear-gradient(to left,#5567c9 0px,#33cdfa 3px,transparent 3px,transparent 100%) right bottom no-repeat;
    background-size: 18px 18px;
    padding:4px;
    position:relative;
}

.main_demo{
    border:1px solid #383e61;
    /* border-top: none; */
    width:auto;
    height:100%;
    background: rgba(64, 65, 65, 0.4);
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