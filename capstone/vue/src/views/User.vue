<template>
  <div>
      <pending-invites />
      <!-- <h3>Tournaments Participating</h3>
      <tournament-card
        class="t-card-in-list"
        v-for="tournament in playerList"
        v-bind:tournament="tournament"
        v-bind:key="tournament.id" />
      <h3>Tournaments Hosting</h3>
      <tournament-card
        class="t-card-in-list"
        v-bind:tournament="tournament"
        v-bind:key="tournament.id"
        v-for="tournament in organizerList" /> -->


  </div>
</template>

<script>
import PendingInvites from '../components/PendingInvites.vue'
// import TournamentService from '../services/TournamentService'
// import TournamentCard from '../components/TournamentCard.vue'
export default {
  name: "user",
  data() {
    return {
    ids: [],
    }
  },
  components: {
    PendingInvites,


  },
  computed: {
    // playerList(){
    //   return this.$store.state.tournaments.filter((tournament) => {
    //     return tournament.tournamentId.includes(this.ids)
    //   })
    // },
    // organizerList() {
    //   return this.$store.state.tournaments.filter((tournament) => {
    //     return tournament.organizerId.includes(this.$store.state.user.id)
    //   })
    // }
  },
  // created(){
  //   TournamentService.getTournamentsByUserId(this.$store.state.user.id).then(response => {
  //     this.ids = response.data
  //   })
  //}

}
</script>

<style>

</style>