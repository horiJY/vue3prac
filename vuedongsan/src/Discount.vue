<template>
  <div class="discount">
    <h4>지금 결제하면 {{ discountRate }}% 할인!</h4>
    <p>대충 긴 내용~</p>
  </div>
</template>

<script>
export default {
  name: "Discount",
  data() {
    return {
      discountRate: 30,
    };
  },
  mounted() {
    let discountInterval = setInterval(() => {
      console.log("setInterval 돌고 있습니다.");
      if (this.discountRate > 0) {
        this.discountRate -= 5;
      } else {
        clearInterval(discountInterval);
      }
    }, 1000);
  },
};
</script>

<style>
.discount {
  background: #eee;
  padding: 10px;
  margin: 10px;
  border-radius: 5px;
}
</style>
