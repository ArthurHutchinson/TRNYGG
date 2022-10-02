<template>
    <div id="test-main">
        <br>

        <p id="test-description">Use this page to test CSS Styling 'n stuff.</p>

        <p>Component: Tournament Bracket</p>
        <tournament-bracket/>

        <br>

        
    </div>
</template>

<script>
import TournamentBracket from '../components/TournamentBracket.vue'
export default {
  components: { TournamentBracket },

}
</script>

<style>
    #test-description {
        text-align: center;
    }
</style>