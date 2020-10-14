<template>
  <div id="app">
    <nav>
      <router-link to="/login">
        <div class="navigation__logo">Twitter</div>
      </router-link>

      <!-- <div class="navigation__user">
        <p>{{ user.username }}</p>
      </div> -->
    </nav>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      user: {
        username: "_SebastianStrus",
      },
    };
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  min-height: 100vh;
  background-color: #f3f5fa;

  nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 10px 5%;
    background-color: #693250;
    color: white;

    .navigation__logo {
      font-weight: bold;
      font-size: 24px;
    }

    .navigation__user {
      display: inline-flex;
      font-weight: bold;
      width: 200px;

      p {
        margin: 20px;
      }
    }
  }
}
</style>
