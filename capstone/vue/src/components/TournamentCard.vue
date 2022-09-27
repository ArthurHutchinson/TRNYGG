<template>
  <div class= 'card'>
      
          <h2 class='tournament-name'>
              <router-link v-bind:to="{name: 'tournament-details', params: {id: tournament.id}}">
                  {{tournament.name}}
              </router-link>
          </h2>
          <img v-if='tournament.image' v-bind:src="tournament.image"/>
          <ul class='tournament-minor-details'>
              <li class='host-details'>
                  <!-- <router-link to host page> -->
                    Host: {{tournament.creator}}
                  <!-- </router-link> -->
              </li>
              <li class='game'> Game: {{tournament.game}}</li>
              <li class ='start-date'>Start-Date: {{tournament.startDate}}</li>
          </ul>
          <div class="tournament-status-container">
              <h1 class = "tournament-status-display">{{tournament.status}}</h1>
              <p class = "tournament-is-closed-text" v-if="tournament.status == 'closed'">Not accepting sign-ups</p>
              <p class = "tournament-is-open-text" v-if="tournament.status == 'open'">Accepting sign-up</p>
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