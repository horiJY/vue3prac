<template>
  <!-- <p>{{ f }}</p> -->
  <div
    :class="f + ' filter-item'"
    :style="{ backgroundImage: `url(${uploadimg})` }"
  />
</template>

<script>
export default {
  name: 'FilterBox',
  props: {
    uploadimg: String,
    f: String,
  },
};
</script>

<style>
.filter-item {
  width: 100px;
  height: 100px;
  margin: 10px 10px 10px auto;
  padding: 8px;
  display: inline-block;
  color: white;
  background-size: cover;
  background-position: center;
}
</style>
