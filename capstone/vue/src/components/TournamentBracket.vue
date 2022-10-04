<template>
<div id="parent-div">
<div id="container">
<div v-for="round in bracket.rounds" v-bind:key="round.id" id="tournament-bracket">
  <div id="tournament-bracket-round">
    <div v-for="match in round.matches" v-bind:key="match.matchId" id="bracket-div">
      <table id="match">
        <tr>
          <td>Player One:</td>
          <td>{{ match.homePlayer }}</td>
          <td rowspan="2">
            <label for="winner">Winner:</label>
            <p v-if="match.winner != null">{{match.winner}}</p>
            <select v-else for="winner" id="winner">
              <option value="home">{{ match.homePlayer }}</option>
              <option value="away">{{ match.awayPlayer }}</option>
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
</div>
</div>
    <button v-on:click="startTournament()" id="start-round" v-if="this.$store.state.user.username == tournament.organizerName && this.bracket.rounds.length == 0 && !isOver">Start Tournament</button>
    <button v-on:click="addPlayerToWinners()" id="start-round" v-else-if="this.$store.state.user.username == tournament.organizerName && this.bracket.rounds.length != 0 && !isOver">Start Next Round</button>
</div>
</template>

<script>
import TournamentService from "../services/TournamentService";
import UserService from "../services/UserService";
export default {
  name: "tournament-bracket",
  data() {
    return {
      tournament: {},
      players: [],
      bracket: {},
      isOver: false
    };
  },
  computed: {
    playerNames() {
      let names = [];
      this.players.forEach((player) => {
        names.push(player.username)
      })
      return names;
    }
  },
  methods: {
    addPlayerToWinners() {
        const winnersList = document.querySelectorAll('#winner')
        console.log(winnersList)
        let winners = [];
          winnersList.forEach((winner) => {
            if (winner.value == "home") {
              winners.push(winner[0].innerText)
            } else {
              winners.push(winner[1].innerText)
            }
        });
        console.log(winners)
        if (winners.length != 1) {
          this.startNextRound(winners)
        } else {
          console.log(winners[0].length)
          this.setWinner(winners[0])
          alert(winners[0] + " Wins The Tournament!!" )
          this.isOver = true
        }
        return winners;
      },
    startNextRound(winners) {
        // let winners = this.addPlayerToWinners()
        TournamentService.startNewRound(this.id, winners).then((response) => {
        this.bracket = response.data
        })
      },
    loadBracketForTournamentId() {
      TournamentService.getBracketByTournamentId(this.id).then((response) => {
        this.bracket = response.data;
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
    startTournament() {

        TournamentService.startNewRound(this.id, this.playerNames).then((response) => {
        this.bracket = response.data
      });
    },
    loadPlayers() {
        TournamentService.getPlayersByTournamentId(this.id).then((response) => {
            this.players = response.data;
            this.loadBracketForTournamentId(this.id);
        })
    },
    setWinner(username) {
      TournamentService.setWinner(this.id, username).then(
        this.loadPlayers(this.id)
      );
    }
  },
  created() {
    this.id = this.$route.params.id;
    this.loadTournamentDetails(this.id);
    this.loadPlayers(this.id)
  },
};
</script>

<style>
#parent-div{
  display: flex;
  flex-direction: column;
  font-family: 'Chakra Petch', sans-serif;
}
#container {
  display: flex;
  width: 100vw;
  /* height: 100vh ; */
}
#tournament-bracket{
  display: flex;
}
#match {

        color: #fff;
        width: 500px;
        height: 80px;
        margin: 50px;
}
#match > tr > td {
  text-align: center;
  width: 100px;
  height: 40px;
  max-height: 40px;
}
#match > tr > :nth-child(3) {
  text-align: center;
  font-size: small;
  border: none;
  padding-top: 25px;
  padding-bottom: 10px;
  background-color: #FC7900;
  width: 1fr;
}
#match > tr > :nth-child(3) > p {
  font-weight: 100;
  font-size: 20px;
  padding-left: 5px;
  padding-right: 5px;
  text-align: center;
  
}
#match > tr > :nth-child(3) > select {
  font-weight: 100;
  margin-bottom: 10px;
  font-size: 20px;
  margin-left: 5px;
  margin-right: 5px;
  width: 85%;
  background-color: #df6d03;
  color: white;
  font-family: 'Chakra Petch', sans-serif;
  
}
#match > tr > :nth-child(1){
  font-size: 12px;
  background-color: #614388;
  width: 15%;
  
}
#match > tr > :nth-child(2){
  font-size: 25px;
  padding-left: 5px;
  padding-right: 5px;
  text-align: center;
  font-weight: 100;
  width: 1fr;
  background-color: #3c3c46;
  
}
#tournament-bracket-round {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
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
  color: white;
}
#start-round:hover{
  background-color: #614388;
}

</style>