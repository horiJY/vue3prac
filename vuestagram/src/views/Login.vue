<template>
  <div>
    <form style="width: 400px; height: 300px; margin: 30%">
      <div>
        😊 ID
        <div>
          <input placeholder="userId" v-model="userId" required />
        </div>
      </div>
      <div style="margin: 5% 0">
        🧱 PASSWORD
        <div>
          <input
            placeholder="userPassword"
            type="password"
            v-model="userPassword"
            required
          />
        </div>
        <p style="color: red">{{ message }}</p>
      </div>
      <button style="color: #2c4f91" @click.prevent="loginSubmit">Login</button>
    </form>
  </div>
</template>

<script>
// import axios from "axios";
import { mapActions } from "vuex";

export default {
  name: "Login",
  data() {
    return {
      userId: null,
      userPassword: null,
      message: null,
    };
  },
  methods: {
    ...mapActions("userStore", ["login"]),
    async loginSubmit() {
      let saveData = {};
      saveData.id = this.userId;
      saveData.password = this.userPassword;
      if (saveData.id != null && saveData.password != null) {
        await this.login(saveData);
        if (this.$store.getters["userStore/getIsAuth"]) {
          this.$router.push("/vuesta");
        } else {
          this.message = this.$store.getters["userStore/getErrorState"];
        }
      }
    },
  },
};
</script>

<style></style>
