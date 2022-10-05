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
        <ul id="player-list-list" class="players-list">
          <li class="players-list-header">{{playersInTournament}} Players:</li>
          <li class="players-list-item" v-for="player in players" v-bind:key="player.id"><p>{{ player.username }}</p><font-awesome-icon icon="fa-user" /></li>
        </ul>
        
        
    <div id="button">
      <b-button id="request" v-b-modal="'invite-player'" v-if="this.$store.state.user.username == tournament.organizerName && isFull">Invite Player</b-button>
      <b-button id ="request" v-else-if="isFull" v-on:click="requestInvite()"> Request to Join </b-button>
      <b-modal id="invite-player">
        <invite-form v-bind:tournament="tournament" />
      </b-modal>
      <b-button id="request" v-b-modal="'player-requests'" v-if="this.$store.state.user.username == tournament.organizerName" v-bind:to="{ name: 'user' }">View Requests</b-button>
      <b-button id="t-edit-page" v-if="$store.state.user.id == tournament.organizerId" v-bind:to="{name: 'tournament-page-edit', params: {id: tournament.tournamentId}}">Edit Tournament</b-button>
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
  computed: {
    playersInTournament() {
      return this.players.length + "/" + this.tournament.numOfParticipants;
    },
    isFull(){
          return this.players.length < this.tournament.numOfParticipants
      }

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
                this.loadPlayer(this.id)
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
@media screen and (max-width: 1099px) {
  #player-list > ul{
    position: relative;
    padding: 10px;
    box-sizing: border-box;
      columns: 3;
      -webkit-columns: 3;
      -moz-columns: 3;
  }
  #player-list {
    display: flex;
    border: 3px solid #825AB7;
    border-radius: 20px;
    margin-left: 7.5%;
    flex-direction: column;
    background-color: #232328;
}
}
@media screen and (min-width: 1100px) {
  #player-list > ul{
    position: relative;
    padding: 10px;
    box-sizing: border-box;
      columns: 3;
      -webkit-columns: 3;
      -moz-columns: 3;
  }
  #player-list {
    display: flex;
    border: 3px solid #825AB7;
    border-radius: 20px;
    margin-left: 12.5%;
    flex-direction: column;
    align-content: flex-start;
    max-width: 75%;
    background-color: #232328;
  }
}
#request {
  margin-left: 10px;
  background-color: #FC7900;
  border: none;
  font-family: 'Chakra Petch', sans-serif;
}

#request:hover {
  background-color: #c45f00;
}
#player-list > ul > li{
  display: flex;
  padding: 10px 20px;
  color: #fff;
  margin: 5px 0;
  transition: .5s;
  background-color: #614388;

  align-items: center;
  border-radius:0 10px 0 10px;
}
#player-list > ul > li >:nth-child(1) {
  width: 200px;
  margin-bottom: -2px;
  
}
.players-list-header{
    font-family: 'Chakra Petch', sans-serif;
    font-size: xx-large;
    justify-content: start;
    align-content: flex-start;
    margin-left: -25px;
    text-align: center;
    background-color: #FC7900 !important;
}
#players-and-img{
    display: flex;
    width: 1000px;
}
#players-and-img > img{
    margin-left: 12.5%;
    margin-right: 12.5%;
    max-width: 75%;
    object-fit: scale-down;
}
#player-list > #button{
    font-weight: 100;
    font-size: x-large;
    align-self: center;
    justify-content: flex-end;
    margin-bottom: 10px; 
    margin-left: 10px; 
}
.players-list-item {
  list-style: none;
  font-size: large;
  font-family: 'Chakra Petch', sans-serif;
}

#t-edit-page {
  font-family: 'Chakra Petch', sans-serif;
  background-color: #FC7900;
  border: none;

  /* position: relative;
  top: 5px; */
}
</style>