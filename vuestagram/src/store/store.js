import { createStore } from 'vuex';
import axios from 'axios';
import userStore from '@/store/modules/userStore.js';

const store = createStore({
  modules: {
    userStore,
  },
  state() {
    return {
      posts: [],
      uploadpost: [],
    };
  },
  mutations: {
    setPost(state, data) {
      state.posts = data;
    },
    createPost(state, newpost) {
      axios
        .post('http://172.30.1.17:8080/post', newpost)
        .then((a) => {
          console.log('store createPost', a.data);
          state.posts.unshift(a.data);
        })
        .catch((err) => {
          alert(err);
        });
    },
    clicklike(state, data) {
      console.log(state);
      console.log(data);
      // if (state.liked == false) {
      //   state.likes++;
      //   state.liked = true;
      // } else {
      //   state.likes--;
      //   state.liked = false;
      // }
    },
  },
  actions: {
    publish(context, data) {
      context.commit('createPost', data);
    },
    // getMore(context) {
    // getMore() {
    //   axios.get('https://codingapple1.github.io/vue/more0.json').then((a) => {
    //     console.log(a);
    //     // context.commit('setMore', a.data);
    //   });
    // },
  },
});

export default store;
