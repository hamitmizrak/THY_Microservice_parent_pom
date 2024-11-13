#!/bin/bash

echo -e "maven create project"


# mvn clean package
# mvn clean compile
# mvn clean install
maven_project(){
    #cd E:\1_Kodlar\Microservices\thy_microservice
    mvn archetype:generate -DgroupId=com.hamitmizrak.microservice -DartifactId=parent_pom -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
}
maven_project