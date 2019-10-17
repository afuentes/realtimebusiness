# vue-mqtt-stream

## Project Creation 
```shell
$ vue create vue-mqtt-stream
$ cd vue-mqtt-stream
$ npm run serve
```
Validated if App is running 
 App running at:
  - Local:   http://localhost:8080/ 

### Add MQTT Javascript Client 

```shell
$ cd vue-mqtt-stream
$ npm install vue-mqtt --save
```

### Active websocket in mosquitto ( Restart Mosquitto Server )
```shell
$ vi cp /usr/local/etc/mosquitto/mosquitto.conf /usr/local/etc/mosquitto/mosquitto.conf.bk
$ vi /usr/local/etc/mosquitto/mosquitto.conf
```

Add the following lines in the "Default Listener" section:

```
port 1883
listener 9001
protocol websockets
```
Validate 

```shell
mosquitto -c /usr/local/etc/mosquitto/mosquitto.conf
1571320919: mosquitto version 1.6.7 starting
1571320919: Config loaded from /usr/local/etc/mosquitto/mosquitto.conf.
1571320919: Opening websockets listen socket on port 9001.
```

### 
```
npm run test
```

### Lints and fixes files
```
npm run lint
```



https://github.com/eclipse/paho.mqtt.javascript

### Reference

* https://mosquitto.org
* http://mqtt-explorer.com/
* https://github.com/nik-zp/Vue-Mqtt-Example
* https://github.com/eclipse/paho.mqtt.javascript


