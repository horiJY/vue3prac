import { createStore } from 'vuex';
import axios from 'axios';

const store = createStore({
  state() {
    return {
      step: 0,
      posts: [],
      uploadpost: [],
    };
  },
  mutations: {
    setPost(state, data) {
      state.posts = data;
    },
    // clicklike(state) {
    //   if (state.liked == false) {
    //     state.likes++;
    //     state.liked = true;
    //   } else {
    //     state.likes--;
    //     state.liked = false;
    //   }
    // },
    // state 수정 정의하는 곳
    // setMore(state, data) {
    //   state.more = data;
    // },
  },

  actions: {
    // getMore(context) {
    getMore() {
      axios.get('https://codingapple1.github.io/vue/more0.json').then((a) => {
        console.log(a);
        // context.commit('setMore', a.data);
      });
    },
  },
});

export default store;
