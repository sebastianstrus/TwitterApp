<template>
  <div class="registration">
    <div class="registration-container">
      <div class="registration-container__header">
        <h2>Sign up</h2>
      </div>
      <div class="registration-container__form">
        <h6 :class="{ '--hidden': !errored }" class="error__message">
          Check your credentials.
        </h6>
        <form @submit.prevent="signupTapped">
          <label for="username">Username:</label><br />
          <input
            type="text"
            id="username"
            name="username"
            v-model="username"
          /><br />
          <label for="password">Password:</label><br />
          <input
            type="password"
            id="password"
            name="password"
            v-model="password"
          />
          <label for="password2">Repeat password:</label><br />
          <input
            type="password"
            id="password2"
            name="password2"
            v-model="password2"
          />
          <h6>
            Already have an account?

            <router-link to="/login"> Sign in. </router-link>
          </h6>
          <button>Sign up</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import store from "../store";
import axios from "axios";
export default {
  name: "registration",
  data() {
    return {
      username: "",
      password: "",
      password2: "",
      errored: false,
    };
  },
  methods: {
    signupTapped() {
      if (
        this.username &&
        this.username != "" &&
        this.password &&
        this.password != "" &&
        this.password === this.password2
      ) {
        axios
          .post("users", {
            username: this.username,
            password: this.password,
          })
          .then((response) => {
            store.dispatch("setUser", response.data);
            this.$router.push({ path: "/" });
          })
          .catch((error) => {
            console.log(error);
            alert("Something went wrong.");
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
.registration {
  padding: 50px 5%;
  .registration-container {
    padding: 0px;
    border: 1px solid black;
    width: 300px;
    height: 300px;
    margin: 85px auto;
    border-radius: 10px;
    overflow: hidden;

    h2 {
      background-color: #693250;
      margin-top: 0px;
      text-align: center;
      color: white;
    }

    .registration-container__form {
      padding-top: 10px;
      width: 200px;
      height: 100px;
      margin: auto;
    }
    .error__message {
      position: absolute;
      float: center;
      color: red;
      margin: -20px 0 0 0;
    }
    .--hidden {
      display: none;
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