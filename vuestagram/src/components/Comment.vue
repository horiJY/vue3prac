<template>
  <div class="comment">
    <div class="comment-header">
      <span>댓 글</span>
    </div>
    <div class="comment-body">
      <textarea type="text" placeholder="✈️ Add a comment..." />
      <span>Post</span>
    </div>
  </div>
</template>

<script></script>

<style>
.comment {
  width: 100%;
}
.comment-header {
  height: 30px;
  text-align: center;
  padding: 10px;
}
.comment-body {
  height: 450px;
  background-position: center;
  background-size: cover;
}
.comment-body {
  height: 30px;
  padding: 0 5%;
  width: 100%;
}
.comment-body textarea {
  width: 80%;
  height: 100%;
  font-size: 14px;
  border: solid 2px gainsboro;
  border-radius: 5px;
}
.comment-body span {
  height: 100%;
  padding-left: 3%;
  width: 5%;
  color: dodgerblue;
}
.date {
  font-size: 11px;
  color: grey;
  margin-top: -8px;
}
</style>
