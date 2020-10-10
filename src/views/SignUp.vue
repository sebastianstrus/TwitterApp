<template>
  <div class="signup">
    <div class="signup-container">
      <div class="signup-container__header">
        <h2>Sign up</h2>
      </div>
      <div class="signup-container__form">
        <form>
          <label for="fname">Username:</label><br />
          <input type="text" id="fname" name="fname" /><br />
          <label for="lname">Password:</label><br />
          <input type="text" id="lname" name="lname" />
          <h6>
            Already have an account?

            <router-link to="/signin"> Sign in. </router-link>
          </h6>
          <button>Sign up</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "signup",
};
</script>

<style lang="scss" scoped>
.signup {
  padding: 50px 5%;
  .signup-container {
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

    .signup-container__form {
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