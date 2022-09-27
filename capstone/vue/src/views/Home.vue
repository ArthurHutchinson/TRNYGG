<template>
  <div class="home">
    <h1>Home</h1>
    <tournament-list/>
    <p>You must be NOT authenticated to see this</p>
    <home-description/>
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
