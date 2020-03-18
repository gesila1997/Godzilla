<template>
  <div class="Demo">
      <index-menu ref="IndexMenu" v-on:closeMain="closeMain"/>
      <transition name="fade">
      <echa-rts    v-if="index==1"/>
      </transition> 
      <transition name="fade">
      <produ-ction v-if="index==2"/>
      </transition>
      <transition name="fade">
      <sub-mitted  v-if="index==3"/>
      </transition>
      <div class="homepage-hero-module">
      <div class="video-container">
      <div :style="fixStyle" class="filter"></div>
      <video :style="fixStyle" autoplay loop class="fillWidth" v-on:canplay="canplay">
        <source src="../assets/video/made.mp4" type="video/mp4"/>
        浏览器不支持 video 标签，建议升级浏览器。
      </video>
    </div>
    </div>
  </div>
</template>
<script>
import IndexMenu  from "@/components/menu.vue"
import EchaRts    from "@/components/echarts.vue"
import ProduCtion from "@/components/Production.vue"
import SubMitted  from "@/components/Submitted.vue"
import Static     from "@/assets/images/static.png"
import made       from "@/assets/video/made.mp4";
export default {
  name: "index",
  components:{
    IndexMenu,
    ProduCtion,
    SubMitted,
    EchaRts
  },
  data() {
    return {
      index    :1,
      fixStyle: ''
    };
    },
    methods: {
    closeMain(val){
        this.index =val
        //console.log(val)
    },
  canplay() {
        this.vedioCanPlay = true
      }
    },
   mounted() {
    window.onresize = () => {
        const windowWidth = document.body.clientWidth
        const windowHeight = document.body.clientHeight
        const windowAspectRatio = windowHeight / windowWidth
        let videoWidth
        let videoHeight
        if (windowAspectRatio < 0.5625) {
          videoWidth = windowWidth
          videoHeight = videoWidth * 0.5625
          this.fixStyle = {
            height: windowWidth * 0.5625 + 'px',
            width: windowWidth + 'px',
            'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
            'margin-left': 'initial'
          }
        } else {
          videoHeight = windowHeight
          videoWidth = videoHeight / 0.5625
          this.fixStyle = {
            height: windowHeight + 'px',
            width: windowHeight / 0.5625 + 'px',
            'margin-left': (windowWidth - videoWidth) / 2 + 'px',
            'margin-bottom': 'initial'
          }
        }
      }
      window.onresize()
  }  
};
</script>
<style>
body{
  margin:0;
  padding:0;
  bottom: 0;
}
.Demo {
  width: 100%;
  height: 950px;
}

.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

.homepage-hero-module,
  .video-container {
    position: relative;
    height: 100%;
    width: 100%;
    overflow: hidden;
    z-index:-100;
  }

  .video-container .poster img,
  .video-container video {
    z-index: 0;
    position: absolute;
  }

  .video-container .filter {
    z-index: 1;
    position: absolute;
  }
</style>