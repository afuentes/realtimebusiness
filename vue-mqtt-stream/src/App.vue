<template>
  <div id="app">
      <button @click="onConnect">Connect</button>
      <div>Connect:{{isOk}}</div>  
    <div>
       <button @click="onSubscribe">Subsribe on Topic</button>
       <br>
       <button @click="onPublish">Publish on Topic</button>
    </div>
        <div>Status:{{status}}</div>
    <div>
        <div>Notified:{{NotifiedMessage}}</div>
    </div>
  </div>
</template>
<script>
import { connect } from 'mqtt';

export default {
  name: 'app',
  components: {
  },
  data () {
    return {
     isOk: "",
     topic:"mqtt/demo",
     status: "",
     NotifiedMessage: "waiting for message",
     client: null,
     value: 1
    }
  },
  mounted: function() {

  },methods: {
     onConnect: function(){
      this.client = connect('ws://localhost:9001/ws', {clientId: 'WebClient-' + parseInt(Math.random() * 100000)})
       if(this.client){
         this.isOk = "Connect OK"
       }else {
         this.isOk = "Connect FAIL"
       }
       this.client.on("message", this.onEventHandler)

     },
     onPublish: function(){
        this.client.publish(this.topic, "message send "+ this.value++)
        this.status = "Publish Message OK"

     },
     onSubscribe: function(){
         this.client.subscribe(this.topic)
         this.status = "Subscribe OK"
     },
     onEventHandler: function(topic, msg){
          this.NotifiedMessage = "Notified from Business- topic:" + topic +" msg:"+ msg
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
