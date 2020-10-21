import { createRouter, createWebHistory } from 'vue-router'
import store from '../store'
import Home from '../views/Home.vue'
import LogIn from '../views/LogIn.vue'
import Registration from '../views/Registration.vue'
import UserProfile from '../views/UserProfile.vue'
import Search from '../views/Search.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      requiresAdmin: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LogIn
  },
  {
    path: '/registration',
    name: 'registration',
    component: Registration
  },
  {
    path: '/user/:userId',
    name: 'UserProfile',
    component: UserProfile,
    meta: {
      requiresAdmin: true
    }
  },
  {
    path: '/search',
    name: 'Search',
    component: Search,
    meta: {
      requiresAdmin: true
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach(async (to, from, next) => {
  const user = store.state.user;
  if (!user) {
    await store.dispach('setUser', {
      "id": 1,
      "username": "Sebastian1",
      "password": "Password1",
      "followings": [
        3,
        5
      ],
      "bio": "I have a bio 1"
    })
  }
  const isAdmin = true;
  const requiresAdmin = to.matched.some(record => record.meta.requiresAdmin);

  if (requiresAdmin && !isAdmin) next({ name: 'login' })
  else next();

})

export default router
