import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import User from '../views/User.vue'
import TestPage from '../views/TestPage.vue'
import TournamentPage from '../views/TournamentPage.vue'
import CreateTournament from '../views/CreateTournament.vue'
import TSearchResult from '../views/TSearchResults.vue'
import TournamentEditPage from '../views/TournamentEditPage.vue'


// import TournamentPage from '../views/TournamentPage.vue'
// import TournamentList from '../views/TournamentList.vue'

import store from '../store/index'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

// The above line makes 0 sense according to what the client wants. Front page needs to show an unauthenticated user the user created tournaments. - Arthur

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/secret-page',
      name: 'secret-page',
      component: TestPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/user',
      name: 'user',
      component: User,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tournament/:id",
      name: "tournament-page",
      component: TournamentPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tournament/:id/edit",
      name: "tournament-page-edit",
      component: TournamentEditPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/createTournament",
      name: "create-tournament-page",
      component: CreateTournament,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/search",
      name: "tournament-search-results",
      component: TSearchResult,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: "/tournamentList",
    //   name: "tournament-list",
    //   component: TournamentList,
    //   meta: {
    //     requiresAuth: true
    //   }
    // }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  // This was default, switching it to Home.vue - Arthur
  if (requiresAuth && store.state.token === '') {
    next("/");
  } else {
    // Else let them go to their next destination
    next();
  }
});
export default router;
