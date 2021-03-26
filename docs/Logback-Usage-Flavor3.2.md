# Flavor 3.2 - External Config via `logback.xml` OR `logback-spring.xml`, with the direct values for the keys

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

In this flavor, we will see the configuration for a `FileAppender` in addition to the `ConsoleAppender`,
and the values to the file parameters can be specified directly in the XML elements, which is the simple and
easy way when you are trying out the logback, or just happy with the simple log file name - without any dynamism.

## Code Sample

*logback-spring.xml* - an appender for the `FileAppender`

```xml
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>./data/logs/WIP/2021/03/26/log-for-blog-26Mar2021.log</file>
    <append>true</append>
    <!-- set immediateFlush to false for much higher logging throughput -->
    <immediateFlush>true</immediateFlush>
    <encoder>
        <pattern>%-4relative %d{yyyy-MM-dd} | %d{HH:mm:ss.SSS} | [%thread] %-5level %logger{35} - %msg%n</pattern>
    </encoder>
</appender>
```

In the above snippet, we had defined an `<appender>` element for the `FileAppender` with
the appropriate XML attributes as follows.

* `name` - a meaningful name that can be used to refer to this `Appender` anywhere in the XML file,
  for example, to add this Appender to a `logger` element.
* `class` - the fully qualified class name of the Appender in the logback library.
  Here it is `ch.qos.logback.core.FileAppender` for the File Appender.

The Appender takes a few other child elements as follows.

* `<file>` - the name of the file to write the log to, with an optional path.
* `<append>` - a boolean attribute to mention whether to append the logs to the file (if `true`),
  or to overwrite the contents whenever we restart the application (if `false`)
* `<immediateFlush>` - a boolean attribute to indicate whether or not to flush the logging
  statements / contents from the buffer. It is recommended to specify `false` if we need a high
  throughput from the Logger.
* `<encoder> -> <pattern>` - the usual pattern element to specify the *format* of the log entry
  when being printed into the Appender.

## Direct Lookup of a variable/key in the XML file

Logback also supports the simple lookup of variables defined inside the same xml file and used it
elsewhere in the required sections for a better maintenance.

For example, we can add a `timestamp` to the log file name, with a variable `bySecond` defined
at the top of the file, with the pattern `YYYYMMMDD-HHmmss` for the value as follows. We
can refer the same with the `${bySecond}` anywhere we want to inject this value at runtime.

*logback-spring.xml*

```xml
<configuration>
    <!-- Insert the current time formatted as "yyyyMMdd'T'HHmmss" under
     the key "bySecond" into the logger context. This value will be
     available to all subsequent configuration elements. -->
    <timestamp key="bySecond" datePattern="yyyy_MMM_dd_HH_mm_ss"/>
    ...
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <!-- use the previously created timestamp to create a uniquely named log file -->
        <file>./data/logs/WIP/2021/03/26/log-for-blog-26Mar2021-${bySecond}.log</file>
        ...
    </appender>
</configuration>
```

Here we have appended the timestamp information at the end of the log file name, by
referring the `bySecond` variable.  It will be the timestamp at the time the log file
gets created.

*logback-spring.xml* - the complete config file

```xml
<configuration>
    <!-- Insert the current time formatted as "yyyyMMdd'T'HHmmss" under
     the key "bySecond" into the logger context. This value will be
     available to all subsequent configuration elements. -->
    <timestamp key="bySecond" datePattern="yyyy_MMM_dd_HH_mm_ss"/>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{dd-MM-yyyy HH:mm:ss.SSS} | %green([%thread]) | %highlight(%-5level) | %logger{36}.%M - %msg%n</pattern>
        </encoder>
    </appender>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <!-- use the previously created timestamp to create a uniquely named log file -->
        <file>./data/logs/WIP/2021/03/26/log-for-blog-26Mar2021-${bySecond}.log</file>
        <append>true</append>
        <!-- set immediateFlush to false for much higher logging throughput -->
        <immediateFlush>true</immediateFlush>
        <encoder>
            <pattern>%-4relative %d{yyyy-MM-dd} | %d{HH:mm:ss.SSS} | [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="info">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE" />
    </root>
    <logger name="com.example.demo.logback.SpringBootLogbackDemoApplication" additivity="false" level="debug">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE"/>
    </logger>
</configuration>
```

We have two appenders - `STDOUT` and `FILE` respectively and added those two appenders
as a reference to the two loggers - `Root` and `SpringBootLogbackDemoApplication` where
we want the log from each of the loggers into both of the appenders. You can choose to
play around with the config later and see how the output changes based on the appender
references to each logger.

> Note: For the brevity of logs, the logger level of the `root` has been
> configured as `info`.

## Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=61844:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

26-03-2021 19:20:23.220 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 14636 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
26-03-2021 19:20:23.224 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
26-03-2021 19:20:23.226 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
26-03-2021 19:20:23.629 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.758 seconds (JVM running for 1.274)
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*    
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
26-03-2021 19:20:23.631 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
26-03-2021 19:20:23.631 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
26-03-2021 19:20:23.631 | [main] | WARN  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
26-03-2021 19:20:23.631 | [main] | ERROR | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0
```

## Console Output - Directory Tree Structure for the log file being generated

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)      
λ tree /F data                                                                                     
Folder PATH listing for volume Windows-SSD                                                         
Volume serial number is C0000100 3287:9D9D                                                         
C:\USERS\RAGHAVAN MUTHU\ONEDRIVE\DOCUMENTS\PRFSNL\SPRING-BOOT-LOGBACK-DEMO\DATA                    
└───logs                                                                                                             
    └───WIP                                                                                        
        └───2021                                                                                   
            └───03                                                                                                            
                └───26                                                                             
                        log-for-blog-26Mar2021-2021_Mar_26_19_20_23.log                            
                                                                                                   
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)      
λ                                                                                                  
```

## File Output

```java
489  2021-03-26 | 19:20:23.220 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 14636 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
493  2021-03-26 | 19:20:23.224 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - Running with Spring Boot v2.4.4, Spring v5.3.5
495  2021-03-26 | 19:20:23.226 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - No active profile set, falling back to default profiles: default
898  2021-03-26 | 19:20:23.629 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Started SpringBootLogbackDemoApplication in 0.758 seconds (JVM running for 1.274)
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication -  System Properties configured for log*    
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - FILE_LOG_CHARSET=UTF-8
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - CONSOLE_LOG_CHARSET=UTF-8
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - =========================================
900  2021-03-26 | 19:20:23.631 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to debug - Value
900  2021-03-26 | 19:20:23.631 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - doStuff took input - Value
900  2021-03-26 | 19:20:23.631 | [main] WARN  c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to warn - Value
900  2021-03-26 | 19:20:23.631 | [main] ERROR c.e.d.l.SpringBootLogbackDemoApplication - doStuff encountered an error with value - Value
```

## Explanation

* You can observe that the timestamp value `2021_Mar_26_19_20_23.log` has been appended to the
  end of the log file name `log-for-blog-26Mar2021-2021_Mar_26_19_20_23.log` during the file creation,
  based on the format or pattern we specified for the `bySecond` variable in the XML file above.
* The output is no different from the other flavors. The output in the file follows the
  `pattern` specified in the `<appender>` for the `FileAppender`.