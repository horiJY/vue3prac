<template>
  <router-view />
  <Spinner :loading="$store.state.LoadingStatus" />
</template>

<script>
import Spinner from "@/components/Spinner";
export default {
  components: {
    Spinner,
  },
};
</script>

<style></style>
