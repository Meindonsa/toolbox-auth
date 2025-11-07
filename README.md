# AUTH ARTEFACT

# DEV

## Init

`pre-commit install`

NB : make sure your JAVA_HOME is correctly setted. It can be verified with the command `echo $JAVA_HOME`

## Build

`mvn clean install -DskipTests -T1C`

## Create release
`mvn -U -B release:prepare release:perform -DskipTests`

# Usage

## Installation

Add this dependency in dependencies of your `pom.xml` file

```
<dependency>
    <groupId>com.meindonsa</groupId>
    <artifactId>toolbox-auth</artifactId>
    <version>1.0.0</version>
</dependency>
```