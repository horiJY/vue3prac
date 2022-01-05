<template>
  <img alt="Vue logo" src="./assets/logo.png" />

  <transition name="fade">
    <Modal
      @closeModal="modalStatus = false"
      :products="products"
      :contentNum="contentNum"
      :modalStatus="modalStatus"
    />
  </transition>

  <div class="menu">
    <a v-for="m in 메뉴들" :key="m">{{ m }}</a>
  </div>

  <Discount />
  <!-- <div v-for="(l, i) in products" :key="i">
    <Card :l="products[i]" />
  </div> -->
  <Card
    @openModal="
      modalStatus = true;
      contentNum = $event;
    "
    @reportProduct="products[$event].reportScore += 1"
    :l="products[i]"
    v-for="(l, i) in products"
    :key="i"
  />
</template>

<script>
import roomDatas from './assets/roomdata.js';
import Discountvue from './Discount.vue';
import Modal from './Modal.vue';
import Card from './Card.vue';

export default {
  name: 'App',
  data() {
    return {
      modalStatus: false,
      contentNum: 0,
      메뉴들: ['Home', 'Products', 'About'],
      products: roomDatas,
    };
  },
  methods: {
    // reportincrease() {
    //   console.log("신고완료");
    //   this.reportScore += 1;
    // },
  },
  components: {
    Discount: Discountvue,
    Modal,
    Card,
  },
};
</script>

<style>
body {
  margin: 0;
}
div {
  box-sizing: border-box;
}

.room-img {
  width: 100%;
  margin-top: 40px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
}

.fade-enter-from {
  transform: translateY(-1000px);
}
.fade-enter-active {
  transition: all 1s;
}
.fade-enter-to {
  transform: translateY(0px);
}

.fade-leave-from {
  opacity: 1;
}
.fade-leave-active {
  transition: all 1s;
}
.fade-leave-to {
  opacity: 0;
}
</style>
