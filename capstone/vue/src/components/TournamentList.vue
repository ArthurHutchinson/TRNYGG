<template>
  <div class ="tournament-list">
      <div v-for="tournament in tournaments" v-bind:key="tournament.id" class ="tournament">
          <!-- <router-link v-bind:to="{name: 'placeholder', params: {id: placeholder.placeholder}}"> -->
          {{tournament.name}}
          <!-- </router-link> -->
      </div>
</template>

<script>
import TournamentService from '../services/TournamentService.js'
export default {
    name: 'tournament-list',
    data() {
        return {
            tournaments: []
        }
    },
    methods: {
        loadTournaments() {
            TournamentService.getTournaments().then( (response) => {
                this.tournaments = response.data;
            });
        }
    },
    created() {
        this.loadTournaments();
    }
}
</script>

<style>

</style>