<template>
  <div id="app">  
    <button v-on:click="onMessage">Send</button>
    <div>connMessage:{{connMessage}}</div>
    <div>onMessage:{{message}}</div>
    <div>onPresence:{{presence}}</div>
    <div>onPing:{{ping}}</div>

  </div>
</template>

<script>
import * as MQTT from '@/paho-mqtt.js'
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    HelloWorld
  },
  data () {
    return {
      hostnme: "localhost",
      port: "1883",
      clientId:"wertwetew",
      conmqtt:null,
      topic:"/test/topic",
    }
  },
  mounted: function() {
    this.conmqtt = new MQTT.Paho.MQTT.Client(this.hostnme, Number(this.port), this.clientId);
    // connect the client 
    this.conmqtt.connect({onSuccess:this.onConnect});
    // set callback handlers
    this.conmqtt.onConnectionLost = this.onConnectionLost;
    this.conmqtt.onMessageArrived = this.onMessageArrived;
    this.conmqtt.subscribe(this.topic);
    this.connMessage = "Connect Sucessfully"


  },methods: {
     onMessage: function(){
        message = new Paho.MQTT.Message("Hello");
        message.destinationName = this.topic;
        this.conmqtt.send(message);
     },
     onMessageArrived: function(){

     },
     onConnectionLost: function(){

     }

  },
}



// connect the client
conmqtt.connect({onSuccess:onConnect});


// called when the client connects
function onConnect() {
  // Once a connection has been made, make a subscription and send a message.
  console.log("onConnect");
  client.subscribe("World");
  message = new Paho.MQTT.Message("Hello");
  message.destinationName = "World";
  client.send(message);
}

// called when the client loses its connection
function onConnectionLost(responseObject) {
  if (responseObject.errorCode !== 0) {
    console.log("onConnectionLost:"+responseObject.errorMessage);
  }
}

// called when a message arrives
function onMessageArrived(message) {
  console.log("onMessageArrived:"+message.payloadString);
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
