<template>
    <div>
        <div class="tournament-detail-box">
            <h1 class = "tournament-name">{{tournament[0].tournamentName}}</h1>
            <img class = "tournament-logo" v-if='tournament[0].imgUrl' v-bind:src="tournament.imgUrl"/>
            <h2 class = "tournament-game">{{tournament[0].game}}</h2>
            <h4 class = "host-name">{{tournament[0].organizerName}}</h4>
            <p class = "time details">{{tournament[0].fromDate}} - {{tournament[0].toDate}}</p>
            <ul class = "players-list"><h3 class = "players-list-header">Players</h3>
              <li class="players-list-item" v-bind:player="player" v-for="player in tournament[0].players" v-bind:key="player.id">{{tournament[0].player.name}}</li>
            <!-- partial list hiding to be implemented later -->
            <!-- possibly include a router-link for the player id to player page -->
            </ul>
        </div>
        <div class = "bracket-box">
            This is placeholder text
            <!-- we will put what we need to assemble the bracket here, for now there's placeholder text to be sure that it's at least, like, loading. -->

        </div>
    </div>
</template>

<script>
export default {
    
    name: 'tournament-details',
    data() {
        return {
        };
    },

    computed: {
        tournament() {
            return this.$store.state.tournaments.filter((tournament) => {
                return tournament.tournamentId == this.$route.params.id
            });
        }
    }
    

}

</script>

<style>
    
</style>