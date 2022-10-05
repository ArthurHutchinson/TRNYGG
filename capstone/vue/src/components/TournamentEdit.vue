<template>
  <div id="t-create-t-page">

      <h1 id="t-crt-trn-h" class="t-center-item">Create Tournament</h1>
  
      <b-form class = "tournament-form" v-on:submit.prevent>

        <label for="tournament-name">Tournament Name: </label>
        <b-input type="text" placeholder="Enter Tournament Name" v-model="tournament.tournamentName"/>
            
        <label for="game">Game: </label>
        <b-input type="text" placeholder="Enter Game Name" v-model="tournament.game" />
            
        <label for="start-date">Start Date: </label>
        <b-input type="date" v-model="tournament.fromDate" />

        <label for="end-date">End Date: </label>
        <b-input type="date" v-model="tournament.toDate" />


        <label for="number-of-participants">Number of Players/Teams: </label>
        <b-input type="number" v-model="tournament.numOfParticipants" />

        <label for="image-link">Image Link: </label>
        <b-input type="text" placeholder="Add an image Link Here" v-model="tournament.imgUrl" />

        <label for="tournament-description">Tournament Description: </label>
        <b-form-textarea id="tournament-description-field" placeholder="Enter details about your tournament such as special rules, prize info, or info about how where to spectate the tournament" rows="3" max-rows="6" v-model="tournament.description" />

        <div class="t-center-item">
            <b-button id="t-save-trn-btn" type="submit" v-on:click="saveTournament()">Create Tournament</b-button>
        </div>

    </b-form>
    <p v-if="isPageStatusBad">Something is wrong, please refresh page</p> 
  </div>
</template>

<script>
import TournamentService from "../services/TournamentService.js"
export default {
    name: "create-tournament",
    data () {
        return {
            tournament: {},
            isPageStatusBad: false
    }
    },
    methods: {
        getTournament(id) {
            TournamentService.getTournament(id)
        },
        saveTournament() {
            TournamentService.createTournament(this.tournament).then((response) =>{
                if (response.status === 201) {
                    this.$router.push({name: 'home'});
                } else {this.isPageStatusBad = true}
            });
        }
    }

}
</script>

<style>
</style>