<template>
  <div style="padding: 10px">
    <h4>팔로워 찾기</h4>
    <input placeholder="🔍" @input="search($event.target.value)" />
    <div class="post-header" v-for="f in follower" :key="f">
      <div class="profile" :style="{ backgroundImage: `url(${f.userimage})` }"></div>
      <span class="profile-name">{{ f.id }}</span>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import { useStore } from "vuex";
import axios from "axios";

export default {
  name: "mypage",
  setup() {
    let store = useStore();
    let follower = ref([]);
    let followerOriginal = ref([]);
    console.log(store.getters["userStore/getUid"]);
    if (store.getters["userStore/getUid"] != "") {
      let param = {};
      param.id = store.getters["userStore/getUid"];
      axios.post("/follower", param).then((a) => {
        // axios.get("/follower.json").then((a) => {
        // Composition API안에서 Ajax 요청 & 데이터 변경하려면 .value써야함
        follower.value = a.data;
        followerOriginal.value = [...a.data];
        console.log(a.data);
      });
    }

    function search(keyword) {
      let newFollower = followerOriginal.value.filter((a) => {
        return a.id.indexOf(keyword) != -1;
      });
      follower.value = [...newFollower];
    }

    return { follower, search };
  },
  data() {
    return {};
  },
};
</script>

<style></style>
