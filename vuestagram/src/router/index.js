import { createWebHistory, createRouter } from 'vue-router';
import Login from '@/views/Login';
import Vuesta from '@/views/Vuesta';
import store from '@/store/store';

const Authentication = () => (to, from, next) => {
  if (!store.getters['userStore/getIsAuth']) {
    alert('로그인이 필요합니다.');
    next('/');
  } else {
    next();
  }
};

const routes = [
  {
    path: '/',
    component: Login,
  },
  {
    path: '/vuesta',
    component: Vuesta,
    beforeEnter: Authentication(),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
