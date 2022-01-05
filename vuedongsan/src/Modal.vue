<template>
  <div class="black-bg" v-if="modalStatus">
    <div class="white-bg">
      <h4>{{ products[contentNum].title }}</h4>
      <img :src="products[contentNum].image" class="room-img" />
      <p>{{ products[contentNum].content }}</p>
      <p>월세 : {{ products[contentNum].price }}</p>
      <Discount />
      <p>
        예약 개월 수 :
        <!-- <input @input="month = $event.target.value" type="number" /> -->
        <input v-model="month" />
      </p>
      <p>{{ month }}개월 : {{ products[contentNum].price + month }}원</p>

      <button @click="$emit('closeModal')">닫기</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Modal',
  data() {
    return {
      month: 1,
    };
  },
  watch: {
    month(a) {
      //   var regNumber = /^[0-9]*$/;
      if (a > 12) {
        alert('최대 12개월까지 가능합니다.');
      } else if (isNaN(a) == true || a.search(/\s/g) != -1) {
        alert('숫자만 입력하세요.');
        this.month = 1;
      }
    },
  },
  props: {
    modalStatus: Boolean,
    products: Array,
    contentNum: Number,
  },
};
</script>

<style>
.black-bg {
  width: 100%;
  height: 100%;
  top: 0;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 30px;
}
.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}
</style>
