<template>
<div id="invite-container">

    <div id="t-invite-card-and-img">

        <div class="t-logo-div">
            <b-img class="invite-tournament-logo" v-if="tournament2.imgUrl" v-bind:src="tournament2.imgUrl"/>
            <b-img class="no-icon-due-to-null-empty-invite" v-else src="http://localhost:8080/img/trnygg.d399dc61.png"/>
        </div>

        <div id="t-invite-card">
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
        UserService.getUserDTOById(this.invite.playerId).then(response => {
            this.user = response.data
        })
        this.tournament = this.$store.state.tournaments.filter((tournament) => {
                return tournament.tournamentId == this.invite.tournamentId
    })
        this.tournament2 = await this.tournament[0]
    }

}
</script>

<style>

#invite-container {
    padding-top: 10px;
    padding-bottom: 10px;
}

#t-invite-card-and-img {
    display: flex;

    margin: auto;

    height: 20rem;
    max-width: 68rem;

    padding: 10px;

    background-color: #232328;

    border:3px solid #4c4c58;
    border-radius: 10px;

    /* justify-content: space-around; */
}

#t-invite-card-and-img:hover {
    border: 3px solid #825AB7;
    box-shadow: 0 0 5px 0.30rem #825AB73a;
}

#t-invite-card {
    display: block;

    margin: auto;

    text-align: center;
    font-family: 'Chakra Petch', sans-serif;
}

.invite-tournament-logo {
    object-fit: cover;
    object-position: 50% 50%;

    width: 20em;
    height: 15em;
}

.no-icon-due-to-null-empty-invite {
    object-fit: scale-down;
    object-position: 50% 50%;

    width: 20em;
    height: 15em;
}

.t-logo-div {
    display: flex;

    object-fit: cover;
    object-position: 50% 50%;
    align-self: center;

    background-color: #32323A;
    border: 3px solid #32323A;
    border-radius: 5px;

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