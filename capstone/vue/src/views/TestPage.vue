<template>
    <div id="test-main">
        <br>

        <p id="test-description">Use this page to test CSS Styling 'n stuff.</p>

        <p>Component: Tournament Bracket</p>
        <tournament-bracket/>

        <br>

        <p>Card Test</p>
       
        <div>
            <b-card
                id="s-card-test"
                title="Card Title"
                img-src="https://picsum.photos/600/300/?image=25"
                img-alt="Image"
                img-top
                tag="article"
                style="max-width: 20rem;"
                class="mb-2"
            >
            <b-card-text>
                Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>

            <b-button href="#" variant="primary">Go somewhere</b-button>
            </b-card>
        </div>
        
    </div>
</template>

<script>
import TournamentBracket from '../components/TournamentBracket.vue'
export default {
  components: { TournamentBracket },

}
</script>

<style>
    #test-description {
        text-align: center;
    }

    .red-border {
        border: 3px solid red;
    }

    
</style>