# README - Hello Maven


## 0. Prerequisites ##

Install Maven either from APT or from the download site.

## 1. Basic commands ##

Generate a project skeleton from an archetype (choose from different archetypeArtifactId):

    mvn archetype:generate -DgroupId=acme -DartifactId=hello-maven -DarchetypeArtifactId=maven-archetype-quickstart

Package and install locally:

    mvn install

Generate documentation (javadoc):

    mvn javadoc:javadoc

Cleanup (removes target directory):

    mvn clean
    
## 2. Dependencies ##

We declare our dependencies inside POM under `project/dependencies` section, using `dependency` tags.

### 2.1 List dependencies ##

List our dependencies in a hierarchical view (a tree), presenting which dependency pulls another dependency in:

    mvn dependency:tree

or in a flat view:

    mvn dependency:list

### 2.2 Copy dependencies ##

The dependecies are used throughout the build lifecycle, but do not (necesserily) live under our project directory; 
in general they live under local user-wide Maven repository at `~/.m2`).

We can copy our dependencies under our project directory (under `target/dependency`):

    # Copy all dependencies under target/dependency
    mvn dependency:copy-dependencies

    # Copy only runtime dependencies (exclude test dependencies)
    mvn dependency:copy-dependencies -DincludeScope=runtime

This directory can now act as library of externally-supplied JARs.

### 2.3 Use dependencies ###

Lets assume our project compiles successfully and yields a JAR artifact under target directory, e.g. `target/hello-maven-1.0-SNAPSHOT.jar`.
Also, lets assume the main class we want to run is `acme.Foo`.

At some point we actually need to reference our dependencies (as classpath entries) in order to run our application. There are several ways to
do this, 2 of the them (the simpler) are the following ones.

If dependencies are copied under our target directory (e.g. under `target/dependency`), simply add the corresponding library directory to our classpath:

    java -cp 'target/dependency/*:target/hello-maven-1.0-SNAPSHOT.jar' acme.App

Another way is to use Maven `exec` plugin and let it adjust our classpath according to our declared dependencies (no copying needed, we directly 
reference user-wide Maven repository artifacts):

    mvn exec:java -Dexec.mainClass=acme.App 


