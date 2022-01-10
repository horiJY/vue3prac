<template>
  <div class="header">
    <ul class="header-button-left">
      <li @click="step = 0">Back</li>
      <li @click="step = 3">MyPage</li>
    </ul>
    <ul class="header-button-right">
      <li v-if="step == 1" @click="if (step < 2) step++;">Next</li>
      <li v-if="step == 2" @click="publish">발행</li>
    </ul>
    <img src="./assets/logo.png" class="logo" />
    <!-- <h4>안녕 {{ $store.state.name }} ({{ $store.state.age }})</h4> -->
    <!--<button @click="$store.commit('changename')">name 수정</button>
    <button @click="$store.commit('addage', 10)">age 증가</button> -->
    <!-- <button @click="addage(10)">age 증가</button> -->
  </div>
  <!-- <p>{{ now() }} {{ moreBtnCount }}</p> -->
  <!-- <p>{{ now2 }}</p> -->
  <!-- <button @click="moreBtnCount++">now 테스트</button> -->
  <Container
    :postdatas="postdatas"
    :step="step"
    :uploadimg="uploadimg"
    :selectedfilter="selectedfilter"
    @write="writeContent = $event"
  />

  <!-- <Container :postdatas="$store.state.more" :step="step" /> -->
  <!-- <p>{{ $store.state.more }}</p> -->
  <button v-if="step == 0" @click="more">더 보기</button>
  <!-- <button v-if="step == 0" @click="$store.dispatch('getMore')">더 보기</button> -->

  <div class="footer">
    <ul class="footer-button-plus">
      <input
        id="file"
        multiple
        type="file"
        class="inputfile"
        @change="upload"
      />
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>
import container from '@/components/Container.vue';
import postDatas from '@/assets/postdatas.js';
import axios from 'axios';
import { mapState, mapMutations } from 'vuex';

export default {
  name: 'App',
  components: {
    Container: container,
  },
  data() {
    return {
      postdatas: postDatas,
      moreBtnCount: 0,
      step: 0,
      uploadimg: '',
      writeContent: '',
      selectedfilter: '',
    };
  },
  mounted() {
    this.emitter.on('selectfilter', (a) => {
      this.selectedfilter = a;
    });
  },
  computed: {
    // name() {
    //   return this.$store.state.name;
    // },
    ...mapState(['name', 'age', 'likes']),
    ...mapState({ 변경할변수명: 'name' }),
  },
  methods: {
    ...mapMutations(['addage']),
    now() {
      return new Date();
    },
    more() {
      axios
        // .get('https://codingapple1.github.io/vue/more' +this.moreBtnCount +'.json')
        .get(`https://codingapple1.github.io/vue/more${this.moreBtnCount}.json`)
        .then((result) => {
          this.postdatas.push(result.data);
          this.moreBtnCount++;
        })
        .catch((err) => {
          alert(err);
        });
    },
    upload(e) {
      let imgfile = e.target.files;
      // console.log(imgfile[0]);
      // console.log(imgfile[0].type);
      let uploadUrl = URL.createObjectURL(imgfile[0]);
      // console.log(uploadUrl);
      this.uploadimg = uploadUrl;
      // console.log(this.uploadImg);
      this.step = 1;
    },
    publish() {
      var newpost = {
        name: 'JY',
        userImage: 'https://placeimg.com/100/100/arch',
        postImage: this.uploadimg,
        likes: 0,
        date: 'May 15',
        liked: false,
        content: this.writeContent,
        filter: 'perpetua',
      };
      this.postdatas.unshift(newpost);
      this.step = 0;
    },
  },
};
</script>

<style>
body {
  margin: 0;
}
ul {
  padding: 5px;
  list-style-type: none;
}
.logo {
  width: 22px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}
.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}
.header-button-left {
  color: skyblue;
  float: left;
  width: 50px;
  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}
.header-button-right {
  color: skyblue;
  float: right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
}
.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}
.footer-button-plus {
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}
.sample-box {
  width: 100%;
  height: 600px;
  background-color: bisque;
}
.inputfile {
  display: none;
}
.input-plus {
  cursor: pointer;
}
#app {
  box-sizing: border-box;
  font-family: 'consolas';
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>
