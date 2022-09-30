<template>
    <div>
        <div class="tournament-detail-box">
            <!-- <router-link v-bind:to="{name: 'invite-player'}" v-bind:tournament="tournament">
                <button>Invite Player</button>
            </router-link> -->
            <h1 class = "tournament-name">{{tournament.tournamentName}}</h1>
            <img class = "tournament-logo" v-if='tournament.imgUrl' v-bind:src="tournament.imgUrl"/>
            <h2 class = "tournament-game">{{tournament.game}}</h2>
            <h4 class = "host-name">{{tournament.organizerName}}</h4>
            <p class = "time details">{{tournament.fromDate}} - {{tournament.toDate}}</p>
            <ul class = "players-list"><h3 class = "players-list-header">Players</h3>
              <li class="players-list-item" v-bind:player="player" v-for="player in tournament.players" v-bind:key="player.id">{{tournament.player.name}}</li>
            <!-- partial list hiding to be implemented later -->
            <!-- possibly include a router-link for the player id to player page -->
            </ul>
        </div>
        <div>
            
            <b-button v-b-modal="'invite-player'"> Invite Player </b-button>
            <b-modal id="invite-player"> <invite-form v-bind:tournament="tournament" /> </b-modal>
        </div>
        <div class = "bracket-box">
            This is placeholder text
            <!-- we will put what we need to assemble the bracket here, for now there's placeholder text to be sure that it's at least, like, loading. -->

        </div>
    </div>
</template>

<script>
    import TournamentService from '../services/TournamentService.js'
    import InviteForm from '../components/InviteForm.vue'

export default {

    name: 'tournament-details',
    components: {
        InviteForm,
    },
    
    data() {
        return {
            id: 0,
            tournament: {},
            
        };
    },

methods: {
    loadTournamentDetails(id) {
        TournamentService.getTournamentDetails(id).then( (response) => {
            this.tournament = response.data;
        })
    }
},
created() {
    this.id = this.$route.params.id;
    this.loadTournamentDetails(this.id);
    
}

    // computed: {
    //     tournament() {
    //         return this.$store.state.tournaments.filter((tournament) => {
    //             return tournament.tournamentId == this.$route.params.id
    //         });
    //     }
    // }
    

}

</script>

<style>
    
</style>