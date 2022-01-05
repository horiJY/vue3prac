<template>
  <div>
    <img :src="l.image" class="room-img" />
    <h4 @click="$emit('openModal', l.id)">
      {{ l.title }}
    </h4>
    <p>월세 : {{ l.price }} 원</p>

    <p>
      <button @click="$emit('reportProduct', l.id)">허위매물신고</button>
      <span>신고수 : {{ l.reportScore }}</span>
    </p>
  </div>
</template>

<script>
export default {
  name: 'Card',
  props: {
    l: Object,
  },
};
</script>

<style></style>
