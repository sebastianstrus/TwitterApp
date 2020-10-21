<template>
  <div class="user-profile">
    <div class="user-profile__sidebar">
      <div class="user-profile__user-panel">
        <h1 class="user-profile__username">@{{ user.username }}</h1>
        <!-- <h2>Ueser id: {{ user.id }}</h2>
        <h3>{{ $route.params.userId }}</h3> -->
        <div
          :class="{ hidden: user.id != this.$store.state.user.id }"
          class="user-profile__admin-badge"
          v-if="isAdmin"
        >
          Admin
        </div>
        <div class="user-profile__follower-count">
          <h4>Following: {{ user.followings.length }}</h4>
        </div>

        <div class="user-profile__bio">
          <h4>Bio:</h4>
          <h4>{{ user.bio }}</h4>
        </div>

        <div
          :class="{ hidden: user.id != this.$store.state.user.id }"
          class="edit_section"
          v-if="isAdmin"
        >
          <textarea
            v-model="bioContent"
            name="bio"
            id="bio_id"
            cols="30"
            rows="3"
          ></textarea>
          <button
            id="bio_button"
            :class="{ hidden: user.id != this.$store.state.user.id }"
            class="user-profile__admin-btn"
            v-if="isAdmin"
            @click="updateBio()"
          >
            Update bio
          </button>

          <input
            v-model="oldPasswordContent"
            class="user-profile__password_field"
            type="text"
            placeholder="Old password"
          />
          <input
            v-model="newPasswordContent"
            class="user-profile__password_field"
            type="text"
            placeholder="New password"
          />
          <button
            :class="{ hidden: user.id != this.$store.state.user.id }"
            class="user-profile__admin-btn"
            v-if="isAdmin"
            @click="updatePassword()"
          >
            Update password
          </button>
        </div>
      </div>
      <!-- <CreateTweetPanel @add-tweet="addTweet" /> -->
    </div>
    <div class="user-profile__tweets-wrapper">
      <TweetItem
        v-for="tweet in posts"
        :key="tweet.id"
        :username="tweet.user.username"
        :body="tweet.body"
        :timestamp="this.toDate(tweet.timestamp)"
        :tweet="tweet"
        @delete="deleteTweet(tweet.id)"
      />
    </div>
  </div>
</template>

<script>
// import { computed } from "vue";
import store from "../store";
import { actions } from "../store";
import { useRoute } from "vue-router";
import { users } from "../assets/users";
import TweetItem from "../components/TweetItem";
import CreateTweetPanel from "../components/CreateTweetPanel";

export default {
  name: "UserProfile",

  components: { CreateTweetPanel, TweetItem },
  //beforeCreated() {},
  data() {
    return {
      isAdmin: true,
      user: { username: "", followings: [] },
      posts: "",
      errored: false,
      bioContent: "",
      oldPasswordContent: "",
      newPasswordContent: "",
    };
  },
  methods: {
    deleteTweet(id) {
      axios
        .delete(`http://localhost:8080/posts/${id}`)
        .then((response) => {
          // TODO: simplyfy
          this.getPostsByUserId();
        })
        .catch((error) => {
          alert(error);
          console.log(error);
          this.errored = true;
        });
    },
    getUser() {
      axios
        .get(`http://localhost:8080/users/${this.$route.params.userId}`)
        .then((response) => {
          this.user = response.data;
        })
        .catch((error) => {
          alert(error);
          console.log(error);
          this.errored = true;
        });
    },
    getPostsByUserId() {
      axios
        .get(`http://localhost:8080/posts/user/${this.$route.params.userId}`)
        .then((response) => {
          this.posts = response.data;
          // Sort posts, TODO: move do backend
          this.posts.sort(function (a, b) {
            return b.timestamp - a.timestamp;
          });
        })
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },
    toDate(timestamp) {
      var date = new Date(timestamp * 1000);
      var year = date.getFullYear();
      var tempMonth = date.getMonth() + 1;
      var monthLength = ("" + tempMonth).length;
      var month = monthLength < 2 ? "0" + tempMonth : tempMonth;
      var dayLength = ("" + date.getDate()).length;
      var day = dayLength < 2 ? "0" + date.getDate() : date.getDate();
      var hours = date.getHours();
      var minutes = "0" + date.getMinutes();
      var seconds = "0" + date.getSeconds();
      var formattedTime = `${year}-${month}-${day} ${hours}:${minutes.substr(
        -2
      )}:${seconds.substr(-2)}`;
      return formattedTime;
    },

    updateBio() {
      var tempUser = this.user;
      tempUser.bio = this.bioContent;
      axios
        .put(`http://localhost:8080/users/${tempUser.id}`, tempUser) //TODO, remove id
        .then((response) => {
          store.dispatch("setUser", response.data);
          this.bioContent = "";
          alert("Updated!");
        })
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
    },

    updatePassword() {
      if (this.oldPasswordContent == this.user.password) {
        var tempUser = this.user;
        tempUser.password = this.newPasswordContent;

        axios
          .put(`http://localhost:8080/users/${tempUser.id}`, tempUser) //TODO, remove id
          .then((response) => {
            store.dispatch("setUser", response.data);
            this.oldPasswordContent = "";
            this.newPasswordContent = "";
            alert("Password updated!");
          })
          .catch((error) => {
            console.log(error);
            this.errored = true;
          });
      } else {
        alert("Check your password and try again.");
      }
    },
  },
  mounted() {
    this.getUser();
    this.getPostsByUserId();
  },
};
</script>

<style lang="scss">
.user-profile {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-gap: 50px;
  padding: 50px 5%;

  .user-profile__user-panel {
    display: flex;
    flex-direction: column;
    padding: 20px;
    background-color: white;
    border-radius: 5px;
    border: 1px solid #dfe3e8;
    margin-bottom: auto;

    h1 {
      margin: 0;
    }

    h4 {
      margin: 8px;
    }

    #bio_button {
      margin-bottom: 80px;
    }
    .user-profile__password_field {
      width: 160px;
      margin: 8px;
    }

    .user-profile__admin-badge {
      background: #693250;
      color: white;
      border-radius: 5px;
      margin-right: auto;
      padding: 0 10px;
      font-weight: bold;
    }

    .user-profile__admin-btn {
      margin: 8px;
      width: 160px;
    }
  }

  .user-profile__tweets-wrapper {
    display: grid;
    grid-gap: 10px;
    margin-bottom: auto;
  }
}

.hidden {
  display: none;
}
</style>
