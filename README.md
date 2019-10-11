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

3. Download Code & Run  

```shell
$ cd $HOME
$ git clone  https://github.com/afuentes/realtimebusiness.git
$ cd  realtimebusiness/kafka-quickstart
$ mvn compile quarkus:dev
```

4. Verified the example is Running 

 open your browser to http://localhost:8080/prices.html, and you should see a fluctuating price.

5. Changed de interval from 5 to 2 in PriceGenerator.java using reload quarkus features 

```java
    @Outgoing("generated-price")
    public Flowable<Integer> generate() {
        return Flowable.interval(2, TimeUnit.SECONDS)
                .map(tick -> random.nextInt(100));
    }
```

Note : No rerun the maven command 

6. update the Pages and validate the new interval 

 Refresh  http://localhost:8080/prices.html, and you should see fluctuating price new interval period

### Reference

* https://kafka.apache.org/
* https://quarkus.io/get-started/ 
* https://quarkus.io/guides

