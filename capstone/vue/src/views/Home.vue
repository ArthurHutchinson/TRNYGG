<template>

  <div id="home" class="home">
    <div id="banner-container">
      <img id="csgoimage" src="../assets/bannercsgo2.png">
      <div id="t-text-center">
        <div id="changeFont">
        Welcome To Your Own Personal Tournament</div><br>
        Something something, this is all just a bunch of paragraphs, this is like not really important to know, but I'm really just typing random things. In fact this is all just random. This is reall just filler text to fill this up.<br><br>
        Speaking of which I wanna say our team is pretty cool. Tyler Knight and Jason are pretty awesome at backend stuff. <br>
        Huge thanks to Trey for figuring out t he front-end coding stuff. You guys are gods.<br><br>
        <b-button id="t-button" v-if="$store.state.token != ''">Create Tournament</b-button>
        </div>
      
    </div>

    <br>

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

  @import url('https://fonts.googleapis.com/css2?family=Chakra+Petch:wght@500&display=swap');

  #home {
    background-color: #32323A;
  }

  #csgoimage {
    height: 50%;
    width: 100%;

    user-drag: none;  
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
    color: white;
  }

  #t-text-center {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-shadow: -2px 2px 2px #000000;
  }

  #changeFont {
    font-family: 'Chakra Petch', sans-serif;
    font-size: 25px;
    text-shadow: -2px 2px 2px #000000;
  }

  #t-button {
    font-family: 'Chakra Petch', sans-serif;
    background-color: #FC7900 !important;
    border: 0px !important;
  }

</style>