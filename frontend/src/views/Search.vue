<template>
  <div class="search">
    <h1>Find users</h1>
    <input
      class="search__textfield"
      type="text"
      placeholder="Type username..."
      @input="getUsers()"
      v-model="str"
    />

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
import axios from "axios";

export default {
  name: "Search",
  str: "",
  data() {
    return {
      users: [],
      errors: [],
      errored: false,
    };
  },
  methods: {
    getUsers() {
      if (this.str != "") {
        axios
          .get(`http://localhost:8080/users/search/${this.str}`)
          .then((response) => (this.users = response.data))
          .catch((error) => {
            console.log(error);
            this.errored = true;
          });
      } else {
        this.users = [];
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.search {
  padding: 50px 35%;

  h1 {
    font-weight: 700;
    margin: 10px;
  }

  input {
    padding: 8px;
    margin: 20px 8px;
  }

  .search__textfield {
    width: 200px;
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