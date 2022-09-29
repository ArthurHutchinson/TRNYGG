<template>
  <div class="tournament-list">
      <tournament-card v-bind:tournament="tournament" v-for="tournament in tournaments" v-bind:key="tournament.id" class ="tournament" />
  </div>
</template>

<script>
import TournamentService from '../services/TournamentService.js'
import TournamentCard from '../components/TournamentCard.vue'
export default {
    name: 'tournament-list',
    components: {
        TournamentCard
    },
    data() {
        return {
            tournaments: []
        }
    },
    methods: {
        loadTournaments() {
            TournamentService.getTournaments().then( (response) => {
                this.tournaments = response.data;
                // this.$store.commit("SET_TOURNAMENTS", this.tournaments);
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