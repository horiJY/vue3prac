<template>
  <div>
    <card flat class="mx-auto" max-width="800">
      <row style="margin-top: 60px">
        <col />
        <form style="width: 400px; height: 300px">
          <div class="mx-3">
            😊 userId
            <div class="mx-1">
              <textarea placeholder="userId" model="userId" required />
            </div>
          </div>
          <div class="mx-3">
            🧱 userPassword
            <div class="mx-1">
              <textarea
                placeholder="userPassword"
                type="password"
                model="userPassword"
                required
              />
            </div>
          </div>
          <button style="color: #2c4f91" @click="loginSubmit">Login</button>
        </form>
      </row>
    </card>
  </div>
</template>

<script>
// export default {
//   data() {
//     return { userId: null, userPassword: null };
//   },
//   methods: {
//     loginSubmit() {
//       let saveData = {};
//       saveData.userId = this.userId;
//       saveData.userPassword = this.userPassword;
//       try {
//         this.$axios
//           .post(HOST + "/signin", JSON.stringify(saveData), {
//             headers: { "Content-Type": `application/json` },
//           })
//           .then((res) => {
//             if (res.status === 200) {
//               // 로그인 성공시 처리해줘야할 부분
//               this.$store.commit("login", res.data);
//               this.$router.push("이동할 페이지 path");
//             }
//           });
//       } catch (error) {
//         console.error(error);
//       }
//     },
//   },
// };
</script>

<style></style>
