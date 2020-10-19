import { createStore } from 'vuex'

export default createStore({
  state: {
    user: null,

  },

  // Functions that affect the state
  mutations: {
    SET_USER(state, user) {
      state.user = user;
    }

  },

  // functions that call mutations
  actions: {

  },

  modules: {

  }
})
