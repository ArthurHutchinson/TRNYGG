<template>
  <div>
      <h3> {{ invite.tournamentId }}</h3>
      <h5> Host: {{invite.organizerId}}</h5>
      <p>Status : {{invite.status}} </p>
      <b-button> Accept </b-button>
      <b-button> Reject </b-button>
  </div>
</template>

<script>
export default {
    name: 'invite-card',
    props: {
        invite: Object,
    }
}
</script>

<style>

</style>