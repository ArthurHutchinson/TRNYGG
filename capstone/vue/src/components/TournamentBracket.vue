<template>
<div id="tournament-bracket">
  <div id="tournament-bracket-round">
    <div v-for="match in matches" v-bind:key="match.matchId" id="bracket-div">
      <table id="match">
        <tr>
          <td>Player One:</td>
          <td>{{ match.homePlayer }}</td>
          <td rowspan="2">
            <label for="winner">Winner:</label>
            <select for="winner" id="winner">
              <option value="match.homePlayer">{{ match.homePlayer }}</option>
              <option value="match.awayPlayer">{{ match.awayPlayer }}</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Player Two:</td>
          <td>{{ match.awayPlayer }}</td>
        </tr>
      </table>
    </div>
  </div>
    <button id="start-round" v-if="this.$store.state.user.username == tournament.organizerName">Start Round</button>
</div>
</template>

<script>
import TournamentService from "../services/TournamentService";
import UserService from "../services/UserService";
export default {
  name: "tournament-bracket",
  data() {
    return {
      matches: [],
      tournament: {},
      users: [],
      winners: []
    };
  },
  methods: {
    loadMatchesForTournamentId(id) {
      TournamentService.getMatchesByTournamentId(id).then((response) => {
        this.matches = response.data;
      });
    },
    loadTournamentDetails(id) {
      TournamentService.getTournamentDetails(id).then((response) => {
        this.tournament = response.data;
      });
    },
    getUsersByMatchId(matchId) {
      UserService.getUsersByMatchId(matchId).then((response) => {
        this.users.add = response.data;
      });
    },
    getUserById(userId) {
      UserService.getUserById(userId).then((response) => {
        this.user = response.data;
      });
    },
    startNextRound() {
      TournamentService.startNextRound(this.winners).then((response) => {
        response.data
      })
    },
  
  },
  created() {
    this.id = this.$route.params.id;
    this.loadTournamentDetails(this.id);
    this.loadMatchesForTournamentId(this.id);
  },
};
</script>

<style>

#match {

        color: #fff;
        background-color: #75757e;
        border-radius: 10px;
        width: 300px;
        height: 80px;
        margin: 50px;
        border: 1px solid black;
}
#match > tr > td {
  text-align: center;
  border: 1px solid black;
  width: 100px;
  height: 40px;
  max-height: 40px;
}
#match > tr > :nth-child(3) {
  text-align: center;
  font-size: small;
  border: none;
  padding-bottom: 10px ;
  
}
#match > tr > :nth-child(1){
  font-size: small;
}
#match > tr > :nth-child(2){
  font-size: x-large;
  font-weight: 600;
}
#tournament-bracket-round {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
#start-round{
  width: 50%;
  height: 50px;
  margin-top: 20px;
  margin-left: 25%;
  margin-bottom: 50px;
  background-color: #825AB7;
  font-size: x-large;
  text-align: center;
  border: none;
  border-radius: 10px;
  align-items: end;

}

</style>