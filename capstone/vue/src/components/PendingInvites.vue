<template>
  <div id="t-pend-invites-div">
      <h1 id="t-pend-title" style="text-align: center">Pending Invites:</h1>
      <invite-card v-bind:invite="invite" v-for="invite in invites" v-bind:key="invite.id" />
  </div>
</template>

<script>

import InviteService from '../services/InviteService.js'
import InviteCard from '../components/InviteCard.vue'


export default {
    name: 'pending-invites',
    components: {
        InviteCard
    },
    data(){
        return {
            invites: [],
        }
    },
    methods: {
        loadInvites(){
            InviteService.pendingInvites().then(response => {
                this.invites = response.data
            })
        }
    },
    computed: {
        filteredInvites(){
            return this.invites.filter((invite) => {
                return invite.type.includes('invite')
            })
        }
    },
    created(){
        this.loadInvites()
    }

}
</script>

<style>
#t-pend-title {
  font-family: 'Chakra Petch', sans-serif;  

}

#t-pend-invites-div {
    padding-top: 10px
}
</style>