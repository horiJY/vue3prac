import { createWebHistory, createRouter } from 'vue-router';
import Login from '@/views/Login';
import Vuesta from '@/views/Vuesta';
import { Store } from '@/store/store.js';

const routes = [
  {
    path: '/',
    component: Login,
  },
  {
    path: '/vuesta',
    component: Vuesta,
    beforeEnter: () => {
      let check = Store.getters['loginCount'];
      alert(check);
      // if (Store.state.id == '') {
      //   alert('로그인 해주세요');
      //   return '/';
      // }
    },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
