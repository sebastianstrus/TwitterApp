<template>
  <div class="registration">
    <div class="registration-container">
      <div class="registration-container__header">
        <h2>Sign up</h2>
      </div>
      <div class="registration-container__form">
        <form @submit.prevent="signupTapped">
          <label for="fname">Username:</label><br />
          <input type="text" id="fname" name="fname" v-model="username" /><br />
          <label for="lname">Password:</label><br />
          <input type="text" id="lname" name="lname" v-model="password" />
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
export default {
  name: "registration",
  data() {
    return {
      username: "",
      password: "",
      errored: false,
    };
  },
  methods: {
    signupTapped() {
      if (
        this.username &&
        this.username != "" &&
        this.password &&
        this.password != ""
      ) {
        axios
          .post("http://localhost:8080/users", {
            username: this.username,
            password: this.password,
          })
          .then((response) => {
            alert(
              "Response.data: " +
                response.data.id +
                " " +
                response.data.username +
                " " +
                response.data.password
            );
          })
          .catch((error) => {
            alert("Something went wrong");
            this.errored = true;
          });
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

    .registration-container__form {
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