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

.pagination-n {
    --bs-link-color: #FFFFFF !important;
    --bs-link-hover-color: #825AB7 !important;

    --bs-pagination-color: var(--bs-link-color) !important;
    --bs-pagination-bg: #232328 !important;
    --bs-pagination-border-color: none !important;
    
    --bs-pagination-hover-color: noner !important;
    --bs-pagination-hover-bg: #402d5a  !important;
    --bs-pagination-hover-border-color: #453061  !important;

    --bs-pagination-focus-color: var(--bs-link-hover-color) !important;
    --bs-pagination-focus-bg: #825AB7  !important;
    --bs-pagination-focus-box-shadow: 0 0 0 0.25rem #825ab73a !important;

    --bs-pagination-active-color: #FFFFFF  !important;
    --bs-pagination-active-bg: #825AB7  !important;
    --bs-pagination-active-border-color: #614388  !important;

    --bs-pagination-disabled-color: #3a3a42  !important;
    --bs-pagination-disabled-bg: #232328  !important;
    --bs-pagination-disabled-border-color: none !important;

    /*
#FFFFFF - white
#32323A - background
#232328 - dark background
#825AB7 - purple
#614388 - hover purple
#FC7900 - orange
#C45F00 - hover orange
*/
}

.pagination {
    --bs-link-color: #FFFFFF !important;
    --bs-link-hover-color: #FC7900 !important;

    --bs-pagination-color: var(--bs-link-color) !important;
    --bs-pagination-bg: #232328 !important;
    --bs-pagination-border-color: none !important;
    
    --bs-pagination-hover-color: noner !important;
    --bs-pagination-hover-bg: #C45F00  !important;
    --bs-pagination-hover-border-color: #803e00  !important;

    --bs-pagination-focus-color: var(--bs-link-hover-color) !important;
    --bs-pagination-focus-bg: #FC7900  !important;
    --bs-pagination-focus-box-shadow: 0 0 0 0.25rem #FC79003a !important;

    --bs-pagination-active-color: #FFFFFF  !important;
    --bs-pagination-active-bg: #FC7900  !important;
    --bs-pagination-active-border-color: #C45F00  !important;

    --bs-pagination-disabled-color: #3a3a42  !important;
    --bs-pagination-disabled-bg: #232328  !important;
    --bs-pagination-disabled-border-color: none !important;

    /*
#FFFFFF - white
#32323A - background
#232328 - dark background
#825AB7 - purple
#614388 - hover purple
#FC7900 - orange
#C45F00 - hover orange
*/
}


</style>

<style scoped>




</style>