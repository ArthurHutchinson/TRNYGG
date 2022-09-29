<template>
  <div>
      <form v-on:submit.prevent>
          <div id="field">
              <label for="username">Username of player to add:</label>
              <input type="text" v-model="username">
          </div>
          <div id="actions">
              <button type="submit" v-on:click="sendInvite()">Submit</button>
          </div>
      </form>
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
            invite: {
                tournamentId: "",
                organizerId: "",
                playerId: "",
            },
            userId: "",
            username: "",
        }
    },
    methods: {
        sendInvite(){
            this.user = UserService.getUser(this.username)
            this.invite.tournamentId = this.tournament.tournamentId
            this.invite.organizerId = this.tournamentId.organizerId
            this.invite.playerId = this.userId
            InviteService.createInvite(this.invite).then(response => {
            if (response.status === 201){
                this.$router.push({name: 'Home'})
                }
            })
        }
    },

}
</script>

<style>

</style>