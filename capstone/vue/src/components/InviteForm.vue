<template>
  <div>
      <b-form v-on:submit.prevent>
          <div id="field">
              <label for="username">Enter Username to Invite:</label>
              <b-form-input type="text" v-model="username"/>
              <p v-if="isPageStatusBad">Sorry! There was an error! Cannot invite that player at this time!</p>
          </div>
          <div id="actions">
              <b-button id="t-inv-form-btn" type="submit" v-on:click="sendInvite()">Submit</b-button>
            
          </div>
      </b-form>
  </div>
</template>

<script>

import UserService from '../services/UserService.js'
import InviteService from '../services/InviteService.js'

export default {
    name: "invite-form",
    props: {
        tournament: Object,
    },
    data(){
        return {
            isPageStatusBad: false,
            invite: {
                tournamentId: "",
                organizerId: "",
                playerId: "",
            },
            userId: "",
            username: "",
            id: ""
        }
    },
    methods: {
        sendInvite(){
            this.invite.tournamentId = this.tournament.tournamentId
            this.invite.organizerId = this.tournament.organizerId
            UserService.getUserId(this.username).then(response => {
                if (response.status === 200){
                    this.invite.playerId = response.data
                    this.newMethod()
                }
            })
            console.log(this.invite.playerId)
            // InviteService.createInvite(this.invite).then(response => {
            // if (response.status === 201){
            //     this.$router.push({name: 'home'})
            //     }else {
            //         this.isPageStatusBad = true;
            //     }
            // })
        },

        newMethod(){
            InviteService.createInvite(this.invite).then(response => {

                if (response.status === 200){
                    // this.$router.push({name: 'home'})
                    // this.loadPlayer(this.id)
                    // this.$router.push({name:'tournament-page', params:{id:this.invite.tournamentId} })
                    this.$bvModal.hide('invite-player')
                }else {
                    this.$bvModal.hide('invite-player')
                }
            })
        }
        
    },
    create(){
        this.invite.tournamentId = this.tournament.tournamentId
        this.invite.organizerId = this.tournament.organizerId
        this.id = this.$route.params.id
    }

}
</script>

<style>
#t-inv-form-btn {
    color: #FFFFFF;
    background-color: #FC7900;
    border: none;

    display: block;
    margin-left: auto;
    margin-right: 0;

    position: relative;
    top: 10px;
}

#t-inv-form-btn:hover {
    background-color: #c45f00;
}
</style>