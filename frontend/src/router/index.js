import { createRouter, createWebHistory } from 'vue-router'
import store from '../store'
import Home from '../views/Home.vue'
import LogIn from '../views/LogIn.vue'
import Registration from '../views/Registration.vue'
import UserProfile from '../views/UserProfile.vue'
import Search from '../views/Search.vue'
import Followings from '../views/Followings.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      requiresUser: true
    }
  },
  {
    path: '/followings',
    name: 'followings',
    component: Followings,
    meta: {
      requiresUser: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LogIn,
    meta: {
      requiresUser: false
    }

  },
  {
    path: '/registration',
    name: 'registration',
    component: Registration,
    meta: {
      requiresUser: false
    }
  },
  {
    path: '/user/:userId',
    name: 'UserProfile',
    component: UserProfile,
    meta: {
      requiresUser: true
    }
  },
  {
    path: '/search',
    name: 'Search',
    component: Search,
    meta: {
      requiresUser: true
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach(async (to, from, next) => {
  const user = store.state.user;
  const requiresUser = to.matched.some(record => record.meta.requiresUser);
  if (requiresUser && (user == null)) next({ name: 'login' })
  else next();

})

export default router
