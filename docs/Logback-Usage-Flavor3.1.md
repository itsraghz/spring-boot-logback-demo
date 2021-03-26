# Flavor 3.1 - External Config via `logback.xml` OR `logback-spring.xml`, with the simplest config - Console Appender

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

The flavor in the xml file is _no different_ from the configuration file (properties), except the syntax for each file.

We will have to *empty* (wipe off) the `application.properties` file as we want to drive the configuration from the xml file completely.

## Code Sample

*application.properties*

```java
# Empty file on purpose
# OR comment all the entries with a '#' at the beginning of the each line.
```

*logback-spring.xml*

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{dd-MM-yyyy HH:mm:ss.SSS} | %green([%thread]) | %highlight(%-5level) | %logger{36}.%M - %msg%n</pattern>
        </encoder>
    </appender>
    
    <logger name="com.example.demo.logback.SpringBootLogbackDemoApplication" additivity="false" level="debug">
        <appender-ref ref="STDOUT" />
    </logger>
</configuration>
```

## Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=63985:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

26-03-2021 12:35:29.334 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 26276 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
26-03-2021 12:35:29.337 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
26-03-2021 12:35:29.337 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
26-03-2021 12:35:29.929 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 1.083 seconds (JVM running for 1.894)
26-03-2021 12:35:29.934 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 12:35:29.934 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*    
26-03-2021 12:35:29.935 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 12:35:29.935 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
26-03-2021 12:35:29.935 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
26-03-2021 12:35:29.935 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
26-03-2021 12:35:29.935 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
26-03-2021 12:35:29.937 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
26-03-2021 12:35:29.937 | [main] | WARN  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
26-03-2021 12:35:29.937 | [main] | ERROR | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0
```

## Explanation

The above configuration in the `logback-spring.xml` file is very simple and equivalent to the
same what we had in the `application.properties` file for the console log.

We have a root element `<configuration>` that has two different child elements at a minimum, viz `<appender>`
that acts a channel where we push the contents into, and `<logger>` to have the logger element for an invididual
(and specific logger if needed) and each logger will have one or more `<appender>` elements to which the output
of the logger will be sent to.

The `<logger>` element will have a `<pattern>` element as a child element of `<encoder>`
that takes the actual *format* using which the logger entry will be printed.

The `<logger>` element takes a few attributes, and we have used two of them as described below.
* `name` attribute where we can specify the `FQCN (Fully Qualified Class Name)`
  OR the package name (`a.b.c`) to have all the classes in the package, and the sub packages to have an effect of
  the configuration specified for the logger.
* `level` indicating the level of the logger, which ranges typically from
  `trace` > `debug` > `info` > `warn` > `error`, where each logger on the right has a higher
  precedence / priority than the one on the left. The values are case-insensitive.
* `additivity` indicates whether the contents will be added for each appender. It takes
  a boolean value `true` or `false` and it makes sense when we have more than one appender.

In this example, we have one appender for the `Console` and one logger for the
custom class `SpringBootLogbackDemoApplication` in the package `com.example.demo.logback`,
and the `ConsoleAppender` is inserted as reference to the Logger.

We could also see that the logger specific properties printed on the console
are just the default ones for the `charset`, as we have *NOT* added
any properties to the `System`.

```java
==========================================
System Properties configured for log*
==========================================
System Property - FILE_LOG_CHARSET=UTF-8
System Property - CONSOLE_LOG_CHARSET=UTF-8
=========================================   
``` 
## Enabling an Additional `<logger>` element in the XML file

If needed, we can add a logger for the Spring Framework (it is called `root`) and control the
logging level separately via a different `<logger>` element, as follows.

*logback-spring.xml*

```xml
<root level="debug">
    <appender-ref ref="STDOUT" />
</root>
<logger name="com.example.demo.logback.SpringBootLogbackDemoApplication" additivity="false" level="debug">
    <appender-ref ref="STDOUT" />
</logger>
```

The output will now contain more verbose information from the Spring Framework as it prints
so many logs on its way when it boots up and prepares the application for execution.

The output below has the logs from both the loggers `root` and `SpringBootLogbackDemoApplication`.

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=56903:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.4.4)

26-03-2021 15:13:55.670 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 15412 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
26-03-2021 15:13:55.670 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
26-03-2021 15:13:55.670 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
26-03-2021 15:13:55.670 | [main] | DEBUG | o.s.boot.SpringApplication.load - Loading source class com.example.demo.logback.SpringBootLogbackDemoApplication

        ... Few other lines omitted for brevity ....

26-03-2021 15:13:56.054 | [main] | DEBUG | o.s.j.e.a.AnnotationMBeanExporter.registerBeans - Autodetecting user-defined JMX MBeans
26-03-2021 15:13:56.071 | [main] | DEBUG | o.s.b.a.l.ConditionEvaluationReportLoggingListener.logAutoConfigurationReport -


============================
CONDITIONS EVALUATION REPORT
============================


Positive matches:
-----------------

    AopAutoConfiguration matched:
    - @ConditionalOnProperty (spring.aop.auto=true) matched (OnPropertyCondition)

   ... Few other lines omitted for brevity ....

Negative matches:
-----------------
        JdbcRepositoriesAutoConfiguration:
        Did not match:
        - @ConditionalOnClass did not find required class 'org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration' (OnClassCondition)

        JdbcTemplateAutoConfiguration:
        Did not match:
        - @ConditionalOnClass did not find required class 'org.springframework.jdbc.core.JdbcTemplate' (OnClassCondition)
        
        JpaRepositoriesAutoConfiguration:
        Did not match:
        - @ConditionalOnClass did not find required class 'org.springframework.data.jpa.repository.JpaRepository' (OnClassCondition)

        ... Few other lines omitted for brevity ....
        
26-03-2021 15:13:56.081 | [main] | DEBUG | o.s.c.e.PropertySourcesPropertyResolver.logKeyFound - Found key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemProperties' with value of type String
26-03-2021 15:13:56.081 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.801 seconds (JVM running for 1.475)
26-03-2021 15:13:56.081 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 15:13:56.081 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*    
26-03-2021 15:13:56.081 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 15:13:56.089 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
26-03-2021 15:13:56.089 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
26-03-2021 15:13:56.089 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
26-03-2021 15:13:56.089 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
26-03-2021 15:13:56.090 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
26-03-2021 15:13:56.090 | [main] | WARN  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
26-03-2021 15:13:56.090 | [main] | ERROR | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value
26-03-2021 15:13:56.092 | [SpringContextShutdownHook] | DEBUG | o.s.c.a.AnnotationConfigApplicationContext.doClose - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@413f69cc, started on Fri Mar 26 15:13:55 IST 2021
26-03-2021 15:13:56.092 | [SpringContextShutdownHook] | DEBUG | o.s.c.e.PropertySourcesPropertyResolver.logKeyFound - Found key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemProperties' with value of type String
26-03-2021 15:13:56.092 | [SpringContextShutdownHook] | DEBUG | o.s.j.e.a.AnnotationMBeanExporter.destroy - Unregistering JMX-exposed beans on shutdown

Process finished with exit code 0
```
> The above logs are nothing special. The same would have appeared in Console if we had configured
> the property `logging.level.root=debug` instead of `logging.level.root=info` in the `application.properties` file.