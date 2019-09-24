# Real Time Business

Real Time Business strategic to support UXTime approach

## Prepared Enviroment for  

1- Install Tools https://quarkus.io/get-started/

* Download VSCode   https://code.visualstudio.com/Download
* Download JDK from https://adoptopenjdk.net/ ( Download for macOS x64 - Version OpenJDK 8 JVM - Open J9 )
* Download Maven https://maven.apache.org/
* Download JDK from https://adoptopenjdk.net/ 

Enviroment Profile .bash_profile 

```
# PROJECT 
export PROJECT_TOOLS=$HOME/realtimebusiness/tools
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-8-openj9.jdk/Contents/Home/ 
export MAVEN_HOME=${PROJECT_TOOLS}/apache-maven-3.6.2
export PATH=${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}
```

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
3. Update the Project using VSCode 

Modified the return String into method hello

```
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "helloworldfirst\n";
    }
```
The test in other 

```
curl http://localhost:8080/greeting
helloworldfirst
```
Note: quarkus:dev enables hot deployment with background compilation, which means that when you modify your Java files or your resource files and refresh your browser these changes will automatically take effect. 

4. Develop a Simple Application 

### Reference

* https://quarkus.io/get-started/ 
