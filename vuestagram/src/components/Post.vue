<template>
  <div class="post">
    <div class="post-header">
      <div class="profile" :style="{ backgroundImage: `url(${post.userimage})` }" />
      <span class="profile-name">{{ post.writer }}</span>
      <label class="" style="display: none">{{ post.id }}</label>
    </div>
    <div
      v-if="`${post.mediatype}` == 'image'"
      class="post-body"
      :class="post.filter"
      :style="{ backgroundImage: `url(${post.url})` }"
      @click="clicklike"
    />
    <video
      v-if="`${post.mediatype}` == 'video'"
      class="post-body"
      controls
      loop
      :src="`/${post.mediatype}/${post.url}`"
      preload="auto"
      @click="clicklike"
    />
    <div class="post-content">
      <p>{{ post.likes }} Likes</p>
      <p>
        <strong>{{ post.writer }}</strong> {{ post.content }}
      </p>
      <p class="date">
        {{ post.date }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Post",
  props: {
    post: Object,
    index: Number,
  },
  data() {
    return {
      id: this.post.id,
      lastScrollPosition: 0,
    };
  },
  mounted() {
    if (this.post.mediatype == "video") {
      window.addEventListener("scroll", this.onScroll);
    }
  },
  beforeUnmount() {
    window.removeEventListener("scroll", this.onScroll);
  },
  methods: {
    clicklike() {
      console.log(this.id);
    },
    onScroll() {
      const posts = document.getElementsByClassName("post");
      const videoObj = posts[this.index].querySelector("video");

      const videoObjPosition = videoObj.offsetTop + videoObj.offsetHeight;
      const currentScrollPosition = visualViewport.pageTop + visualViewport.height;
      if (
        this.lastScrollPosition - videoObjPosition < 0 ||
        this.lastScrollPosition - videoObjPosition > videoObj.offsetHeight
      ) {
        videoObj.pause();
      } else {
        videoObj.play();
      }
      this.lastScrollPosition = currentScrollPosition;
    },
  },
};
</script>

<style scope>
.post {
  width: 100%;
}
.profile {
  width: 30px;
  height: 30px;
  background-size: 100%;
  border-radius: 50%;
  float: left;
}
.profile-name {
  display: block;
  float: left;
  padding-left: 10px;
  padding-top: 7px;
  font-size: 14px;
}
.post-header {
  height: 30px;
  padding: 10px;
}
.post-body {
  height: 450px;
  background-position: center;
  background-size: cover;
}
.post-content {
  padding-left: 15px;
  padding-right: 15px;
  font-size: 14px;
}
.date {
  font-size: 11px;
  color: grey;
  margin-top: -8px;
}
video {
  width: 100%;
  height: 100%;
}
</style>
