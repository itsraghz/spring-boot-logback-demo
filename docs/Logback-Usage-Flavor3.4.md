# Flavor 3.4 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `custom` keys

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

## Code Sample

*logback-spring.xml*

```xml
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>${logFileNameWithPath}</file>
        <append>true</append>
        <!-- set immediateFlush to false for much higher logging throughput -->
        <immediateFlush>true</immediateFlush>
        <encoder>
            <pattern>%-4relative %d{yyyy-MM-dd} | %d{HH:mm:ss.SSS} | [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>
```

*SpringBootLogbackDemoApplication.java*

```java
    private static void setProperties() {
        /* Flavor 3 - Placeholder set in Java for the logback.xml */
        System.setProperty("logFileNameWithPath", "data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log");
    }
```

## Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=62350:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.4.4)

26-03-2021 19:50:52.389 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 17608 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
26-03-2021 19:50:52.392 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
26-03-2021 19:50:52.392 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
26-03-2021 19:50:52.859 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.883 seconds (JVM running for 1.492)
26-03-2021 19:50:52.861 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:50:52.861 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*
26-03-2021 19:50:52.862 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:50:52.862 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
26-03-2021 19:50:52.862 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - logFileNameWithPath=data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log
26-03-2021 19:50:52.862 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
26-03-2021 19:50:52.862 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
26-03-2021 19:50:52.862 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
26-03-2021 19:50:52.863 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
26-03-2021 19:50:52.863 | [main] | WARN  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
26-03-2021 19:50:52.863 | [main] | ERROR | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0
```

As always, we can see the log specific properites printed in the Console
proving the values we supplied in the Java class, taking effect at runtime.

```java
==========================================
 System Properties configured for log*    
==========================================
System Property - FILE_LOG_CHARSET=UTF-8
System Property - logFileNameWithPath=data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log
System Property - CONSOLE_LOG_CHARSET=UTF-8
=========================================
```

## Console Output - Directory Tree Structure for the log file being generated

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)
λ tree /F data
Folder PATH listing for volume Windows-SSD
Volume serial number is C0000100 3287:9D9D
C:\USERS\RAGHAVAN MUTHU\ONEDRIVE\DOCUMENTS\PRFSNL\SPRING-BOOT-LOGBACK-DEMO\DATA
└───logs
    ├───JavaConfig
    │       app-log-XML-config-26Mar2021.log
    │
    └───WIP
        └───2021
            └───03
                └───26
                        app-log-XML-customKey-26Mar2021.log
                        log-for-blog-26Mar2021-2021_Mar_26_19_20_23.log
        
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)
λ
```

## File Output

```java
591  2021-03-26 | 19:50:52.389 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 17608 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
594  2021-03-26 | 19:50:52.392 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - Running with Spring Boot v2.4.4, Spring v5.3.5
594  2021-03-26 | 19:50:52.392 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - No active profile set, falling back to default profiles: default
1061 2021-03-26 | 19:50:52.859 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Started SpringBootLogbackDemoApplication in 0.883 seconds (JVM running for 1.492)
1063 2021-03-26 | 19:50:52.861 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
1063 2021-03-26 | 19:50:52.861 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication -  System Properties configured for log*    
1064 2021-03-26 | 19:50:52.862 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
1064 2021-03-26 | 19:50:52.862 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - FILE_LOG_CHARSET=UTF-8
1064 2021-03-26 | 19:50:52.862 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - logFileNameWithPath=data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log
1064 2021-03-26 | 19:50:52.862 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - CONSOLE_LOG_CHARSET=UTF-8
1064 2021-03-26 | 19:50:52.862 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - =========================================
1064 2021-03-26 | 19:50:52.862 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to debug - Value
1065 2021-03-26 | 19:50:52.863 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - doStuff took input - Value
1065 2021-03-26 | 19:50:52.863 | [main] WARN  c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to warn - Value
1065 2021-03-26 | 19:50:52.863 | [main] ERROR c.e.d.l.SpringBootLogbackDemoApplication - doStuff encountered an error with value - Value
```

## Explanation

* The `FileAppender` has got a custom key `logFileNameWithPath` defined for the `<name>` element
* The custom key is supplied a suitable value `data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log` in the
  `setProperties()` method of `SpringBootLogbackDemoApplication.java` class.
* There are two loggers - `Root` and `SpringBootLogbackDemoAppplication` with the appropriate
  logger levels and the `<appender>` elements configured with the respective `<pattern>` elements
* The output is printed on the console and the file. 