<template>
  <div style="padding: 10px">
    <h4>팔로워</h4>
    <input placeholder="🔍" @input="search($event.target.value)" />
    <div class="post-header" v-for="(f, i) in follower" :key="i">
      <div class="profile" :style="{ backgroundImage: `url(${f.image})` }"></div>
      <span class="profile-name">{{ f.name }}</span>
    </div>
  </div>
</template>

<script>
// import { onMounted, ref, reactive, watch } from "vue";
import { onMounted, ref } from "vue";
import axios from "axios";
// import { useStore } from "vuex";

export default {
  name: "mypage",
  setup() {
    // setup(props, context) {
    // 첫번째는 항상 props임, 두번째는 attrs, slots, emit이 담겨있음(상황마다 다름)
    // created 훅과 비슷, 컴포넌트 생성전 먼저 처리해야할 것
    // 데이터 생성, 조작, method, computed, watch, hook 설정 가능

    let follower = ref([]);
    // 데이터 생성 ref(데이터)? reference data type : 실시간 렌더링을 할 수 있는 이유
    // primitive type 할당

    let followerOriginal = ref([]);
    //reactive() : ref() 같은 기능, 보통 array,object할당 시 사용,
    //근데 그냥 ref에 써도 상관은 없다.
    // let test = reactive({ name: 'kim' });

    // watch( 데이터명, ()=>{ 데이터 변화시 실행할 코드 } )

    // let 변수 = computed( ()=>{ return follwer.value.length } )
    //console.log(변수.value)
    onMounted(() => {
      // 라이프사이클 훅을 쓰려면 여기서 on뒤에 붙인다.
      axios.get("/follower.json").then((a) => {
        // axios.get("@/assets/follower.json").then((a) => {
        // Composition API안에서 Ajax 요청 & 데이터 변경하려면 .value써야함
        follower.value = a.data;
        followerOriginal.value = [...a.data];
      });
    });
    function search(keyword) {
      let newFollower = followerOriginal.value.filter((a) => {
        return a.name.indexOf(keyword) != -1;
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
