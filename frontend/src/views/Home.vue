<template>
  <div class="home">
    <h1>Home</h1>
    <div class="users-list">
      <router-link
        v-for="user in users"
        :to="{ name: 'UserProfile', params: { userId: user.id } }"
        :key="user.id"
      >
        {{ user.username }}
      </router-link>
    </div>
    <div @click="getUsers()">Get users!</div>

    <div id="app">
      {{ info }}
    </div>
  </div>
</template>

<script>
import { users } from "../assets/users";
import axios from "axios";

export default {
  name: "Home",
  data() {
    return {
      users: users,
    };
  },
  methods: {
    getUsers() {
      alert("test");
      axios
        .get("http://jsonplaceholder.typicode.com/posts/1")
        .then((response) => (this.info = response));
      // this.$http
      //   .get("https://jsonplaceholder.typicode.com/posts")
      //   .then(function (data) {
      //     console.log(data);
      //   });
      // alert(
      //   "Username is: " + this.username + " \npassword is: " + this.password
      // );
      //TODO: say to the API: I like/unlike this tweet (change the function later))
    },
  },
  mounted() {
    axios
      .get("https://api.coindesk.com/v1/bpi/currentprice.json")
      .then((response) => (this.info = response));
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