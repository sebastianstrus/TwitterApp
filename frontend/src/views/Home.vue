<template>
  <div class="home">
    <h1>Home</h1>
    <div class="users-list">
      <router-link
        v-for="user in users"
        :to="{ name: 'UserProfile', params: { userId: user.id } }"
        :key="user.id"
      >
        <h3>{{ user.username }}</h3>
      </router-link>
    </div>
    <div @click="getUsers()">Get users!</div>

    <div id="app">{{ users }}</div>
    <div id="app">{{ posts }}</div>
  </div>
</template>

<script>
import { users } from "../assets/users";
import axios from "axios";

export default {
  name: "Home",
  data() {
    return {
      users: [],
      posts: [],
      errors: [],
      errored: false,
    };
  },
  methods: {
    getUsers() {
      axios
        .get("http://localhost:1337/users/")
        .then((response) => (this.users = response.data))
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },
    getPosts() {
      axios
        .get("http://localhost:1337/posts/")
        .then((response) => (this.posts = response.data));
    },
  },
  mounted() {
    this.getUsers();
    this.getPosts();
  },
};
</script>

<style lang="scss" scoped>
.home {
  padding: 50px 5%;

  .users-list {
    display: flex;
    flex-direction: column;
  }
}
</style>