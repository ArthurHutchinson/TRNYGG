<template>
  <div>
      <b-navbar-nav id="t-search-bar">
        <b-nav-form id="t-search-bar-form">
          <b-form-input size="sm" type="search" placeholder="Search" v-model="searchTerm"></b-form-input>
          <b-button id="t-search-bar-btn" size="sm" type="submit" v-bind:to="{ params: {searchTerm: searchTerm} }">Search</b-button>
        </b-nav-form>
    </b-navbar-nav>
  </div>
</template>

<script>
export default {
    data() {
        return {
            searchTerm: ''
        }
    }
}
</script>

<style>
  #t-search-bar-form {
    display: flex;
    position: relative;
    bottom: 5px;
  }

  #t-search-bar-btn {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;
  }
</style>