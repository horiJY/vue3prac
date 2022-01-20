<template>
  <router-view />
  <Spinner :loading="$store.state.LoadingStatus" />
  <button @click="on">On</button>
</template>

<script>
import Spinner from "@/components/Spinner";
import store from "@/store/store";

export default {
  components: {
    Spinner,
  },
  methods: {
    on() {
      store.commit("startSpinner");
    },
  },
};
</script>

<style></style>
