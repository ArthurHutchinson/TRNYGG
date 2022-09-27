<template>
  <div id="app">
    <div id="nav">
      <!-- logo -->
      <router-link v-bind:to="{ name: 'home' }">
        <img id="logo" src="./assets/trnygg.png">
      </router-link>
      <!--
        the v-if="$store.state.token" if it's ==, it's checking to see if the token is empty. Login and register will appear
        if it's != then that means token is not empty. They're logged in. Only logout will show.
      -->
      <div id="links">
        <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"> Login &nbsp;|&nbsp;</router-link>
        <router-link v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <hr>
    <router-view />
  </div>
</template>

<style>
  #nav {
    display: flex;
    justify-content: space-between;
  }

  #logo {
    width: 250px;
  }


</style>
