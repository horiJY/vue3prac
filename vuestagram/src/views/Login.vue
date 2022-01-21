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
import axios from "axios";
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
      try {
        // console.log("......", process.env.NODE_ENV);
        let loginData = {};
        loginData.id = this.userId;
        loginData.password = this.userPassword;
        if (loginData.id != null && loginData.password != null) {
          let storeResult = await axios
            .post("/signin", loginData)
            // .post("http://172.30.1.17:8080/signin", loginData)
            .then((res) => {
              // this.$store.state.loading = true;
              if (res.data) {
                this.login(loginData.id);
                return true;
              } else {
                this.message = "ID, PW를 다시 확인해 주세요.";
                return false;
              }
            })
            .catch(() => {
              this.message = "서버와 연결할 수 없습니다.";
            });

          if (storeResult) {
            this.$router.push("/vuesta");
          }
        }
      } catch (error) {
        alert(error);
      }
    },
  },
};
</script>

<style></style>
