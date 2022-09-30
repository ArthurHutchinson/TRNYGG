<template>
  <div>
      <form class = "tournament-form" v-on:submit.prevent>
          <div class ="field">
            <label for="tournament-name">Tournament Name</label>
            <input type="text" v-model="tournament.tournamentName"/>
            <label for="game">Game</label>
            <input type="text" v-model="tournament.game" />
            <label for="start-date">Start Date</label>
            <input type="date" v-model="tournament.fromDate" />
            <label for="end-date">End Date</label>
            <input type="date" v-model="tournament.toDate" />
            <label for="number-of-participants">Number of Players/teams</label>
            <input type="number" v-model="tournament.numOfParticipants" />
            <label for="image-link">Image Link</label>
            <input type="text" v-model="tournament.imgUrl" />
          </div>
          <div class="actions">
              <button type="submit" v-on:click="saveTournament()">Create Tournament</button>
          </div>
      </form>
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

</style>