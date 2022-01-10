<template>
  <div
    :class="f + ' filter-item'"
    :style="{ backgroundImage: `url(${uploadimg})` }"
    @click="fire"
  >
    <slot> </slot>
  </div>
</template>

<script>
export default {
  name: 'FilterBox',
  props: {
    uploadimg: String,
    f: String,
  },
  methods: {
    fire() {
      this.emitter.emit('selectfilter', this.f);
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
