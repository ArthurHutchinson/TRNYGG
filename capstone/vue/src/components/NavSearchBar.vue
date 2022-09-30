<template>
  <div>
      <b-navbar-nav id="t-search-bar">
        <b-nav-form id="t-search-bar-form">
          <b-form-input size="sm" type="search" placeholder="Search" v-model="searchTerm"></b-form-input>
          <b-button v-bind:to="{ name: 'tournament-search-results', params: {searchTerm: searchTerm} }" id="t-search-bar-btn" size="sm" type="submit">Search</b-button>
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
        top: 2px;
        left: 10px;
    }

  #t-search-bar-btn {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;
  }
</style>