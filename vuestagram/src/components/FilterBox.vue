<template>
  <div
    :class="filter + ' filter-item'"
    :style="{ backgroundImage: `url(${uploadimg})` }"
    @click="choice"
  >
    <slot> </slot>
    <!-- slot 태그는 상위 컴포넌트 태그 사이에 들어가있는 내용 전체를 넣어준다. -->
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
