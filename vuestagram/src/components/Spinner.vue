<template>
  <div class="spinner" v-if="loading">
    <div></div>
    <div></div>
    <div></div>
  </div>
  <p v-if="loading">데이터를 가져오는 중입니다🔍🔍🔍</p>
</template>
<script>
export default {
  props: {
    loading: Boolean,
    // loading : {
    //   type: Boolean,
    //   required: true,
    // },
  },
};
</script>
<style scoped>
.spinner {
  display: inline-block;
  position: absolute;
  width: 64px;
  height: 64px;
  top: 47%;
  left: 47%;
}
.spinner div {
  display: inline-block;
  position: absolute;
  left: 6px;
  width: 13px;
  background: #42b883;
  animation: spinner 1.2s cubic-bezier(0, 0.5, 0.5, 1) infinite;
}
.spinner div:nth-child(1) {
  left: 6px;
  animation-delay: -0.24s;
}
.spinner div:nth-child(2) {
  left: 26px;
  animation-delay: -0.12s;
}
.spinner div:nth-child(3) {
  left: 45px;
  animation-delay: 0;
}
@keyframes spinner {
  0% {
    top: 6px;
    height: 51px;
  }
  50%,
  100% {
    top: 19px;
    height: 25px;
  }
}
p {
  text-align: center;
}
</style>
