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

        <b-col lg="3">
            <b-card
                id="t-card"
                tag="article"
                style="max-width: 20rem;"
                class="mb-2"
            >
            
                <b-card-img top id='tournament-icon' v-if='tournament.imgUrl' v-bind:src="tournament.imgUrl"/>
                <b-card-img top id="no-icon-due-to-null-empty" v-else src="http://localhost:8080/img/trnygg.d399dc61.png"/> 
                
                <!--  {{ username.substring(0,10)+".." }} MAybe use a if to detect if length is greater than 10-->
                <b-card-title>{{tournament.tournamentName}}</b-card-title>
                <b-card-sub-title>Game: {{tournament.game}}</b-card-sub-title>
                <b-card-sub-title>Host: {{tournament.organizerName}}</b-card-sub-title>
                <b-card-sub-title>Start Date: {{tournament.fromDate}}</b-card-sub-title>
                <b-card-sub-title>End Date: {{tournament.toDate}}</b-card-sub-title>

                <b-button id="t-page-button" v-bind:to="{name: 'tournament-page', params: {id: tournament.tournamentId}}">Tournament Details</b-button>
            
            </b-card>
        </b-col>
    
        
  <!-- </div> -->
</template>

<script>
export default {
    name: 'tournament-card',
    props: {
        tournament: Object,
    },
    methods: {
        imageUrlAlt(event) {
            // BUG, event.target.style is overwriting with element.style than catching the error.
            event.target.src="http://localhost:8080/img/trnygg.d399dc61.png";
            if(event.target.src=="http://localhost:8080/img/trnygg.d399dc61.png") {
                event.target.style="object-fit: scale-down;";
            }
        }
    }

}
</script>

<style>
    .tcard {
        color: #fff;
    }

    #no-icon-due-to-null-empty {
        
        display: block;
        margin-left: auto;
        margin-right: auto;

        height: 10em;
        width: 100%;
        object-fit: scale-down;
        object-position: 50% 50%;

        border:3px solid #32323A;
        border-radius: 5px;

        background-color: #32323A;

    }

    #tournament-icon {
        display: block;
        margin-left: auto;
        margin-right: auto;

        height: 10em;
        width: 100%;
        object-fit:cover;
        object-position: 50% 50%;

        border:3px solid #32323A;
        border-radius: 5px;

        background-color: #32323A;
    }

    #t-card {
        color: black;
        background-color: #232328;
        color:white;
        border:3px solid #4c4c58;
        /* border:3px solid #32323A; */
        
        
    }

    #t-card:hover {
        border: 3px solid #825AB7;
        box-shadow: 0 0 5px 0.30rem #825AB73a;
        /* --bs-pagination-focus-box-shadow: 0 0 0 0.25rem #FC79003a !important; */
        
    }

    #t-page-button {
        font-family: 'Chakra Petch', sans-serif;
        background-color: #FC7900;
        border: none;

        position: relative;
        top: 5px;
    }

    #t-page-button:hover {
        background-color: #c45f00;
    }



</style>