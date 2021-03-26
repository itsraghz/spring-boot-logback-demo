# Flavor 2.3 - Config via `application.properties`, with the placeholders of the `custom` keys

The `logging.file.name` and `logging.file.path` can be either configured as they are in the `application.properties` file
OR they can be defined with a placeholder which can be supplied in a Java class, or via Command Line Argument via `-D<prop>=value`
while executing a Spring Boot application.

If they are to be provided via the custom placeholders, they should be tagged as
meaningful placeholder name for us to easily identify in the code.

Only a change in this flavor when compared to a previous one `Flavor 2.2 - predefined keys` is that
we specify a meaningful key of your choice, say for example, `logFileNameWithPath` to indiciate the log file
name and the path.

## Code Sample

*application.properties*

```java
## ------------------------------------------------------------------------------------------
## Flavor 2.3 - specify the properties in the `application.properties` with the custom keys
## -------------------------------------------------------------------------------------------
#### log file name itself will have a path appended to it, as part of its value supplied at runtime.
logging.file.name=${logFileNameWithPath}
```

*SpringBootLogbackDemoApplication.java*

```java
private static void setProperties() {
    /* Flavor 2.3 - Placeholde set in Java for the logback.xml */
    System.setProperty("logFileNameWithPath", "data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log");
}
```

## Console Output - Program

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=60330:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

23-03-2021 19:14:28.291 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 27928 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
23-03-2021 19:14:28.294 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
23-03-2021 19:14:28.295 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
23-03-2021 19:14:28.647 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.654 seconds (JVM running for 1.188)
23-03-2021 19:14:28.650 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 19:14:28.650 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*    
23-03-2021 19:14:28.650 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - logFileNameWithPath=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_FILE=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
23-03-2021 19:14:28.651 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
23-03-2021 19:14:28.651 [main] TRACE com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed more information - Value
23-03-2021 19:14:28.652 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
23-03-2021 19:14:28.652 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
23-03-2021 19:14:28.653 [main] WARN  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
23-03-2021 19:14:28.653 [main] ERROR com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

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
                └───23
                        app-log-for-blog-23Mar2021.log

C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)
λ
```

## File Output

*data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log*

```java
2021-03-23 19:14:28.291  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 27928 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
2021-03-23 19:14:28.294 DEBUG 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Running with Spring Boot v2.4.4, Spring v5.3.5
2021-03-23 19:14:28.295  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : No active profile set, falling back to default profiles: default
2021-03-23 19:14:28.647  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Started SpringBootLogbackDemoApplication in 0.654 seconds (JVM running for 1.188)
2021-03-23 19:14:28.650  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : ==========================================
2021-03-23 19:14:28.650  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication :  System Properties configured for log*    
2021-03-23 19:14:28.650  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : ==========================================
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : System Property - FILE_LOG_CHARSET=UTF-8
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : System Property - logFileNameWithPath=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : System Property - LOG_FILE=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : System Property - CONSOLE_LOG_CHARSET=UTF-8
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
2021-03-23 19:14:28.651  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : =========================================
2021-03-23 19:14:28.651 TRACE 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed more information - Value
2021-03-23 19:14:28.652 DEBUG 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed to debug - Value
2021-03-23 19:14:28.652  INFO 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff took input - Value
2021-03-23 19:14:28.653  WARN 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed to warn - Value
2021-03-23 19:14:28.653 ERROR 27928 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff encountered an error with value - Value
```

## Explanation

It is no different from the rest of the flavors, except that a custom key/placeholder `logFileNameWithPath`
is configured as a value for the `logging.file.name`, and the placeholder has been supplied a suitable value
in the `setProperties()` method of the Java class - `SpringBootLogbackDemoApplication.java`.

The same can be verified in the Console log and the file log as well, as follows, with the help of
`printSystemProperties()` method.

```java
==========================================
 System Properties configured for log*    
==========================================
System Property - FILE_LOG_CHARSET=UTF-8
System Property - logFileNameWithPath=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
System Property - LOG_FILE=data/logs/WIP/2021/03/23/app-log-for-blog-23Mar2021.log
System Property - CONSOLE_LOG_CHARSET=UTF-8
System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
=========================================

```
The output is as expected in both the Console, and the File with the corresponding patterns as appropriate.