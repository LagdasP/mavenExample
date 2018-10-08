README - Hello Maven
====================

## Prerequisites ##

Install Maven either from APT or from the download site.

## Basic commands ##

Generate a project skeleton from an archetype (choose from different archetypeArtifactId):

    mvn archetype:generate -DgroupId=acme -DartifactId=hello-maven -DarchetypeArtifactId=maven-archetype-quickstart

Package and install locally:

    mvn install

Generate documentation (javadoc):

    mvn javadoc:javadoc

Cleanup (removes target directory):

    mvn clean

