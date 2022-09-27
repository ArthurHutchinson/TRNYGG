<template>
  <div id="app">
    <div id="nav">
      <!--
        the v-if="$store.state.token" if it's ==, it's checking to see if the token is empty. Login and register will appear
        if it's != then that means token is not empty. They're logged in. Only logout will show.
      -->
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login&nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <hr>
    </div>
    <router-view />
  </div>
</template>

<style>
  /* #nav {
    background-color: rgb(54, 54, 61);
  } */
</style>
