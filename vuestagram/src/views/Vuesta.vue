<template>
  <div class="header">
    <ul class="header-button-left">
      <li v-if="step == 0" @click="step = 3">Follow</li>
      <li v-if="step != 0" @click="step = 0">Cancel</li>
    </ul>
    <ul class="header-button-right">
      <li v-if="step == 0" @click="logoutBtn">Logout</li>
      <li v-if="step == 1" @click="if (step < 2) step++;">Next</li>
      <li v-if="step == 2" @click="publish">발행</li>
    </ul>
    <img src="@/assets/logo.png" class="logo" @click="step = 0" />
  </div>

  <Container
    :step="step"
    :uploadimg="uploadimg"
    :selectedfilter="selectedfilter"
    @write="writecontent = $event"
  />

  <!-- <button v-if="step == 0" @click="more">더 보기</button>-->

  <div class="footer">
    <ul v-if="step == 0" class="footer-button-plus">
      <input
        id="file"
        multiple
        type="file"
        class="inputfile"
        :uploadimg="uploadimg"
        @change="upload"
      />

      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>
import Container from "@/components/Container.vue";
import axios from "axios";
import { mapActions } from "vuex";

export default {
  name: "App",
  components: {
    Container,
  },
  data() {
    return {
      step: 0,
      uploadimg: "",
      selectedfilter: "",
      writecontent: "",
    };
  },
  created() {
    setTimeout(() => {
      axios
        .get("/post")
        // .get("http://172.30.1.17:8080/post")
        .then((a) => {
          // console.log("Request res", a);
          this.$store.commit("setPost", a.data);
        })
        .catch((err) => {
          alert(err);
        });
      // 필터선택
      this.emitter.on("selectfilter", (a) => {
        this.selectedfilter = a;
      });
    }, 1500);
  },
  methods: {
    ...mapActions("userStore", ["logout"]),
    logoutBtn() {
      this.logout();
      this.$router.push("/");
    },
    //   more() {
    //     // axios
    //     //   // .get('https://codingapple1.github.io/vue/more' +this.moreBtnCount +'.json')
    //     //   .get(`https://codingapple1.github.io/vue/more${this.moreBtnCount}.json`)
    //     //   .then((result) => {
    //     //     this.postdatas.push(result.data);
    //     //     this.moreBtnCount++;
    //     //   })
    //     //   .catch((err) => {
    //     //     alert(err);
    //     //   });
    //   },
    upload(e) {
      let imgfile = e.target.files;
      let uploadUrl = URL.createObjectURL(imgfile[0]);
      this.uploadimg = uploadUrl;
      this.step = 1;
    },
    publish() {
      const monthNames = [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
      ];
      let date = new Date();
      let newpost = {
        user: this.$store.getters["userStore/getUid"],
        postimage: this.uploadimg.substr(5),
        filter: this.selectedfilter,
        date: monthNames[date.getMonth()] + " " + date.getDate(),
        content: this.writecontent,
      };
      console.log("upload post", newpost);
      this.$store.dispatch("publish", newpost);
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
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>
