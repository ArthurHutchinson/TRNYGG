<template>
  <div class="tournament-list">
      <b-navbar-nav id="t-search-bar">
        <b-nav-form id="t-search-bar-form">
          <b-form-input size="sm" type="search" placeholder="Search" v-model="searchTerm"></b-form-input>
        </b-nav-form>
    </b-navbar-nav>
      <!-- to tournament card below, add v-if search term is blank -->
      <tournament-card v-bind:tournament="tournament" v-for="tournament in filteredTournaments" v-bind:key="tournament.id" class ="tournament" />
  <!-- New tournament card element v-if search term is not blank that displays filtered list-->
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
            tournaments: [],
            searchTerm: "",
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
    },
    computed: {
        filteredTournaments() {
            return this.tournaments.filter((tournament) => {
                return tournament.tournamentName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
                tournament.organizerName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
                tournament.game.toLowerCase().includes(this.searchTerm.toLowerCase())
            })
        
    }
}
}
</script>

<style>

</style>