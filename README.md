# Real Time Business

Online Event Processing Platform

## Prepared Enviroment

1- Download Tools https://quarkus.io/get-started/

* VSCode from https://code.visualstudio.com/Download
* JDK    from https://adoptopenjdk.net/ ( Download for macOS x64 - Version OpenJDK 8 JVM - Open J9 )
* Maven from https://maven.apache.org/
* Kafka from https://kafka.apache.org/downloads

2- Install toolset 

```shell
$ cd $HOME/toolset
$ unzip apache-maven-3.6.2-bin.zip
$ tar xvfz kafka_2.12-2.3.0.tar.gz  
```

3- Enviroment Profile .bash_profile 

```shell
# TOOLSET 
export TOOLSET=$HOME/toolset
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-8-openj9.jdk/Contents/Home/ 
export MAVEN_HOME=${TOOLSET}/apache-maven-3.6.2
export KAFKA_HOME=${TOOLSET}/kafka_2.12-2.3.0
export KAFKA_CONFIG=${TOOLSET}/kafka_2.12-2.3.0/config
export PATH=${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${KAFKA_HOME}/bin:${PATH}
```

2. Startup Kafka Cluster 

```shell
$ zookeeper-server-start.sh $KAFKA_CONFIG/zookeeper.properties
$ kafka-server-start.sh $KAFKA_CONFIG/server.properties
```
Note:  open different terminal for each process 

3.  Develop example 

```shell
$ cd $HOME
$ git clone 
```

Modified the return String into method hello

```java
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "helloworldfirst\n";
    }
```
validate the modify code 

```javascript
curl http://localhost:8080/greeting
helloworldfirst
```
**Note**: quarkus:dev enables hot deployment with background compilation, which means that when you modify your Java files or your resource files and refresh your browser these changes will automatically take effect. 


## Develop Real Time Demo 

4. Develop a Simple Application 

### Reference
* https://kafka.apache.org/
* https://queue.acm.org/detail.cfm?id=3321612
* https://quarkus.io/get-started/ 
* https://quarkus.io/guides/kafka-guide
* https://github.com/confluentinc/kafka-streams-examples

