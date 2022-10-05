<template>
  <div id="t-edit-t-page">

      <h1 id="t-edit-trn-h" class="t-center-item">Edit Tournament</h1>
  
      <b-form class = "tournament-form" v-on:submit.prevent>

        <label for="tournament-name">Tournament Name: </label>
        <b-input type="text" placeholder="Enter Tournament Name, leave blank to not change" v-model="tournament.tournamentName"/>
            
        <label for="game">Game: </label>
        <b-input type="text" placeholder="Enter Game Name, leave blank to not change" v-model="tournament.game" />
            
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
            <b-button id="t-save-trn-btn" type="submit" v-on:click="saveTournament()">Edit Tournament</b-button>
        </div>

    </b-form>
    <p v-if="isPageStatusBad">Something is wrong, please refresh page</p> 
  </div>
</template>

<script>
import TournamentService from "../services/TournamentService.js"
export default {
    name: "edit-tournament",
    data () {
        return {
            id: 0,
            tournament: {},
            isPageStatusBad: false
    }
    },
    methods: {
        getTournamentDetails(id) {
            TournamentService.getTournamentDetails(id).then((response) => {
                this.tournament=response.data;
            })
        },
        saveTournament() {
            TournamentService.updateTournament(this.id, this.tournament).then((response) =>{
                if (response.status === 200) {
                    this.$router.push({name: 'home'});
                } else {this.isPageStatusBad = true}
            });
        }
    },
    created() {
        this.id = this.$route.params.id;
        this.getTournamentDetails(this.id);
    },

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

    #t-edit-t-page {
        display: flex;
        flex-direction: column;
    }

    #t-edit-trn-h {
        font-family: 'Chakra Petch', sans-serif;
        color: #a875eb;
        text-shadow: 2px 2px 2px black;
        
    }

    #t-edit-t-page {
        display: flex;
        justify-content: center;
        align-items: center;

        position: relative;
        top: 5px;
    }

    #t-save-trn-btn {

        position: relative;
        top: 5px;

        background-color: #FC7900;
        border: none;
    }

    #t-save-trn-btn:hover {
        background-color: #c45f00;
    }
</style>