<template>
  <div id="home" class="home">

    <home-banner/>
    
    <tournament-list/>

  </div>
</template>

<script>
import HomeBanner from '../components/HomeBanner.vue';
import TournamentList from '../components/TournamentList.vue';
export default {
  components: { 
    HomeBanner,
    TournamentList
   },
  name: "home"
};
</script>

<style>

</style>