<template>
 <div class="demo">
     <dv-border-box-11 title="生产大数据展示">
     <div class="ToolsMan2"></div>
     <div class="ToolsMan">
        <el-row :gutter="10">
                  <el-col :span="4"><div class="grid-content bg-purple">计划单号</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">客户代码</div></el-col>
                  <el-col :span="3"><div class="grid-content bg-purple">规格型号</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">建单日期</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">交货日期</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">计划米数</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">完工米数</div></el-col>
                  <el-col :span="2"><div class="grid-content bg-purple">计划状态</div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">生产要求</div></el-col>
                </el-row>
     </div>
     <div class="text">
       <div class="text_1">
         <dv-loading v-if="loading">Loading...</dv-loading>
         <dv-scroll-board :config="config" v-if="!loading"/>
      </div>
     </div> 
     </dv-border-box-11>
</div>   
</template>
<script>
export default {
 name: 'ProduCtion',
//  components:{ Loading  },
  data() {
    return{
    config : {} ,
    loading :true
    }
},
methods: {
get() { 
   this.$axios.get("/Proselect").then(res => {
      let Proselect = res.data;
      let resuelt=[];
      let resurltpuls=[];
      for (let i = 0; i < Proselect.length; i++) {
        resuelt.push(Object.values(Proselect[i]))
        if(resuelt.length>0){
        resurltpuls.push([resuelt[i][3],resuelt[i][6],resuelt[i][0],resuelt[i][2],resuelt[i][4],resuelt[i][1],resuelt[i][8],resuelt[i][7],resuelt[i][5]]
        )}
        }
        this.loading=false
        // console.log(resurltpuls)
        //  console.log(Proselect)
        // let resurltpuls=[resuelt[i][3],resuelt[i][6],resuelt[i][0],resuelt[i][2],resuelt[i][4],resuelt[i][1],resuelt[i][8],resuelt[i][7],resuelt[i][5]]  
        // console.log(resurltpuls)
        // var test= {prdtName: "K7015A-7", mcount: 6100, cdate: "2019-12-04", po: "PO20191204151644", jdate: "2019-12-06"}
        // var objs = [
        //   "a","b","c","d","e"
        // ];

        //   var arr = [];
        //   for(var i =0;i<objs.length;i++){
        //       var obj =[
        //              objs[0],
        //              objs[2],
        //              objs[3],
        //              objs[1]
        //       ]
        //       arr.push(obj);
        //         }
        // console.log(arr)
        // objs.sort(function(a,b){
        //     // order是规则  objs是需要排序的数组
        //     var order = ["po", "prdtName", "mcount", "cdate","jdate"];
        //     return order.indexOf(Object.values(test[a])) - order.indexOf(Object.values(test[b]));
        // });
        // console.log(objs[0])
        // console.log(Object.values(Proselect[0]))
        this.config = { 
        data: resurltpuls,
        index: true,
        columnWidth: [45,182,135,180,115,135,100,120,150],
        rowNum:15,
        waitTime:'5000',
        headerHeight:50,
        oddRowBGC:"#003B51E5",
        evenRowBGC:"#0A2732E5",
        align:["left","left","center","center","center","center","center","center","center","center"]
  }
       // .push(Object.kes(Proselect[0]))
        // console.log([Object.values(Proselect[0])])
   })
}
},
mounted(){
let that = this;
that.get();
}
}
</script>

<style>
.demo{
 width: 90%;
 height: 950px;
 margin-left: 10%;
 position:absolute;
}
.text{
 height: 85%;
 width:  95%;
 margin:auto;
 border:2px solid #394691;
 position:relative;
}
.ToolsMan{
    width: 95%;
    height: 5%;
    margin: 0 auto;
    background: rgba(11, 25, 56, 0.5);
}
.ToolsMan2{
  width: 95%;
  height: 6%;
  margin: 0 auto;
}
.grid-content {
    border-radius: 4px;
    min-height: 40px;
}
.bg-purple {
    background: #39485799;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    color: #FFF;
    text-align: center;
    line-height: 40px;
    margin-top: 5px;
  }
  .text_1{
    width: 100%;
    height: 100%;
    /* position: absolute;
		left: 50%;
		top: 50%;
    transform: translate(-50%,-50%); */
  }
</style>