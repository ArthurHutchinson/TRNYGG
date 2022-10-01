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
        <b-input type="text" placeholder="Add a Link Here" v-model="tournament.imgUrl" />

        <div class="t-center-item">
            <b-button id="t-btn-crt-trn" type="submit" v-on:click="saveTournament()">Create Tournament</b-button>
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
            tournament: {
                id: 0,
                organizerId: this.$store.state.user.id,
                organizerName: this.$store.state.user.username,
                tournamentName: "",
                numOfParticipants: 0,
                fromDate: "",
                toDate: "",
                tournamentType: "Single",
                imgUrl: "",
                game: ""
            },
            isPageStatusBad: false
    }
    },
    methods: {
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
    .t-center-item {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .t-px-between-on-crt {
        position: relative;
        left: 5px;
    }

    #t-create-t-page {
        display: flex;
        flex-direction: column;
    }

    #t-crt-trn-h {
        font-family: 'Chakra Petch', sans-serif;
        color: #a875eb;
        text-shadow: 2px 2px 2px black;
        
    }

    #t-create-t-page {
        display: flex;
        justify-content: center;
        align-items: center;

        position: relative;
        top: 5px;
    }

    #t-btn-crt-trn {

        position: relative;
        top: 5px;

        background-color: #FC7900;
        border: none;
    }

    #t-btn-crt-trn:hover {
        background-color: #c45f00;
    }
</style>