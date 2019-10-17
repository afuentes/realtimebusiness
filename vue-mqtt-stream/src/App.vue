<template>
  <div id="app">
    <div>Mesage: {{msg}}</div>
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
      ownMessage:"",
      message:"",
      presence:"",
      ping:"",
      hostnme: "localhost",
      port: "8989",
      clientId:null,
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

  },methods: {
     onConnect: function(){
        this.conmqtt.subscribe("/test/topic");
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
