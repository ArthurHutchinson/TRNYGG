<template>
  <div>
      <h3 v-if="isRequest"> A player wants to join: {{ tournament2.tournamentName }} </h3>
      <h3 v-else>Hey! You've been invite to: {{ tournament2.tournamentName }} </h3>
      <h5 v-if="!isHost"> Host: {{ tournament2.organizerName }} </h5>
      <h5 v-else> Player: {{ user.username }}  </h5>
      <p>Status : {{invite.status}} </p>
      <b-button v-if="invite.status == 'pending' && isActive && isFull" v-on:click="acceptInvite(),reloadPage()"> Accept </b-button>
      <b-button v-if="invite.status == 'pending' && isActive && isFull" v-on:click="declineInvite(),reloadPage()"> Reject </b-button>
      <p v-if="!isFull">Tournament is full</p>
  </div>
</template>

<script>

import InviteService from '../services/InviteService.js'
import TournamentService from '../services/TournamentService.js'
import UserService from '../services/UserService.js'

export default {
    name: 'invite-card',
    props: {
        invite: Object,
    },
    data(){
        return {
            tournament: {},
            tournament2: {},
            inviteDTO: {
                inviteId: this.invite.inviteId,
                status: ""
            },
            isActive: true,
            id: "",
            user: {},
            usersInTourny: [],
        }
    },
    methods: {
        acceptInvite(){
            this.inviteDTO.status = "approved"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive = !this.isActive
                    this.loadPlayer(this.id)
                }
            })
            // this.$router.go()
        },
        declineInvite(){
            this.inviteDTO.status = "rejected"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive == !this.isActive
                    this.loadPlayer(this.id)
                }
            })
            // this.$router.go()
        },
        reloadPage() {
            window.location.reload();
        },
    },
    computed: {
    //     getTournament(){
    //         return this.$store.state.tournaments.filter((tournament) => {
    //             return tournament.tournamentId == this.invite.tournamentId
    //         })
    //     }

        isHost(){
            return this.$store.state.user.username == this.tournament2.organizerName;
        },
        isRequest(){
            return this.invite.type == 'request'
        },
        isFull(){
            return this.usersInTourny.length < this.tournament2.numOfParticipants
        }
     },
    async created(){
        await TournamentService.getPlayersByTournamentId(this.invite.tournamentId).then(response => {
            this.usersInTourny = response.data
        })
        this.id = this.$route.params.id
        this.user = UserService.getUserDTOById(this.invite.playerId)
        this.tournament = this.$store.state.tournaments.filter((tournament) => {
                return tournament.tournamentId == this.invite.tournamentId
    })
        this.tournament2 = this.tournament[0]
    }

}
</script>

<style>

</style>