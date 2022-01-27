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
    :uploadurl="uploadurl"
    :selectedfilter="selectedfilter"
    :uploadtype="uploadtype"
    @write="writecontent = $event"
  />

  <!-- <button v-if="step == 0" @click="more">더 보기</button>-->

  <div class="footer">
    <ul v-if="step == 0" class="footer-button-plus">
      <input id="file" multiple type="file" class="inputfile" @change="upload" />
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
      uploadurl: "",
      selectedfilter: "",
      writecontent: "",
      uploadtype: "none",
      selectfile: [],
    };
  },
  created() {
    setTimeout(() => {
      axios
        .get("/post")
        // .get("http://172.30.1.17:8080/post")
        .then((a) => {
          for (let i of a.data) {
            if (i.mediatype == "image" && i.url.search(/^http/) == -1) {
              i.url = i.mediatype + "/" + i.url;
              console.log("url: ", i);
            }
          }
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
    uploadFileCheck(p) {
      if (p.type.search(/^video\/*/) != -1) {
        if (
          p.name.search(["/.mp4$/", "/.m4v$/", "/.wmv$/", "/.mwa$/", "/.asf$/"]) != -1
        ) {
          if (p.size < 50 * 1024 * 1024) {
            return "video";
          } else {
            alert("50MB 이하 동영상 파일만 등록 가능합니다.");
          }
        } else {
          alert(".mp4, .m4v, .wmv, .mwa, .asf 동영상 파일만 등록 가능합니다.");
        }
      }

      if (p.type.search(/^image\/*/) != -1) {
        if (p.name.search(["/.jpeg$/", "/.png$/", "/.gif$/", "/.bmp$/"]) != -1) {
          if (p.size < 8 * 1024 * 1024) {
            return "image";
          } else {
            alert("8MB 이하 이미지파일만 등록 가능합니다.");
          }
        } else {
          alert(".jpeg .png .gif .bmp만 등록 가능합니다.");
        }
      }

      return "none";
    },
    upload(e) {
      this.uploadtype = this.uploadFileCheck(e.target.files[0]);
      if (this.uploadtype == "image") {
        this.selectfile = e.target.files;
        let tempUrl = URL.createObjectURL(this.selectfile[0]);
        this.uploadurl = tempUrl;
        this.step = 1;
      } else if (this.uploadtype == "video") {
        this.selectfile = e.target.files;
        let tempUrl = URL.createObjectURL(this.selectfile[0]);
        this.uploadurl = tempUrl;
        this.step = 2;
      }
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
      const newpost = new FormData();
      newpost.append(
        "postDto",
        new Blob(
          [
            JSON.stringify({
              writer: this.$store.getters["userStore/getUid"],
              mediatype: this.uploadtype,
              filter: this.selectedfilter,
              date:
                date.getFullYear().toString().substr(2) +
                " " +
                monthNames[date.getMonth()] +
                " " +
                date.getDate(),
              content: this.writecontent,
            }),
          ],
          { type: "application/json" }
        )
      );
      for (let i = 0; i < this.selectfile.length; i++) {
        newpost.append("files", this.selectfile[i]);
        // newpost.append("files", new Blob([JSON.stringify(this.selectfile[i])]));
      }

      // let newpost = {
      //   postDto: {
      //     writer: this.$store.getters["userStore/getUid"],
      //     mediatype: this.uploadtype,
      //     filter: this.selectedfilter,
      //     date:
      //       date.getFullYear().toString().substr(2) +
      //       " " +
      //       monthNames[date.getMonth()] +
      //       " " +
      //       date.getDate(),
      //     content: this.writecontent,
      //   },
      //   files: upfiles,
      // };

      this.$store.dispatch("publish", newpost);

      this.step = 0;
      this.uploadtype = "none";
      this.uploadurl = "";
      this.selectedfilter = "";
      this.writecontent = "";
      this.selectfile = [];
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
