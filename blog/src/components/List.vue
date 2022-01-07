<template>
  <div v-for="c in contents" :key="c">
    <h4 @click="$router.push('/detail/' + c.id)">{{ c.title }}</h4>
    <p>{{ c.date }}</p>
  </div>
</template>

<script>
export default {
  name: 'List',
  props: {
    contents: Array,
  },
};
</script>

<style></style>
