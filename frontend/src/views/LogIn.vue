<template>
  <div class="login">
    <div class="login-container">
      <div class="login-container__header">
        <h2>Log in</h2>
      </div>
      <div class="login-container__form">
        <form @submit.prevent="loginTapped">
          <label for="fname">Username:</label><br />
          <input type="text" id="fname" name="fname" v-model="username" /><br />
          <label for="lname">Password:</label><br />
          <input type="text" id="lname" name="lname" v-model="password" />
          <h6>
            Don't have an account?

            <router-link to="/registration"> Sign up. </router-link>
          </h6>
          <button>Log In</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  methods: {
    loginTapped() {
      // alert(
      //   "Username is: " + this.username + " \npassword is: " + this.password,
      // );
      this.$router.push("/");
      //TODO: say to the API: I like/unlike this tweet (change the function later))
    },
    getUsers() {
      axios
        .get("http://localhost:1337/users/")
        .then((response) => (this.users = response.data))
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },
  },
};
</script>

<style lang="scss" scoped>
.login {
  padding: 50px 5%;
  .login-container {
    padding: 0px;
    border: 1px solid black;
    width: 300px;
    height: 240px;
    margin: 100px auto;
    border-radius: 10px;
    overflow: hidden;

    h2 {
      background-color: #693250;
      margin-top: 0px;
      text-align: center;
      color: white;
    }

    .login-container__form {
      width: 200px;
      height: 100px;
      margin: auto;
    }
    form {
      display: block;

      input {
        margin-bottom: 8px;
        width: 100%;
      }
      h6 {
        font-size: 12px;
        margin: 0px;
        margin-bottom: 16px;
        text-align: center;

        a {
          color: #693250;
        }
      }

      button {
        display: block;
        margin: auto;
        width: 100px;
        background-color: #693250;
        color: white;
        border-radius: 5px;
      }
    }
  }
}
</style>