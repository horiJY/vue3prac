<template>
  <div class="header">
    <ul class="header-button-left">
      <li @click="step = 0">Cancel</li>
    </ul>
    <ul class="header-button-right">
      <li @click="if (step < 2) step++;">Next</li>
    </ul>
    <img src="./assets/logo.png" class="logo" />
  </div>

  <Container :postdatas="postdatas" :step="step" :uploadImg="uploadImg" />
  <button @click="more">더 보기</button>

  <div class="footer">
    <ul class="footer-button-plus">
      <input
        @change="upload"
        multiple
        type="file"
        id="file"
        class="inputfile"
      />
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>
import container from '@/components/Container.vue';
import postDatas from '@/assets/postdatas.js';
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      postdatas: postDatas,
      moreBtnCount: 0,
      step: 0,
      uploadImg: '',
    };
  },
  components: {
    Container: container,
  },
  methods: {
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
      this.uploadImg = uploadUrl;
      // console.log(this.uploadImg);
      this.step++;
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
