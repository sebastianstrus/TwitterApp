import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

axios.defaults.baseURL = 'http://ec2-13-48-6-58.eu-north-1.compute.amazonaws.com:8080'

createApp(App).use(store).use(router).mount('#app')
