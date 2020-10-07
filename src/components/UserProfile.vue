<template>
  <div class="user-profile">
    <div class="user-profile__user-panel">
      <h1 class="user-profile__username">@{{ user.username }}</h1>
      <div class="user-profile__admin-badge" v-if="user.isAdmin">Admin</div>
      <div class="user-profile__follower-count">
        <strong>Followers: </strong> {{ followers }}
      </div>
      <form
        class="user-profile__create-tweet"
        @submit.prevent="createNewTweet"
        :class="{ '--exceeded': newTweetCharacterCount > 180 }"
      >
        <label for="newTweet"
          ><strong>New Tweet</strong> ({{ newTweetCharacterCount }}/180)</label
        >
        <textarea id="newTweet" rows="4" v-model="newTweetContent" />
        <button>Tweet!</button>
      </form>
    </div>
    <div class="user-profile__tweets-wrapper">
      <TweetItem
        v-for="tweet in user.tweets"
        :key="tweet.id"
        :username="user.username"
        :tweet="tweet"
        @favourite="toggleFavourite"
      />
    </div>
  </div>
</template>

<script>
import TweetItem from "./TweetItem";

export default {
  name: "UserProfile",
  components: { TweetItem },
  data() {
    return {
      newTweetContent: "",
      followers: 0,
      user: {
        id: 1,
        username: "_SebastianStrus",
        firstName: "Sebastian",
        lastName: "Strus",
        email: "sebastian.strus1@gmail.com",
        isAdmin: true,
        tweets: [
          { id: 1, content: "TwitterApp is cool!" },
          { id: 2, content: "Don't forget to subscribe!" },
        ],
      },
    };
  },
  watch: {
    followers(newFollowerAccount, oldFollowerAccount) {
      if (oldFollowerAccount < newFollowerAccount) {
        console.log(`${this.user.username} has gained a follower!`);
      }
    },
  },
  computed: {
    newTweetCharacterCount() {
      return this.newTweetContent.length;
    },
    fullName() {
      return `${this.user.firstName} ${this.user.lastName}`;
    },
  },
  methods: {
    followUser() {
      this.followers++;
    },
    toggleFavourite(id) {
      console.log(`Favourited tweet #${id}`);
    },
    createNewTweet() {
      if (this.newTweetContent) {
        this.user.tweets.unshift({
          id: this.user.tweets.length + 1,
          content: this.newTweetContent,
          // TODO: send to API
        });
        this.newTweetContent = "";
      }
    },
  },
  mounted() {
    this.followUser();
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

    .user-profile__create-tweet {
      display: flex;
      flex-direction: column;

      &.--exceeded {
        color: red;
        border-color: red;
        // button {
        //   background-color: #dddddd;
        //   border: 2px solid red;
        // }
      }
    }
  }

  .user-profile__tweets-wrapper {
    display: grid;
    grid-gap: 10px;
  }
}
</style>
