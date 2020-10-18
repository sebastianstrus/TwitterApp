<template>
  <div class="home">
    <h1>Home</h1>
    <button @click="getUsers()">Get users!</button>
    <div class="users-list">
      <router-link
        v-for="user in users"
        :to="{ name: 'UserProfile', params: { userId: user.id } }"
        :key="user.id"
      >
        <h3>{{ user.id }} {{ user.username }}</h3>
      </router-link>
    </div>

    <div>{{ users }}</div>
    <button @click="getPosts()">Get posts!</button>
    <div>{{ posts }}</div>
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
        .get("http://localhost:8080/users/")
        .then((response) => (this.users = response.data))
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },
    getPosts() {
      axios
        .get("http://localhost:8080/posts/")
        .then((response) => (this.posts = response.data))
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },
  },
  mounted() {
    //this.getPosts();
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