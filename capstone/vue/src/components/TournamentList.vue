<template>
  <div class="tournament-list2">

    <div id="t-search-bar">
        <b-form id="t-search-bar-form">
          <b-form-input id="t-search-bar-form-input" size="sm" type="search" placeholder="Search Tournament Name, Game, or Organizer's Name Here" v-model="searchTerm"></b-form-input>
        </b-form>
    </div>
    <!-- to tournament card below, add v-if search term is blank -->
    
    <b-container id="t-list-b-container" class="overflow-auto" >

    <b-pagination
        id="t-pagination-card"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="testpagination"
        align="center"
        class="t-pagination"
    />

    <b-row id="testpagination">
        
      <tournament-card
        class="t-card-in-list"
        v-bind:tournament="tournament"
        v-bind:key="tournament.id"
        v-for="tournament in filteredTournaments.slice((currentPage-1) * perPage,(currentPage-1) * perPage + perPage)"
      />

    </b-row>

    <b-pagination
        id="t-pagination-card"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="testpagination"
        align="center"
        class="t-pagination"
    />

    </b-container>

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
            perPage: 12,
            currentPage: 1,
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
        },
        rows() {
            return this.filteredTournaments.length;
        }
}
}
</script>

<style>
#t-search-bar {
    padding-left: 30vw;
    padding-right: 30vw;
    padding-bottom: 10px;

    position: relative;
    bottom: 10px;
}

#t-search-bar-form-input {
    text-align: center;
}



</style>

<style scoped>
.pagination > li > a {
    color: red;
}

</style>