<template>
    <div id="credits">

      <div>
        <img id="logocredit" src="../assets/trnygg.png">
      </div>

      <div>
        <h4>Website made by:</h4>
        <p>
          Arthur Hutchinson | 
          Jason Rosensteel
          <br>
          Trey Glover |
          Tyler Knightly
        </p>
      </div>

    </div>
</template>

<script>
export default {

}
</script>

<style>
    #credits {
        background-color: #232328;
        border-top: 3px solid #825AB7;
        text-align: center;
        color: white;

        display: flex;
        flex-direction: column;
        justify-content: center;
        align-content: space-between;
    }

    #logocredit {
        padding-top: 5px;
        padding-bottom: 5px;
        width: 300px;
    }
</style>