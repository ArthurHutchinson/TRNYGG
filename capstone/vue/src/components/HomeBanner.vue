<template>

    <div id="banner-container">

        <img id="csgoimage" src="../assets/bannercsgo3.png">

        <div id="t-banner-text">

        <div id="t-banner-header">
            Build, Host, and Compete in Custom Tournaments!
        </div>
        
        <br>
        With TRNY.GG, users can create tournaments for any game type.<br>Our bracket generator will organize teams and players into matches and allow tournament hosts to submit results for each round. Join any of our existing tournaments or create your own and invite your friends.
        <br>

        <b-button v-bind:to="{ name: 'create-tournament-page' }" id="t-create-t-btn" v-if="$store.state.token != ''">Create Tournament</b-button>
        
        </div>
      
    </div>
</template>

<script>
export default {

}
</script>

<style>

    #csgoimage {

        height: 100%;
        width: 100%;

        user-select: none;
        pointer-events: none;
        -moz-user-select: none;
        -webkit-user-drag: none;
        -webkit-user-select: none;
        -ms-user-select: none;

    }

    #banner-container {
        position: relative;
        text-align: center;
        color: rgb(255, 255, 255);
    }

    #t-banner-header {
        font-family: 'Chakra Petch', sans-serif;
        font-size: 1.75vw;
    }

    #t-banner-text {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -35%);
        
        text-shadow: -2px 2px 2px #000000;
        font-size: 1.3vw;
    }

    #t-create-t-btn {
        font-family: 'Chakra Petch', sans-serif;
        background-color: #FC7900;
        border: none;
        text-shadow: 0px 0px 0px #000000;
        font-size:1vw;
        padding: 0.7vw 0.8vw;
        
        position: relative;
        top: 35px;
    }

    #t-create-t-btn:hover {
        background-color: #c45f00;
    }

</style>