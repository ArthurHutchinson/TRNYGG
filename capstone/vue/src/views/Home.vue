<template>
  <div class="home">
    <router-link :to="{ name: 'login' }">Login</router-link>
    <br>
    <router-link :to="{ name: 'register' }">Register</router-link>
    <h1>Home</h1>
    <p>You must be NOT authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
