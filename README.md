# Real Time Business
Real Time Business Technology Stack Demo 

## Prepared Enviroment  

1- Install Tools https://quarkus.io/get-started/

** Download VSCode   https://code.visualstudio.com/Download
** Download JDK from https://adoptopenjdk.net/ 
    ** Download for macOS x64 - Version OpenJDK 8 JVM - Open J9
** Download Maven https://maven.apache.org/
** Download JDK from https://adoptopenjdk.net/ 

2. Create the first Project with Quarkus 

https://quarkus.io/guides/application-configuration-guide

```
$ mvn io.quarkus:quarkus-maven-plugin:0.22.0:create \
>     -DprojectGroupId=org.acme \
>     -DprojectArtifactId=application-configuration \
>     -DclassName="org.acme.config.GreetingResource" \
>     -Dpath="/greeting"

$ ./mvnw compile quarkus:dev 
$ curl http://localhost:8080/greeting
hello
```

### Reference

* https://quarkus.io/get-started/ 
