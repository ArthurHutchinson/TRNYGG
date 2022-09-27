<template>
  <div id="app">
    <div id="navwithhr">
    <div id="nav">
      <!-- logo -->
      <div id="logo">
      <router-link v-bind:to="{ name: 'home' }" >
        <img src="./assets/trnygg.png">
      </router-link>
      </div>
      <!--
        the v-if="$store.state.token" if it's ==, it's checking to see if the token is empty. Login and register will appear
        if it's != then that means token is not empty. They're logged in. Only logout will show.
      -->
      <div id="links">
        <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"> Login &nbsp;</router-link>
        <router-link v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link id="alogout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
      <hr>
    </div>
    <router-view />
  </div>
</template>

<style>

  #navwithhr {
    background-color: #232328;
  }

  #nav {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
  }

  #logo img {
    width: 250px;
  }

  body {
    background-color: #32323A;
    color: white;
    font-family: Arial, Helvetica, sans-serif;
  }

  hr {
    height: 3px;
    background-color: #825AB7;
    border: none;
  }

  a {
    color: white;
  }

  #links a:nth-child(1) {
    color: #825AB7;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
  }

  #links a:nth-child(2) {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
  }

  #links #alogout {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
  }




</style>
