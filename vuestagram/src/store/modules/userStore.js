import axios from 'axios';

// export default {
const userStore = {
  namespaced: true,
  state() {
    return {
      uid: '',
      errorState: '',
      isAuth: false,
    };
  },
  getters: {
    getUid: (state) => state.uid,
    getErrorState: (state) => state.errorState,
    getIsAuth: (state) => state.isAuth,
  },
  mutations: {
    UID(state, uid) {
      state.uid = uid;
    },
    ERROR_STATE(state, errorState) {
      state.errorState = errorState;
    },
    IS_AUTH(state, isAuth) {
      state.isAuth = isAuth;
    },
  },
  actions: {
    async login(context, data) {
      console.log('userStore', data);
      /* 로그인은 백엔드를 다녀와야 하냐 비동기 처리를 한다 */
      await axios
        .post('http://172.30.1.17:8080/signin', data)
        .then((res) => {
          console.log(res);
          if (res.data) {
            // // 로그인 성공시 처리해줘야할 부분
            context.commit('UID', data.id);
            // console.log('UID commit', context.state.uid);
            context.commit('IS_AUTH', true);
            context.commit('ERROR_STATE', '');
            return true;
          } else {
            context.commit('IS_AUTH', false);
            context.commit('ERROR_STATE', 'ID, PW를 다시 확인해 주세요.');
          }
          return false;
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};

export default userStore;
