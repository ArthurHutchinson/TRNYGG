<template>
  <div id="tapp">

    <b-navbar id="tnav">
      <!-- logo -->
      <div id="tlogo">
        <router-link v-bind:to="{ name: 'home' }" >
          <img src="./assets/trnygg.png">
        </router-link>
      </div>
      <!--
        the v-if="$store.state.token" if it's ==, it's checking to see if the token is empty. Login and register will appear
        if it's != then that means token is not empty. They're logged in. Only logout will show.
      -->
      <div id="tlinks">
        <router-link id="alogin" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
        <router-link id="aregister" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''"> Register</router-link>
        <router-link id="alogout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </b-navbar>

    <div id="tmain">
      <router-view />
    </div>

    <div id="credits">
      <img id="logocredit" src="./assets/trnygg.png">
    </div>

  </div>
</template>

<style>

  html {
    height: 100%;
    background-color: #32323A;
    color: #fff;
  }

  #tapp {
    display: grid;
    background-color: #32323A;
    color: #ffffff;

  }

  #tnav {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;

    border-bottom: 3px solid #825AB7; 

    background-color: #232328;

    /* position: fixed;
    top: 0;
    width: 100%; */
  }

  #tlogo img {
    width: 250px;
  }

  #tlinks {
    display: flex;
    justify-content: space-between;
  }

  #tlinks #alogin {
    color: #825AB7;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    text-shadow: -1.5px 1.5px 2px black;
  }

  #tlinks #aregister {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    text-shadow: -1.5px 1.5px 2px black;
  }

  #tlinks #alogout {
    color: #FC7900;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
    text-shadow: -1.5px 1.5px 2px black;
  }

  #tmain {
  
  }

  #credits {

    background-color: #232328;
    border-top: 3px solid #825AB7;
    text-align: center;
    color: white;

    display: flex;
    justify-content: center;
    align-items: flex-end;

    /* position: fixed;
    bottom: 0;
    width: 100%; */
  }

  #logocredit {
    padding-top: 3px;
    width: 300px;
  }

</style>
