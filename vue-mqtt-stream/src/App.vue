<template>
  <div id="app">  
    <button v-on:click="onConnect">Connect</button>
  </div>
</template>
<script>

export default {
  name: 'app',
  components: {
  },
  data () {
    return {

    }
  },
  mounted: function() {

  },methods: {
     onConnect: function(){
       this.conmqtt = new this.$mqtt.MQTT.Client(this.hostname, Number(this.port), this.clientId);
        // connect the client 
      // this.conmqtt.connect({onSuccess:this.onConnect});
        // set callback handlers
        //this.conmqtt.onConnectionLost = this.onConnectionLost;
        //this.conmqtt.onMessageArrived = this.onMessageArrived;
       //  this.conmqtt.subscribe(this.topic);
     },
     onMessageHandler: function(){
       /*
        var  message = new Paho.MQTT.Message("Hello");
        message.destinationName = this.topic;
        this.conmqtt.send(message);
        */
        this.connMessage = "onMessageHandler"
     },
     onMessageArrivedHandler: function(){

       this.connMessage = "onMessageArrived"
     },
     onConnectionLostHandler: function(){

       this.connMessage = "onConnectionLost"
     }

  } // end methods
}


</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
