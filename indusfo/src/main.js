// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VCharts from 'v-charts'
import App from './App'
import router from './router'
import echarts from "echarts"
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store/index'
import dataV from '@jiaminghi/data-view'
// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios

Vue.use(ElementUI)
Vue.use(VCharts)
Vue.use(global)
Vue.use(dataV)


router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: '/',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)


Vue.prototype.$echarts = echarts
// 在生产环境下把注释全部去掉
Vue.config.productionTip = false

/* eslint-disable no-new */
// 是否启动代码质量检查
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})

