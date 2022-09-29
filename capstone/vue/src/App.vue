<template>
  <div id="tapp">

    <b-navbar id="tnav">
      
      <div id="tlogo">
        <router-link v-bind:to="{ name: 'home' }" >
          <img src="./assets/trnygg.png">
        </router-link>
      </div>
      
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
      <div>
        <img id="logocredit" src="./assets/trnygg.png">
      </div>
      <div>
        <h4>Website made by:</h4>
        <p>
          Arthur Hutchinson
          <br>
          Jason Rosensteel
          <br>
          Trey Glover
          <br>
          Tyler Knight
        </p>
      </div>
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
    /* This might break things 1/2 */
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    /* This might break things 2/2 */
  }

  #credits {

    background-color: #232328;
    border-top: 3px solid #825AB7;
    text-align: center;
    color: white;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: space-between;
    
    /* position: fixed;
    bottom: 0;
    width: 100%; */ 
  }

  #logocredit {
    padding-top: 5px;
    padding-bottom: 5px;
    width: 300px;
    /* display: block;
    margin-left: auto;
    margin-right: auto; */
  }

</style>
