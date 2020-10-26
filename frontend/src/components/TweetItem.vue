<template>
  <div class="tweet-item">
    <div class="user-profile__tweet">
      <div>
        <div class="tweet-item__username">@{{ username }}</div>
        <div class="tweet-item__date">{{ timestamp }}</div>
      </div>
      <div class="tweet-item__content">
        {{ body }}
      </div>
      <div
        :class="{ hidden: tweet.user.id != this.$store.state.user.id }"
        class="tweet-item__delete"
        @click="deleteTweet(tweet.id)"
      >
        Delete
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TweetItem",
  props: {
    username: {
      type: String,
      required: true,
    },
    body: {
      type: String,
      required: true,
    },
    timestamp: {
      type: String,
      required: true,
    },
    tweet: {
      type: Object,
      required: true,
    },
  },
  methods: {
    deleteTweet(id) {
      this.$emit("delete", id);
    },
  },
};
</script>

<style lang="scss" scoped>
.tweet-item {
  display: inline;
  padding: 20px;
  background-color: white;
  border-radius: 5px;
  border: 1px solid #dfe3e8;
  box-sizing: border-box;
  cursor: pointer;
  transition: all 0.25s ease;

  .hidden {
    display: none;
  }

  .tweet-item__username {
    display: inline;
    font-weight: bold;
  }

  .tweet-item__date {
    display: inline;
    font-weight: bold;
    color: #693250;
    float: right;
  }

  .tweet-item__content {
    display: inline;
  }

  .tweet-item__delete {
    font-size: 12px;
    padding: 1px;
    font-weight: 600;
    float: right;
    margin: 5px;
    border-radius: 5px;
    background-color: #693250;
    color: white;
    width: 50px;
    text-align: center;
  }

  &:hover {
    transform: scale(1.1, 1.1);
  }
}
</style>