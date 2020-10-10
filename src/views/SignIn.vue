<template>
  <div class="signin">
    <div class="signin-container">
      <div class="signin-container__header">
        <h2>Sign in</h2>
      </div>
      <div class="signin-container__form">
        <form>
          <label for="fname">Username:</label><br />
          <input type="text" id="fname" name="fname" /><br />
          <label for="lname">Password:</label><br />
          <input type="text" id="lname" name="lname" />
          <h6>
            Don't have an account?

            <router-link to="/signup"> Sign up. </router-link>
          </h6>
          <button>Sign in</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "signin",
};
</script>

<style lang="scss" scoped>
.signin {
  padding: 50px 5%;
  .signin-container {
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

    .signin-container__form {
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