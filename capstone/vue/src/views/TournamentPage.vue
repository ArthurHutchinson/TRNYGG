<template>
  <div>
      <tournament-details />
      <tournament-bracket />
 </div>
</template>

<script>
import TournamentBracket from '../components/TournamentBracket.vue'
import TournamentDetails from '../components/TournamentDetails.vue'
export default {
    components: {
        TournamentDetails,
        TournamentBracket
    },
    
    name: "tournament-page",
    
}
</script>

<style>

</style>