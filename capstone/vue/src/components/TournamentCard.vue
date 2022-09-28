<template>
  <div class= 'card'>
          <h2 class='tournament-name'>
              <!-- <router-link v-bind:to="{name: 'tournament-details', params: {id: tournament.id}}"> -->
                  {{tournament.tournamentName}}
              <!-- </router-link> -->
          </h2>
          <img class='tournament-icon' v-if='tournament.imgUrl' v-bind:src="tournament.imgUrl"/>
          <ul class='tournament-minor-details'>
              <li class='host-details'>
                  <!-- <router-link to host page> -->
                    Host: {{tournament.creator}}
                  <!-- </router-link> -->
              </li>
              <li class='game'> Game: {{tournament.game}}</li>
              <li class ='start-date'>Start-Date: {{tournament.fromDate}}</li>
          </ul>
          <div class="tournament-status-container">
              <h1 class = "tournament-status-display">{{tournament.status}}</h1>
              <p class = "tournament-is-closed-text" v-if="tournament.status == 'closed'">Not accepting sign-ups</p>
              <p class = "tournament-is-open-text" v-if="tournament.status == 'open'">Accepting sign-ups</p>
              <p class = "tournament-is-neither-open-nor-closed-something-is-wrong-text" v-if="tournament.status != 'open' && tournament.status != 'closed'">Something is wrong</p>
          </div>
  </div>
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

</style>