<template>
  <div>
    <div v-if="step == 0">
      <Post v-for="(post, i) in postdatas" :key="i" :post="postdatas[i]" />
    </div>

    <div v-if="step == 1">
      <!-- 필터선택페이지 -->
      <div
        class="upload-image"
        :style="{ backgroundImage: `url(${uploadimg})` }"
      />
      <div class="filters">
        <FilterBox
          :uploadimg="uploadimg"
          v-for="f in filters"
          :key="f"
          :f="f"
        />
      </div>
    </div>

    <div v-if="step == 2">
      <!-- 글작성페이지 -->
      <div
        class="upload-image"
        :style="{ backgroundImage: `url(${uploadimg})` }"
      />
      <div class="write">
        <textarea
          class="write-box"
          @input="$emit('write', $event.target.value)"
        >
write!</textarea
        >
      </div>
    </div>
  </div>
</template>

<script>
import post from '@/components/Post';
import filterBox from '@/components/FilterBox';

export default {
  name: 'Container',
  data() {
    return {
      filters: [
        'aden',
        '_1977',
        'brannan',
        'brooklyn',
        'clarendon',
        'earlybird',
        'gingham',
        'hudson',
        'inkwell',
        'kelvin',
        'lark',
        'lofi',
        'maven',
        'mayfair',
        'moon',
        'nashville',
        'perpetua',
        'reyes',
        'rise',
        'slumber',
        'stinson',
        'toaster',
        'valencia',
        'walden',
        'willow',
        'xpro2',
      ],
    };
  },
  components: {
    Post: post,
    FilterBox: filterBox,
  },
  props: {
    postdatas: Array,
    step: Number,
    uploadimg: String,
  },
};
</script>

<style>
.upload-image {
  width: 100%;
  height: 450px;
  background: cornflowerblue;
  background-size: cover;
}
.filters {
  overflow-x: scroll;
  white-space: nowrap;
}
.filters::-webkit-scrollbar {
  height: 5px;
}
.filters::-webkit-scrollbar-track {
  background: #f1f1f1;
}
.filters::-webkit-scrollbar-thumb {
  background: #888;
  border-radius: 5px;
}
.filters::-webkit-scrollbar-thumb:hover {
  background: #555;
}
.write-box {
  border: none;
  width: 90%;
  height: 100px;
  padding: 15px;
  margin: auto;
  display: block;
  outline: none;
}
</style>
