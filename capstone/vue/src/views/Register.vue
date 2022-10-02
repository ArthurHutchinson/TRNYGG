<template>

  <div id="register" class="text-center">

    <form class="form-register" @submit.prevent="register">

      <h1 id="t-cr-acct-h" class="h3 mb-3 font-weight-normal">Create Account</h1>

      <div id="t-alert" class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <label for="username" class="sr-only">Username</label>

      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />

      <label for="password" class="sr-only">Password</label>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />

      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />

      <b-button id="t-crt-btn" type="submit">
        Create Account
      </b-button>

      <br>
      <router-link id="t-q-acct-link" :to="{ name: 'login' }">Have an account?</router-link>

    </form>

  </div>

</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
  #confirmPassword {
    text-align: center;

    margin: 0 auto;
    width: 500px;
  }

  #t-crt-btn {
    position: relative;
    top: 5px;
    
    background-color: #FC7900;
    border: none;
    
    font-family: 'Chakra Petch', sans-serif;
  }

  #t-crt-btn:hover {
    background-color: #c45f00;
  }

  #t-q-acct-link {
    position: relative;
    top: 5px;
    color:#FC7900;
  }

  #t-q-acct-link:hover {
    color: #c45f00;
  }

  #t-cr-acct-h {
    font-family: 'Chakra Petch', sans-serif;
    color: #a875eb;
    text-shadow: 2px 2px 2px black;
  }

  


</style>
