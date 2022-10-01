<template>
  <div>
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
    created(){
        this.loadInvites()
    }

}
</script>

<style>

</style>