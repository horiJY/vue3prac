<template>
  <div
    :class="filter + ' filter-item'"
    :style="{ backgroundImage: `url(${uploadimg})` }"
    @click="choice"
  >
    <slot> </slot>
  </div>
</template>

<script>
export default {
  name: "FilterBox",
  props: {
    uploadimg: String,
    filter: String,
  },
  methods: {
    choice() {
      this.emitter.emit("selectfilter", this.filter);
    },
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
