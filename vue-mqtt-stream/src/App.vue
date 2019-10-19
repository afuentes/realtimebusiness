<template>
  <div id="app">
      <button @click="onConnectClient">Connect Client & Subscribe </button>
      <br/>
      <button @click="onConnectServer">Connect Server & Subscribe </button>
      <div>
           <span> Connect:{{isOk}}</span> 
      </div>  

      <div v-if="isClient" class="client"  v-on:mousemove="onMouseMove" >
           {{this.coordClient}}
      </div>
      <div v-else >
          <svg style="width:500px; height:500px; border:1px lightgray solid;"/>
      </div>
  </div>
</template>
<script>
import { connect } from 'mqtt';
import * as d3 from 'd3'

export default {
  name: 'app',
  components: {
  },
  data () {
    return {
     isClient: true,
     isOk: "Disconnect",
     topic:"mqtt/demo",
     status: "",
     client: null,
     value: 1,
     coordClient: {},
     coordServer: {}
    }
  },
  mounted: function() {

  },methods: {
     onConnectClient: function(){
      this.client = connect('ws://localhost:9001/ws', {clientId: 'WebClient-' + parseInt(Math.random() * 100000)})
       if(this.client){
         this.isOk = "Connect OK"
       }else {
         this.isOk = "Connect FAIL"
       }
       this.client.on("message", this.onEventHandler)
       this.client.subscribe(this.topic)
       this.isOk = "Connect Client OK & Subscribe"
     },
     onConnectServer: function(){
      this.isClient = false
      this.client = connect('ws://localhost:9001/ws', {clientId: 'WebClient-' + parseInt(Math.random() * 100000)})
       if(this.client){
         this.isOk = "Connect OK"
       }else {
         this.isOk = "Connect FAIL"
       }
       this.client.on("message", this.onEventHandler)
       this.client.subscribe(this.topic)
       this.isOk = "Connect to Server OK & Subscribe"
        d3.select("containersvg")
          .append("svg").attr("width", 400).attr("height", 400).style("background", "red")

     },
     onPublish: function(){
        this.client.publish(this.topic, "message send "+ this.value++)
     },
     onSubscribe: function(){
         this.client.subscribe(this.topic)
     },
     onEventHandler: function(topic, msg){
          this.coordServer = msg
     },
     onMouseMove: function(event){
       
       this.coordClient= "{" +event.offsetX +"," +  event.offsetY + "}"
       this.client.publish(this.topic,this.coordClient)
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

.client {
  height: 400px;
  width:  400px;
  background-color: powderblue;
  margin:0 auto;
}


.server {
  height: 400px;
  width:  400px;
  margin:0 auto;
}
</style>
