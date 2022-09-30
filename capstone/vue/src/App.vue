<template>
  <div id="tapp">

    <b-navbar id="tnav">

      <div id="t-logo-search-bar">

       <b-navbar-nav>
        <div id="tlogo">
          <router-link v-bind:to="{ name: 'home' }" >
            <img src="./assets/trnygg.png">
          </router-link>
        </div>
       </b-navbar-nav>

    <nav-search-bar/>

    </div>
    
    <b-navbar-nav>
      <div id="tlinks">
        <b-button id="alogin" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</b-button>
        <b-button id="aregister" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''"> Register</b-button>
        <b-button id="alogout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</b-button>
      </div>
    </b-navbar-nav>

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
          Arthur Hutchinson | 
          Jason Rosensteel
          <br>
          Trey Glover |
          Tyler Knightly
        </p>
        
      </div>
    </div>

  </div>
</template>

<script>
import NavSearchBar from "./components/NavSearchBar.vue"

export default {
  components: { NavSearchBar },
}
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Chakra+Petch:wght@500&display=swap');

  ::-webkit-scrollbar-track {
    background-color: #232328;
  }

  ::-webkit-scrollbar-thumb {
    background-color: #32323A;
    border: 1px solid #232328;
  }

  ::-webkit-scrollbar-button {
    display: none;
  }
  
  ::-webkit-scrollbar {
    width: 14px;
    height: 14px;
  }



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

    border-bottom: 3px solid #825AB7; 

    background-color: #232328;

    /* position: fixed;
    top: 0;
    width: 100%; */
  }

  #t-logo-search-bar {
    display: flex;
  }

  #tlogo img {
    width: 250px;
  }

  #tlinks {
    display: flex;
    justify-content: space-between;
  }

  #tlinks #alogin {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;

    position: relative;
    right: 10px;
  }

  #tlinks #alogin:hover {
    background-color: #614388;
  }

  #tlinks #aregister {
    background-color: #FC7900;
    border: none;

    position: relative;
    right: 5px;

    font-family: 'Chakra Petch', sans-serif;

  }

  #tlinks #aregister:hover {
    background-color: #c45f00;
  }

  #tlinks #alogout {
    background-color: #FC7900;
    border: none;

    position: relative;
    right: 5px;

    font-family: 'Chakra Petch', sans-serif;
  }

  #tlinks #alogout:hover {
    background-color: #c45f00;
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

  #t-search-bar-form {
    display: flex;
    
    position: relative;
    top: 2px;
    left: 10px;
  }

  #t-search-bar-btn {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;
  }

</style>
