<template>
  <div class="tweet-item" @click="favouriteTweet(tweet.id)">
    <div class="user-profile__tweet">
      <div>
        <div class="tweet-item__username">@{{ username }}</div>
        <div class="tweet-item__date">{{ timestamp }}</div>
      </div>
      <div class="tweet-item__content">
        {{ body }}
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
    favouriteTweet(id) {
      this.$emit("favourite", id);
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

  &:hover {
    transform: scale(1.1, 1.1);
  }
}
</style>