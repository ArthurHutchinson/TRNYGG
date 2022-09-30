<template>
    <div>
        
        <tournament-card v-bind:tournament="tournament" v-for="tournament in tournaments" v-bind:key="tournament.id" class ="tournament" />

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
            let unfilteredTournaments = [];

            TournamentService.getTournaments().then( (response) => {
                unfilteredTournaments = response.data;
            });

            this.tournaments += unfilteredTournaments.filter( (tournament) => {
                tournament.tournamentName.toLowerCase().includes(this.searchTerm.toLowerCase());
            });

            this.tournaments += unfilteredTournaments.filter( (tournament) => {
                tournament.organizerName.toLowerCase().includes(this.searchTerm.toLowerCase());
            });

            this.tournaments += unfilteredTournaments.filter( (tournament) => {
                tournament.game.toLowerCase().includes(this.searchTerm.toLowerCase());
            });

        },
    },

    created() {
        this.loadTournaments();
    }
}

</script>

<style>

</style>