<template>

  <div id="home" class="home">
    <div id="banner-container">
      <img id="csgoimage" src="../assets/bannercsgo2.png">
      <div id="t-banner-text">
        
        <div id="t-banner-header">
        Build, Host, and Compete in Custom Tournaments!
        </div>
        
        <br>

        With TRNY.GG, users can create tournaments for any game type. Our bracket generator will organize teams/players into matches and allow tournament hosts to submit results for each round. Join any of our existing tournaments or create your own and invite your friends.
        
        <br>

        <b-button v-bind:to="{ name: 'create-tournament-page' }" id="t-button" v-if="$store.state.token != ''">Create Tournament</b-button>
        
      </div>
      
    </div>

    <b-container>
      <b-row>
        <b-col><tournament-list/></b-col>
        <b-col><home-description/></b-col>
      </b-row>
    </b-container>
    <br>
  </div>
</template>

<script>
import HomeDescription from '../components/HomeDescription.vue';
import TournamentList from '../components/TournamentList.vue';
export default {
  components: { 
    HomeDescription,
    TournamentList
   },
  name: "home"
};
</script>

<style>

  
  #home {
    background-color: #32323A;
  }

  #csgoimage {

    height: 100%;
    width: 100%;

    user-select: none;
    pointer-events: none;
    -moz-user-select: none;
    -webkit-user-drag: none;
    -webkit-user-select: none;
    -ms-user-select: none;

  }

  #banner-container {
    position: relative;
    text-align: center;
    color: rgb(255, 255, 255);
  }

  #t-banner-header {
    font-family: 'Chakra Petch', sans-serif;
    font-size: 1.75vw;
  }

  #t-banner-text {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -80%);
    
    text-shadow: -2px 2px 2px #000000;
    font-size: 1.3vw;
  }

  #t-button {
    font-family: 'Chakra Petch', sans-serif;
    background-color: #FC7900 !important;
    border: 0px !important;
    text-shadow: 0px 0px 0px #000000;
    font-size:1vw;
    padding: 0.7vw 0.8vw;
    
    position: relative;
    top: 5px;
  }

</style>