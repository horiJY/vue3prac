import { createStore, mapMutations } from 'vuex';
import axios from 'axios';

const store = createStore({
  state() {
    return {
      name: 'jy',
      age: 20,
      likes: 0,
      liked: false,
      more: {},
    };
  },

  mutations: {
    clicklike(state) {
      if (state.liked == false) {
        state.likes++;
        state.liked = true;
      } else {
        state.likes--;
        state.liked = false;
      }
    },
    // state 수정 정의하는 곳
    changename(state) {
      state.name = '재영';
    },
    addage(state, payload) {
      state.age += payload;
    },
    setMore(state, data) {
      state.more = data;
    },
  },

  actions: {
    getMore(context) {
      axios.get('https://codingapple1.github.io/vue/more0.json').then((a) => {
        console.log(a);
        context.commit('setMore', a.data);
      });
    },
  },
});

export default store;
