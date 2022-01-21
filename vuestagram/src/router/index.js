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

router.beforeEach((to, from, next) => {
  // 라우터 이동 전
  store.commit('startSpinner');
  setTimeout(() => {
    next();
  }, 1000); // 최소 1ms이상 들어와야지 동작가능.
});

// eslint-disable-next-line no-unused-vars
router.afterEach((to, from) => {
  // 이동이 끝난 후
  store.commit('endSpinner');
});

export default router;
