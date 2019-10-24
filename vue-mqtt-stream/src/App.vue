<template>
  <div id="app">
      <button @click="onConnectClient">Connect Client & Subscribe </button>
      <br/>
      <button @click="onConnectServer">Connect Server & Subscribe </button>
      <div>
           <span> Connect:{{isOk}}</span> 
      </div>  
      <div v-show="isShow" >
        <div v-if="isClient" class="client"  v-on:mousemove="onMouseMove" >
           {{this.coordClient}}
        </div>
        <div v-else >
          {{this.coordServer}}
          <br/>
          <h2>Mouse Tracking</h2>
          <svg style="width:400px; height:400px; border:1px lightgray solid;"/>
        </div>
      </div> <!-- close show --> 
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
     isShow:false,
     isClient: true,
     isOk: "Disconnect",
     topic:"mqtt/demo",
     status: "",
     client: null,
     value: 1,
     coordClient: { x:0,y:0 },
     coordServer: { x:0,y:0 }
    }
  },
  mounted: function() {

  },methods: {
     onConnectClient: function(){
      this.isShow=true;
      this.client = connect('ws://localhost:9001/ws', {clientId: 'WebClient-' + parseInt(Math.random() * 100000)})
       if(this.client){
         this.isOk = "Connect OK"
       }else {
         this.isOk = "Connect FAIL"
       }
       this.isOk = "Connect Client OK & Subscribe"
     },
     onConnectServer: function(){
      this.isShow=true;
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

     },
     onPublish: function(event){
        this.client.publish(this.topic,JSON.stringify(event))
     },
     onSubscribe: function(){
         this.client.subscribe(this.topic)
     },
     onEventHandler: function(topic, msg){
          this.coordServer = JSON.parse(msg.toString())
            d3.select("svg").append("circle").attr("cx",this.coordServer.x).attr("cy",this.coordServer.y).attr("r","2");
     },
     onMouseMove: function(event){
       this.coordClient.x =event.offsetX 
       this.coordClient.y =event.offsetY
       this.onPublish(this.coordClient)
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
