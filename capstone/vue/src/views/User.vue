<template>
  <div>
      <p>You need to be authed to see this page.</p>
      <select-avatar/>
      <pending-invites />
  </div>
</template>

<script>
import PendingInvites from '../components/PendingInvites.vue'
import SelectAvatar from '../components/SelectAvatar.vue'
export default {
  name: "user",
  components: {
    PendingInvites,
    SelectAvatar

  }

}
</script>

<style>

</style>