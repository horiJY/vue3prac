// export default {
const userStore = {
  namespaced: true,
  state() {
    return {
      uid: '',
      token: '',
      isAuth: false,
    };
  },
  getters: {
    getUid: (state) => state.uid,
    getToken: (state) => state.token,
    getIsAuth: (state) => state.isAuth,
  },
  mutations: {
    UID(state, uid) {
      state.uid = uid;
    },
    TOKEN(state, token) {
      state.token = token;
    },
    IS_AUTH(state, isAuth) {
      state.isAuth = isAuth;
    },
  },
  actions: {
    login(context, data) {
      if (data) {
        // // 로그인 성공시 처리해줘야할 부분
        context.commit('UID', data);
        context.commit('IS_AUTH', true);
      } else {
        context.commit('IS_AUTH', false);
      }
    },
    logout(context) {
      context.commit('UID', '');
      context.commit('IS_AUTH', false);
    },
  },
};

export default userStore;
