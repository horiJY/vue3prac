<template>
  <div>
    <div v-if="step == 0">
      <Post v-for="(post, i) in $store.state.posts" :key="i" :post="post" :index="i" />
      <!-- <Comment v-for="comment in $store.state.comment" :key="comment" :comment="comment"/> -->
    </div>
  </div>
  <div v-if="step == 1">
    <!-- 필터선택페이지 필터값이 초기에는 없으므로 class와 :class를 분리-->
    <div
      class="upload-image"
      :class="selectedfilter"
      :style="{ backgroundImage: `url(${uploadimg})` }"
    />
    <div class="filters">
      <FilterBox v-for="f in filters" :key="f" :filter="f" :uploadimg="uploadimg">
        <span style="color: black"> {{ f }} </span>
      </FilterBox>
    </div>
  </div>

  <div v-if="step == 2">
    <!-- 글작성페이지 -->
    <div
      :class="selectedfilter"
      class="upload-image"
      :style="{ backgroundImage: `url(${uploadimg})` }"
    />
    <div class="write">
      <textarea
        class="write-box"
        placeholder="write! here!"
        @input="$emit('write', $event.target.value)"
      />
    </div>
  </div>
  <div v-if="step == 3">
    <MyPage />
  </div>
</template>

<script>
import Post from "@/components/Post";
import FilterBox from "@/components/FilterBox";
import MyPage from "@/components/MyPage";

export default {
  name: "Container",
  components: {
    Post,
    FilterBox,
    MyPage,
  },
  props: {
    step: Number,
    uploadimg: String,
    selectedfilter: String,
  },
  data() {
    return {
      postNum: 0,
      filters: [
        "aden",
        "_1977",
        "brannan",
        "brooklyn",
        "clarendon",
        "earlybird",
        "gingham",
        "hudson",
        "inkwell",
        "kelvin",
        "lark",
        "lofi",
        "maven",
        "mayfair",
        "moon",
        "nashville",
        "perpetua",
        "reyes",
        "rise",
        "slumber",
        "stinson",
        "toaster",
        "valencia",
        "walden",
        "willow",
        "xpro2",
      ],
    };
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
