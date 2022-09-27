<template>
  <div id="app">
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
        <router-link id="alogin" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"> Login &nbsp;</router-link>
        <router-link id="aregister" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link id="alogout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <router-view />
    <footer id="credits">
      <p>Webpage was made by: x, y, z</p>
      <p>Last updated: September 27, 2022</p>
    </footer>
  </div>
</template>

<style>
  #nav {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;

    border-bottom: 3px solid #825AB7; 

    background-color: #232328;
    
    position: relative;
    padding-top: 10px;
    padding-left: 10px;
    padding-right: 10px;
    padding-bottom: 3px;
    top: -10px;
  }

  #nav:before {
    content: "";
    background-color: #232328;
    position: absolute;
    left: -100%;
    bottom: -3px;
    top: -100%;
    right: 100%; 
    border-bottom: 3px solid #825AB7; 
  }
  
  #nav:after {
    content: "";
    background-color: #232328;
    position: absolute;
    left: 100%;
    bottom: -3px;
    top: -100%;
    right: -8px;
    border-bottom: 3px solid #825AB7; 
  }

  #logo img {
    width: 250px;
  }

  body {
    background-color: #32323A;
    color: white;
    font-family: Arial, Helvetica, sans-serif;
  }

  a {
    color: white;
  }

  #links #alogin {
    color: #825AB7;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    /* drop-shadow(offset-x offset-y blur-radius color) */
    text-shadow: -1.5px 1.5px 2px black;
  }

  #links #aregister {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    text-shadow: -1.5px 1.5px 2px black;
  }

  #links #alogout {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    text-shadow: -1.5px 1.5px 2px black;
  }

  #credits {
    position: fixed;
    bottom: 0;
    width: 100%;
    background-color: #232328;
    border-top: 3px solid #825AB7;
    text-align: center;
  }

  #credits:before {
    content: "";
    background-color: #232328;
    position: absolute;
    left: -100%;
    bottom: -100%;
    top: -3px;
    right: 100%; 
    border-top: 3px solid #825AB7; 
  }

  #credits:after {
    content: "";
    background-color: #232328;
    position: absolute;
    left: -100%;
    bottom: -100%;
    top: -3px;
    right: 100%; 
    border-top: 3px solid #825AB7; 
  }

</style>
