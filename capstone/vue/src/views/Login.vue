<template>

  <div id="login" class="text-center">
    
    <form class="form-signin" @submit.prevent="login">

      <h1 id="t-login-h" class="h3 mb-3 font-weight-normal">Please Sign In</h1>

      <div
        id="t-alert"
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials">
        Invalid username and password!
      </div>

      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <label for="username" class="sr-only">Username</label>

      <b-form-input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />

      <label for="password" class="sr-only">Password</label>

      <b-form-input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />

      <b-button id="t-login-btn" type="submit">Sign in</b-button>

      <br>

      <router-link id="t-register-link" :to="{ name: 'register' }">Need an account?</router-link>

    </form>

  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

  #t-login-h {
    font-family: 'Chakra Petch', sans-serif;
    color: #a875eb;
    text-shadow: 2px 2px 2px black;
  }

  #username {
    margin: 0 auto;

    width: 500px;
    text-align: center;
  }

  #password {
    margin: 0 auto;

    width: 500px;
    text-align: center;
  }

  #t-alert {
    margin: 0 auto;
    width: 500px;
  }

  #t-login-btn {
    position: relative;
    top: 5px;
    
    background-color: #FC7900;
    border: none; 

    font-family: 'Chakra Petch', sans-serif;
  }

  #t-login-btn:hover {
    background-color: #c45f00;
  }


  #t-register-link {
    position: relative;
    top: 5px;
    color:#FC7900;
  }

  #t-register-link:hover {
    color: #c45f00
  }

</style>