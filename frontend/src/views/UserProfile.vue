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
          <strong>Following: {{ user.followings.length }}</strong>
        </div>

        <div class="user-profile__bio">
          <strong>Bio:</strong>
          <strong>{{ user.bio }}</strong>
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
    // addTweet(tweet) {
    //   axios
    //     .post(`http://localhost:8080/posts`, {
    //       user: this.user,
    //       body: tweet,
    //     })
    //     .then((response) => {
    //       this.posts.unshift(response.data);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //       this.errored = true;
    //     });
    // },
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
  },
  mounted() {
    this.getUser();
    this.getPostsByUserId();
    //this.getUser();
    // this.followUser();
    // this.followUser();
    // //this.user = users[this.$route.params.userId];
    // console.log(this.$route.params.userId);
    // console.log(this.$route.params);
    // console.log(this.$route.params);
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

    .user-profile__admin-badge {
      background: #693250;
      color: white;
      border-radius: 5px;
      margin-right: auto;
      padding: 0 10px;
      font-weight: bold;
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
