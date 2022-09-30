<template>
    <div>
        
        <tournament-card v-bind:tournament="tournament" v-for="tournament in filteredTournaments" v-bind:key="tournament.id" class ="tournament" />

    </div>
</template>

<script>

import TournamentCard from './TournamentCard.vue'
import TournamentService from '../services/TournamentService.js'

export default {
    components: { TournamentCard },
    props: {
        searchTerm: String,
    },
    data() {
        return {
            tournaments: [],
        }
    },
    methods: {
        loadTournaments() {
            TournamentService.getTournaments().then( (response) => {
                this.tournaments = response.data;
            });
        },
    },

    computed: {
        filteredTournaments() {
            return this.tournaments.filter( (tournament) => {
                return(
                    tournament.tournamentName.includes(this.searchTerm) ||
                    tournament.organizerName.includes(this.searchTerm) ||
                    tournament.game.includes(this.searchTerm)
                ) 

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