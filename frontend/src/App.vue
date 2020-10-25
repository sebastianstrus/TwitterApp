<template>
  <div id="app">
    <nav>
      <router-link to="/">
        <div class="navigation__logo">Twitter</div>
      </router-link>

      <ul class="navigation__lists">
        <li :class="{ hidden: !user }">
          <router-link to="/search">Search</router-link>
        </li>
        <li :class="{ hidden: !user }" @click="logout">Logout</li>
        <li v-if="user">
          <router-link
            :key="$route.fullPath"
            :to="{ name: 'UserProfile', params: { userId: this.user.id } }"
            >@{{ user.username }}</router-link
          >
        </li>
      </ul>
    </nav>
    <router-view />
  </div>
</template>



<script>
import { useStore } from "vuex";
import { computed } from "vue";

export default {
  name: "App",
  setup() {
    const store = useStore();
    const user = computed(() => store.state.user);
    return {
      user,
      store,
    };
  },
  methods: {
    logout() {
      this.store.dispatch("setUser", null);
      this.$router.push({ path: "/login" });
    },
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
      li:hover {
        color: #dddddd;
        cursor: pointer;
      }
    }

    .hidden {
      display: none;
    }
  }
}
</style>
