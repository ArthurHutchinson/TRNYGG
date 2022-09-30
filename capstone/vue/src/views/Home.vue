<template>
  <div id="home" class="home">

    <home-banner/>

    <b-container>
      <b-row>
        <b-col>
          <nav-search-bar/>
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
import NavSearchBar from '../components/NavSearchBar.vue';
import TournamentList from '../components/TournamentList.vue';
export default {
  components: { 
    HomeDescription,
    TournamentList,
    NavSearchBar,
    HomeBanner
   },
  name: "home"
};
</script>

<style>

</style>