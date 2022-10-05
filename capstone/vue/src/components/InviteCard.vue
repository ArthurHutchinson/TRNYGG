<template>
<div id="invite-container">
    <div id="invite-card-and-img">
        <div class="logo-div">
       <b-img class="invite-tournament-logo" v-if="tournament2.imgUrl" v-bind:src="tournament2.imgUrl"/>
       <b-img class="invite-tournament-logo" v-else src="http://localhost:8080/img/trnygg.d399dc61.png"/>
        </div>
        <div id="invite-card">
            <h3 v-if="isRequest"> A player wants to join: {{ tournament2.tournamentName }} </h3>
            <h3 v-else>Hey! You've been invite to: {{ tournament2.tournamentName }} </h3>
            <h5 v-if="!isHost"> Host: {{ tournament2.organizerName }} </h5>
            <h5 v-else> Player: {{ user.username }}  </h5>
            <p>Status : {{invite.status}} </p>
            <b-button id="accept" v-if="invite.status == 'pending' && isActive && isFull" v-on:click="acceptInvite(),reloadPage()"> Accept </b-button>
            <b-button id="reject" v-if="invite.status == 'pending' && isActive && isFull" v-on:click="declineInvite(),reloadPage()"> Reject </b-button>
            <p v-if="!isFull">Tournament is full</p>
        </div>
    </div>
</div>
</template>

<script>

import InviteService from '../services/InviteService.js'
import TournamentService from '../services/TournamentService.js'
import UserService from '../services/UserService.js'

export default {
    name: 'invite-card',
    props: {
        invite: Object,
    },
    data(){
        return {
            tournament: {},
            tournament2: {},
            inviteDTO: {
                inviteId: this.invite.inviteId,
                status: ""
            },
            isActive: true,
            id: "",
            user: {},
            usersInTourny: [],
        }
    },
    methods: {
        acceptInvite(){
            this.inviteDTO.status = "approved"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive = !this.isActive
                    this.loadPlayer(this.id)
                }
            })
            // this.$router.go()
        },
        declineInvite(){
            this.inviteDTO.status = "rejected"
            InviteService.updateInvite(this.invite.inviteId, this.inviteDTO).then(response => {
                if(response.status == 200){
                    this.isActive == !this.isActive
                    this.loadPlayer(this.id)
                }
            })
            // this.$router.go()
        },
        reloadPage() {
            window.location.reload();
        },
    },
    computed: {
    //     getTournament(){
    //         return this.$store.state.tournaments.filter((tournament) => {
    //             return tournament.tournamentId == this.invite.tournamentId
    //         })
    //     }

        isHost(){
            return this.$store.state.user.username == this.tournament2.organizerName;
        },
        isRequest(){
            return this.invite.type == 'request'
        },
        isFull(){
            return this.usersInTourny.length < this.tournament2.numOfParticipants
        }
     },
    async created(){
        await TournamentService.getPlayersByTournamentId(this.invite.tournamentId).then(response => {
            this.usersInTourny = response.data
        })
        this.id = this.$route.params.id
        this.user = UserService.getUserDTOById(this.invite.playerId)
        this.tournament = this.$store.state.tournaments.filter((tournament) => {
                return tournament.tournamentId == this.invite.tournamentId
    })
        this.tournament2 = this.tournament[0]
    }

}
</script>

<style>

#invite-card-and-img {
    display: flex;
    border:3px solid #4c4c58;
    border-radius: 10px;
    margin: 10px;
    padding: 10px;
    height: 30vh;
    max-width: 66%;
    margin-left: 16.5%;
    /* justify-content: space-around; */
    background-color: #232328;
}
#invite-card-and-img:hover {
    border: 3px solid #825AB7;
    box-shadow: 0 0 5px 0.30rem #825AB73a;


}
#invite-card {
    display: block;
    text-align: center;
    font-family: 'Chakra Petch', sans-serif;
    height: .7fr;
    margin: auto;

}

.invite-tournament-logo {
    align-self: center;
    object-fit: cover;
    object-position: 50% 50%;
    max-width: 20vw;
    max-height: 30vh;
    border-radius: 5px;

}
.logo-div {
    display: flex;
    height: 25vh;
    width: 20.3vw;
    border: 3px solid #32323A;
    border-radius: 5px;
    object-fit: cover;
    object-position: 50% 50%;
    align-self: center;
}
#reject{
    margin: 10px;
    width: 150px;
    height: 50px;
    background-color: #FC7900;
    border: none;
}
#accept{
    margin: 10px;
    width: 150px;
    height: 50px;
    background-color: #825AB7;
    border: none;
}
#accept:hover{
    background-color: #614388;
}
#reject:hover{
    background-color: #c45f00;
}

</style>