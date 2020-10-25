<template>
  <div class="followings">
    <h1>Followings</h1>

    <!-- <button @click="getUsers()">Get users!</button> -->
    <div class="users-list">
      <router-link
        v-for="user in users"
        :to="{ name: 'UserProfile', params: { userId: user.id } }"
        :key="user.id"
      >
        <div class="users-list__item">
          <h3>{{ user.username }}</h3>
        </div>
      </router-link>
    </div>

    <!-- <div>{{ users }}</div> -->
  </div>
</template>

<script>
import store from "../store";
// import axios from "axios";

export default {
  name: "followings",
  data() {
    return {
      user: { username: "", followings: [] },
      users: [],
      errors: [],
      errored: false,
    };
  },
  methods: {
    getUsers() {
      this.user = store.state.user;

      // TODO create request in the backend
      this.user.followings.forEach((id) => {
        axios
          .get(`http://localhost:8080/users/${id}`)
          .then((response) => {
            this.users.push(response.data);
          })
          .catch((error) => {
            console.log(error);
            this.errored = true;
          });
      });
    },
  },
  mounted() {
    this.getUsers();
  },
};
</script>

<style lang="scss" scoped>
.followings {
  padding: 50px 35%;

  h1 {
    font-weight: 700;
    margin: 10px;
  }

  .users-list {
    display: flex;
    flex-direction: column;

    .users-list__item {
      h3 {
        color: #693250;
        margin: 6px;
        padding: 8px;
        font-weight: 700;
        border: 0.1px solid #888888;
        box-shadow: 4px 4px 3px #888888;

        border-radius: 5px;
        background-color: #eeeeee;
      }
    }
  }
}
</style>