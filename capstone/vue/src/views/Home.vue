<template>
  <div id="home" class="home">
    <p>You must be NOT authenticated to see this</p>
    <home-description/>
    <tournament-list/>
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
</style>