<template>
  <div>
    <button v-on:click="connect" >Connect</button>
    <br/>
    <span>Message: {{ msg }}</span>
    <br/>
    <button v-on:click="fireAndForget" >fireAndForget</button>
    <br/>
    <div>
       
    </div>
  </div>
</template>

<script>
import { RSocketClient, JsonSerializers } from "rsocket-core";
import RSocketWebSocketClient from "rsocket-websocket-client";

export default {
  name: 'RSocketController',
  props: {
  },
  data () {
    return {
      rsocket: null,
      msg: null
    }
  },
 methods: {
  connect: function(){
      const transport = new RSocketWebSocketClient({
        url: "ws://localhost:9898"
      });
      const client = new RSocketClient({
        // send/receive JSON objects instead of strings/buffers
        serializers: JsonSerializers,
        setup: {
          // ms btw sending keepalive to server
          keepAlive: 60000,
          // ms timeout if no keepalive response
          lifetime: 180000,
          // format of `data`
          dataMimeType: "application/json",
          // format of `metadata`
          metadataMimeType: "application/json"
        },
        transport
      });
      client.connect().subscribe({
        onComplete: socket => {
          this.rsocket = socket;
          this.msg = "complete"
        },
        onError: error => {
          this.msg = "Error:"+error 
        },
        onSubscribe: cancel => {
          /* call cancel() to abort */
          this.msg = "Subcribe:"+cancel
        }
      });
  },
  fireAndForget: function(){
    if (this.rsocket) {
        const message = { message: "fire and forget from JavaScript!" };
        this.rsocket.fireAndForget({
              data: message,
              metadata: ""
         });
            this.sent.push(message);
    } else {
      this.msg = "fireAndForget:socket null"
    }  
  }, // end fireAndForget
  } // end methods
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
