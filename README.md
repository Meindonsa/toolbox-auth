# AUTH ARTEFACT

## Build

```sh
  mvn clean install -DskipTests -T1C
```

## Create release
```sh
  mvn -U -B release:prepare release:perform -DskipTests
```

## Publish
```sh
  mvn clean deploy
```
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