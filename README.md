README - Hello Maven
====================

## Prerequisites ##

Install Maven either from APT or from the download site.

## Basic commands ##

Generate a project skeleton from an archetype (choose from different archetypeArtifactId):

    mvn archetype:generate -DgroupId=acme -DartifactId=hello-maven -DarchetypeArtifactId=maven-archetype-quickstart

Cleanup and package:

    mvn clean package

Download sources for dependencies:

    mvn dependency:sources

Download javadoc for dependencies:

    mvn dependency:resolve -Dclassifier=javadoc

Generate Ant build files:

    mvn ant:ant
