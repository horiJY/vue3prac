<template>
  <div>
    <h4>상세페이지</h4>
    <h5>{{ contents[$route.params.id].title }}</h5>
    <p>{{ contents[$route.params.id].date }}</p>
    <p>{{ contents[$route.params.id].content }}</p>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  props: {
    contents: Array,
  },
};
</script>

<style></style>
