<template>
  <!-- <div class='tcard'> -->
          <!-- <h2 class='tournament-name'>
              <router-link v-bind:to="{name: 'tournament-page', params: {id: tournament.tournamentId}}">
                  {{tournament.tournamentName}}
              </router-link>
          </h2>
          <img class='tournament-icon' v-if='tournament.imgUrl' v-bind:src="tournament.imgUrl"/>
          <ul class='tournament-minor-details'>
              <li class='host-details'> -->
                  <!-- <router-link to host page> -->
                    <!-- Host: {{tournament.organizerName}} -->
                  <!-- </router-link> -->
              <!-- </li>
              <li class='game'> Game: {{tournament.game}}</li>
              <li class ='start-date'>Start-Date: {{tournament.fromDate}}</li>
          </ul>
          <div class="tournament-status-container">
              <h1 class = "tournament-status-display">{{tournament.status}}</h1>
              <p class = "tournament-status-text" v-if="tournament.status == 'closed'">Not accepting sign-ups</p>
              <p class = "tournament-status-text" v-if="tournament.status == 'open'">Accepting sign-ups</p>
              <p class = "tournament-status-text" v-if="tournament.status != 'open' && tournament.status != 'closed'">Something is wrong</p>
          </div> -->

        <b-col md="4">
        <b-card
            id="t-card"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
        >

        <b-card-img class='tournament-icon' v-if='tournament.imgUrl' v-bind:src="tournament.imgUrl"/>

        <b-card-title>{{tournament.tournamentName}}</b-card-title>
        <b-card-sub-title>Game: {{tournament.game}}</b-card-sub-title>
        <b-card-sub-title>Host: {{tournament.organizerName}}</b-card-sub-title>
        <b-card-sub-title>Start Date: {{tournament.fromDate}}</b-card-sub-title>
        <b-card-sub-title>End Date: {{tournament.toDate}}</b-card-sub-title>

        <b-card-text>
            TODO: Add Description of Card
        </b-card-text>

        <b-button v-bind:to="{name: 'tournament-page', params: {id: tournament.tournamentId}}">Tournament Page</b-button>
        </b-card>
        </b-col>
    
        
  <!-- </div> -->
</template>

<script>
export default {
    name: 'tournament-card',
    props: {
        tournament: Object,
    }

}
</script>

<style>
    .tcard {
        color: #fff;
    }

    /* .tournament-icon {
        width: 200px;
        height: 50%;
    } */

    #t-card {
        color: black;
        background-color: #232328;
        color:white;
        border:3px solid #825AB7;
    }

</style>