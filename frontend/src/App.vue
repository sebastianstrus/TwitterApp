<template>
  <div id="app">
    <nav>
      <router-link to="/login">
        <div class="navigation__logo">Twitter</div>
      </router-link>

      <ul class="navigation__lists">
        <li class="hidden">Search</li>
        <li class="hidden">Logout</li>
        <li v-if="user">{{ user.username }}</li>
        <!-- <li>{{ state.user.username }}</li> -->
      </ul>
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
    align-items: center;
    padding: 10px 5%;
    background-color: #693250;
    color: white;
    font-weight: bold;

    .navigation__logo {
      display: inline-block;
      font-size: 24px;
      width: 100px;
    }

    ul {
      margin: 10px 0;
      float: right;
      list-style: none;
      li {
        align-items: center;
        display: inline;
        margin: 20px;
      }
    }
  }
}
</style>
