<template>
<b-navbar id="tnav">

    <b-navbar-nav>
        <div id="t-nav-logo">
          <router-link v-bind:to="{ name: 'home' }" >
            <img src="../assets/trnygg.png">
          </router-link>
        </div>
    </b-navbar-nav>
    
    <b-navbar-nav>
      <div id="tlinks">
        <b-button id="alogin" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</b-button>
        <b-button id="aregister" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''"> Register</b-button>
        <p id="nav-username" v-if="$store.state.token != ''"> <font-awesome-icon id="user-icon-nav" icon="fa-user" />{{$store.state.user.username}}</p>
        <b-button id="auser" v-bind:to="{ name: 'user' }" v-if="$store.state.token != ''">Profile</b-button>
        <b-button id="alogout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</b-button>
      </div>
    </b-navbar-nav>

    </b-navbar>

</template>

<script>
export default {

}
</script>

<style>
    #nav-username {
      margin-bottom: -5px;
      font-family: 'Chakra Petch', sans-serif;
      position: relative;
      right: 20px;
      top: 7px;
    }

    #user-icon-nav {
      margin-right: 5px;
    }
    

    #tnav {
        display: flex;
        justify-content: space-between;

        border-bottom: 3px solid #825AB7; 

        background-color: #232328;
    }

    #t-nav-logo img {
        width: 250px;
    }

    #tlinks {
        display: flex;
        justify-content: space-between;
    }

  #tlinks #alogin {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;

    position: relative;
    right: 10px;
  }

  #tlinks #alogin:hover {
    background-color: #614388;
  }

  #tlinks #aregister {
    background-color: #FC7900;
    border: none;

    position: relative;
    right: 5px;

    font-family: 'Chakra Petch', sans-serif;

  }

  #tlinks #aregister:hover {
    background-color: #c45f00;
  }

  #tlinks #alogout {
    background-color: #FC7900;
    border: none;

    position: relative;
    right: 5px;

    font-family: 'Chakra Petch', sans-serif;
  }

  #tlinks #alogout:hover {
    background-color: #c45f00;
  }

  #tlinks #auser {
    background-color: #825AB7;
    border: none;

    font-family: 'Chakra Petch', sans-serif;

    position: relative;
    right: 10px;
  }

  #tlinks #auser:hover {
    background-color: #614388;
  }



</style>