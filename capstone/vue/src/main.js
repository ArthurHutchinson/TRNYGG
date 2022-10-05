import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faCrown, faUser} from '@fortawesome/free-solid-svg-icons'
library.add(faUser, faCrown)
Vue.component('font-awesome-icon', FontAwesomeIcon)
// new Vue({
//   el: '#app',
//   components: { App },
//   template: '<App/>'
// })

Vue.config.productionTip = false

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
