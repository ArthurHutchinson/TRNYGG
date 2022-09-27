<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be NOT authenticated to see this</p>
    <home-description/>
  </div>
</template>

<script>
import HomeDescription from '../components/HomeDescription.vue';
export default {
  components: { HomeDescription },
  name: "home"
};
</script>
