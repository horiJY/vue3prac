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

  <button @click="priceSort">가격순 정렬</button>
  <button @click="reverseSort">가격역순 정렬</button>
  <button @click="alphaSort">가나다 정렬</button>
  <button @click="sortBack">되돌리기</button>

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
      origProducts: [...roomDatas],
    };
  },
  methods: {
    // reportincrease() {
    //   console.log("신고완료");
    //   this.reportScore += 1;
    // },
    priceSort() {
      // sort 함수는 기본적으로 오름차순정렬, 그런데 위처럼 쓰면 문자로 비교하여 정렬한다.
      // 숫자로 정렬하기 위해서는 sort내부에 fucntion을 하여 비교해주어야한다.(sort의 동작방식 때문)
      this.products.sort(function (a, b) {
        return a.price - b.price;
      });
      //sort는 원본데이터를 변경한다. 원본데이터는
    },
    reverseSort() {
      this.products.sort(function (a, b) {
        return b.price - a.price;
      });
    },
    sortBack() {
      this.products = [...this.origProducts];
    },
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
  /* width: 100%; */
  width: 50%;
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
