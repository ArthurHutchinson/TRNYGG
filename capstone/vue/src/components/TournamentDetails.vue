<template>
  <div>
    <div class="tournament-detail-box">
      <h1 class="tournament-name">{{ tournament.tournamentName }}</h1>

      <h2 class="tournament-game">
        Single-Elimination {{ tournament.game }} Tournament
      </h2>
      <span>
        <h4 class="host-name">Hosted By: {{ tournament.organizerName }}</h4>
      </span>
      <span>
        <p class="time-details">
          From: {{ tournament.fromDate }} &nbsp; To: {{ tournament.toDate }}
        </p>
      </span>
    </div>

      <div id="players-and-img">
      <div id="player-list">
        <ul class="players-list">
          <h3 class="players-list-header">Players:</h3>
          <li class="players-list-item" v-for="player in players" v-bind:key="player.id">{{ player.username }}</li>
        </ul>
    <div id="button">
      <b-button v-b-modal="'invite-player'" v-if="this.$store.state.user.username == tournament.organizerName">Invite Player</b-button>
      <b-button v-else v-on:click="requestInvite()"> Request to Join </b-button>
      <b-modal id="invite-player">
        <invite-form v-bind:tournament="tournament" />
      </b-modal>
    </div>
      </div>
        <img class="tournament-logo" v-if="tournament.imgUrl" v-bind:src="tournament.imgUrl"/>
      </div>

  </div>
</template>

<script>
import TournamentService from "../services/TournamentService.js";
import InviteForm from "../components/InviteForm.vue";
import InviteService from "../services/InviteService.js";
import UserService from "../services/UserService.js";
export default {
  name: "tournament-details",
  components: {
    InviteForm,
  },
  data() {
    return {
      id: 0,
      tournament: {},
      invite: {
        tournamentId: "",
        organizerId: "",
        playerId: "",
      },
      players: []
    };
  },
  methods: {
    loadTournamentDetails(id) {
      TournamentService.getTournamentDetails(id).then((response) => {
        this.tournament = response.data;
      });
    },
    requestInvite() {
      this.invite.tournamentId = this.tournament.tournamentId;
      this.invite.organizerId = this.tournament.organizerId;
      UserService.getUserId(this.$store.state.user.username).then(
        (response) => {
          if (response.status === 200) {
            this.invite.playerId = response.data;
            InviteService.createInvite(this.invite).then((response) => {
              if (response.status === 200) {
                this.$router.push({ name: "home" });
              }
            });
          }
        }
      );
    },
    loadPlayers(id) {
        TournamentService.getPlayersByTournamentId(id).then((response) => {
            this.players = response.data;
        })
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
.tournament-detail-box > h1 {
  text-align: center;
  margin: 15px;
  font-weight: 700;
}
.tournament-detail-box > h2 {
  text-align: center;
  font-weight: 300;
  margin-top: -15px;
}
.tournament-detail-box > span {
  display: flex;
  justify-content: center;
  text-align: center;
  font-weight: 100;
  margin-top: -5px;
}
#player-list {
    display: flex;
    border: 3px solid #825AB7;
    border-radius: 20px;
    width: 53%;
    height: 25vh;
    margin-left: 12.5%;

}
#player-list > ul > h3{
    font-weight: 100;
    font-size: x-large;
    justify-content: start;
    align-content: flex-start;
    margin-left: -25px;
}
#players-and-img{
    display: flex;
}
#players-and-img > img{
    margin-left: 50px;
    max-width: 300px;
    margin-right: 12.5%;
}
#player-list > #button{
    font-weight: 100;
    font-size: x-large;
    align-self: flex-end;
    margin-left: 33%;
    margin-bottom: 10px;  
}
</style>