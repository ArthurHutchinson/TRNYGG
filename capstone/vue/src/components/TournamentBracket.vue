<template>
  <div id="tournament-bracket">
    <div v-for="match in matches" v-bind:key="match.matchId" id="bracket-div">
      <table>
        <tr>
          <td>Player One:</td>
          <td>{{ match.homePlayer }}</td>
          <td>
            <label for="winner">winner</label>
            <select for="winner" id="winner">
              <option>{{ match.homePlayer }}</option>
              <option>{{ match.awayPlayer }}</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Player Two:</td>
          <td>{{ match.awayPlayer }}</td>
        </tr>
      </table>
    </div>

    <button>Start Next Round</button>
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
  },
  created() {
    this.id = this.$route.params.id;
    this.loadTournamentDetails(this.id);

    this.loadMatchesForTournamentId(this.id);
  },
};
</script>

<style>
</style>