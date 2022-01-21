import { createApp } from 'vue';
import App from './App.vue';
import mitt from 'mitt';
import store from './store/store.js';
import router from './router/index.js';
import axios from '@/api/axios.js';

let emitter = mitt();
let app = createApp(App);

if (process.env == 'dev') axios.defaults.baseURL = 'http://localhost:3000';
if (process.env == 'prod') axios.defaults.baseURL = 'http://prd:9999';
// 모든 컴포넌트들의 글로벌한 변수보관함
// 변수보관함에 emitter : emitter 라고 추가한 것
// 다른 컴포넌트에서 자주쓰는 라이브러리가 있으면 여기에 추가하면 됨
app.config.globalProperties.emitter = emitter;
app.config.globalProperties.axios = axios;
app.use(store).use(router).mount('#app');
