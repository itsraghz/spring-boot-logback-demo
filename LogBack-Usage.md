# Usage - Logback

## Introduction

The `logback` has been used as a default logging framework in Spring Boot. 
Without any extra configuration or work, we can get logback working in our application

If needed, we can customize the logging elements, appenders, patterns via the following.

 * The default properties file `application.properties`
 * The external config file `logback.xml` 
 * The Spring flavored `logback-spring.xml`. 
   
> _Spring Boot recommends using this `logback-spring.xml` version as much as possible._

## Topics

 We will cover the following topics where each of them will cover a specific flavor of the Logback 
in a Spring Boot application.

 Three different flavors I had tried with Logback.

 * [Flavor 1 - Default SpringBoot Application Main method run()](docs/Logback-Usage-Flavor1.md)
 * Flavor 2 - Configuration on the `application.properties` file 
    * [Flavor 2.1 - Configuration via `application.properties` with direct values](docs/Logback-Usage-Flavor2.1.md)
    * [Flavor 2.2 - Configuration via `application.properties`, with the placeholders of the `predefined` keys](docs/Logback-Usage-Flavor2.2.md)
    * [Flavor 2.3 - Config via `application.properties`, with the placeholders of the `custom` keys](docs/Logback-Usage-Flavor2.3.md)
 * Flavor 3 - Configuration on the `logback.xml` or the `logback-spring.xml` file
   * [Flavor 3.1 - Flavor 3.1 - External Config via `logback.xml` OR `logback-spring.xml`, with the simplest config - Console Appender](docs/Logback-Usage-Flavor3.1.md) 
   * [Flavor 3.2 - External Config via `logback.xml` OR `logback-spring.xml`, with the direct values](docs/Logback-Usage-Flavor3.2.md)
   * [Flavor 3.3 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `predefined` keys](docs/Logback-Usage-Flavor3.3.md)
   * [Flavor 3.4 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `custom` keys](docs/Logback-Usage-Flavor3.4.md)
    
## Priority

> Needs to be verified further.

A very important factor to note is the priority of each source when we have more than
configuration in place. 

SpringBoot treats the configuration in this order - where the entries configured below
are preferred over the entries above. 

* `application.properties`
* `logback-spring.xml` OR `logback.xml`
* Command Line Arguments supplied via `-D<key>=<value>` _(Highest Priority)_

## Reference Links

* [Spring Boot - Official Doc - Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)
* [Spring Boot - Official Doc - Logging Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-custom-log-configuration)
* [Spring Boot - Official Doc - Configure Logback for Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-logging)
* [Simple, Best and EXCELLENT Tutorial on SpringBoot LogBack](https://lankydan.dev/2019/01/09/configuring-logback-with-spring-boot)
* https://mkyong.com/logging/logback-set-log-file-name-programmatically/
* https://mkyong.com/logging/logback-different-log-file-for-each-thread/
* https://mkyong.com/spring-boot/spring-boot-slf4j-logging-example/
* https://www.baeldung.com/logback
* https://www.baeldung.com/java-logging-intro
* https://examples.javacodegeeks.com/core-java/logback-file-appender-example/