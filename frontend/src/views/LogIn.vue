<template>
  <div class="login">
    <div class="login-container">
      <div class="login-container__header">
        <h2>Log in {{ user.username }}</h2>
      </div>
      <div class="login-container__form">
        <h6 :class="{ '--hidden': !errored }" class="error__message">
          Check your credentials.
        </h6>
        <form @submit.prevent="loginTapped">
          <label for="fname">Username:</label><br />
          <input type="text" id="fname" name="fname" v-model="username" /><br />
          <label for="lname">Password:</label><br />
          <input type="password" id="lname" name="lname" v-model="password" />
          <h6>
            Don't have an account?

            <router-link to="/registration"> Sign up. </router-link>
          </h6>
          <button>Log in</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import store from "../store";
import axios from "axios";
export default {
  data() {
    return {
      user: "",
      username: "",
      password: "",
      errors: [],
      errored: false,
    };
  },
  name: "login",
  methods: {
    loginTapped() {
      if (
        this.username &&
        this.username != "" &&
        this.password &&
        this.password != ""
      ) {
        axios
          .get(`users/username/${this.username}`)
          .then((response) => {
            if (response.data[0].password == this.password) {
              const user = store.state.user;
              if (!user) {
                store.dispatch("setUser", response.data[0]);
                this.$router.push({ path: "/" });
              }
            } else {
              this.errored = true;
            }
          })
          .catch((error) => {
            console.log(error);
            this.errored = true;
          });
      } else {
        this.errored = true;
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.login {
  padding: 50px 5%;
  .login-container {
    border: 1px solid black;
    width: 300px;
    height: 250px;
    margin: 110px auto;
    border-radius: 10px;
    overflow: hidden;

    h2 {
      background-color: #693250;
      margin-top: 0px;
      text-align: center;
      color: white;
    }

    .login-container__form {
      padding-top: 10px;
      width: 200px;
      height: 100px;
      margin: auto;
      .error__message {
        position: absolute;
        float: center;
        color: red;
        margin: -20px 0 0 0;
      }
      .--hidden {
        display: none;
      }
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