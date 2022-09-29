<template>
  <div id="home" class="home">
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
  #home {
    background-color: #32323A;
  }
</style>