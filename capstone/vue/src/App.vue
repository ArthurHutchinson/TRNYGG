<template>
  <div id="tapp">

    <nav-bar/>

    <div id="tmain">
      <router-view />
    </div>

    <footer-comp/>

  </div>
</template>

<script>
import FooterComp from './components/AppFooter.vue'
import NavBar from './components/NavBar.vue'
import TournamentService from './services/TournamentService.js'
export default {
  components: {
    NavBar,
    FooterComp,
  },
  data(){
    return {
      tournaments: [],
    }
  },

  created(){
    TournamentService.getTournaments().then(response => {
      this.$store.commit('SET_TOURNAMENTS', response.data)
    })
  },
}
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Chakra+Petch:wght@500&display=swap');

/* Scroll Bar Styling */
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

/* Main HTML */
  html {
  
    background-color: #32323A;
    color: #fff;
  }

/* Entire of this View */
  #tapp {
    background-color: #32323A;
    color: #ffffff;
  }

  #tmain {
    /* This might break things 1/2 */
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    /* This might break things 2/2 */
  }

</style>
