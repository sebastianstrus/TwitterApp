import { createStore } from 'vuex'

export default createStore({
  state: {
    user: null
    // user: {
    //   "id": 1,
    //   "username": "Sebastian1",
    //   "password": "Password1",
    //   "followings": [
    //     3,
    //     5
    //   ],
    //   "bio": "I have a bio 1"
    // },

  },

  // Functions that affect the state
  mutations: {
    SET_USER(state, user) {
      state.user = user;
    },
    UNSET_USER() {
      state.user = null;
    }

  },

  // functions that call mutations
  actions: {
    setUser({ commit }, user) {
      commit('SET_USER', user);

    },
    unsetUser({ commit }) {
      commit('UNSET_USER');

    }

  },

  modules: {

  }
})
