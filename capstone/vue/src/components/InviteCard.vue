<template>
  <div>
      <h3> {{ tournament2.tournamentName }} </h3>
      <h5> Host: {{ tournament2.organizerName }} </h5>
      <p>Status : {{invite.status}} </p>
      <b-button v-if="invite.status == 'pending' && isActive" v-on:click="acceptInvite()"> Accept </b-button>
      <b-button v-if="invite.status == 'pending' && isActive" v-on:click="declineInvite()"> Reject </b-button>
  </div>
</template>

<script>

import InviteService from '../services/InviteService.js'

export default {
    name: 'invite-card',
    props: {
        invite: Object,
    },
    data(){
        return {
            tournament: [],
            tournament2: {},
            inviteDTO: {
                inviteId: this.invite.inviteId,
                status: ""
            },
            isActive: true,
        }
    },
    methods: {
        acceptInvite(){
            this.inviteDTO.status = "approved"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive = !this.isActive
                }
            })
            // this.$router.go()
        },
        declineInvite(){
            this.inviteDTO.status = "rejected"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive == !this.isActive
                }
            })
            // this.$router.go()
        }
    },
    // computed: {
    //     getTournament(){
    //         return this.$store.state.tournaments.filter((tournament) => {
    //             return tournament.tournamentId == this.invite.tournamentId
    //         })
    //     }
    // },
    created(){
        this.tournament = this.$store.state.tournaments.filter((tournament) => {
                return tournament.tournamentId == this.invite.tournamentId
    })
        this.tournament2 = this.tournament[0]
    }

}
</script>

<style>

</style>