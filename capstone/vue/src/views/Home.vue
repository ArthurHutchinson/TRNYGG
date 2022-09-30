<template>
  <div id="home" class="home">

    <home-banner/>

    <b-container>
      <b-row>
        <b-col>
          <tournament-list/></b-col>
        <b-col><home-description/></b-col>
      </b-row>
    </b-container>

    <br>

  </div>
</template>

<script>
import HomeBanner from '../components/HomeBanner.vue';
import HomeDescription from '../components/HomeDescription.vue';
import TournamentList from '../components/TournamentList.vue';
export default {
  components: { 
    HomeDescription,
    HomeBanner,
    TournamentList
   },
  name: "home"
};
</script>

<style>

</style>