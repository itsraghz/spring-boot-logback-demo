# Flavor 2.1 - Configuration via `application.properties` with direct values

The logback configurations can be customized via the `application.properties` file.
Spring Boot has a predefined set of keys to facilitate the customization of logging, and they start with `logging.`.

Example:

* `logging.file.name` and `logging.file.path` to customize the name and location of the log file to be written.
* `logging.level.root` specifies the LOG LEVEL of the Root Logger.It can be any of the 5 levels that can be configured in either lowercase or uppercase. `Trace` > `Debug` > `Info` > `Warn` > `Error`.
* `logging.level.com.example.demo.logback` - to specify a Log level for a package and/or a class
* `logging.pattern.console` - defines the format for the Console Logging.
* `logging.pattern.file` - defines the format for the File Logging.

## Code Sample

*application.properties*

```java
logging.level.root=info
logging.level.com.example.demo.logback=trace
logging.pattern.console=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n

## ------------------------------------------------------------------------------------------
## Flavor 2.1 - specify the properties in the `application.properties` with the direct values
## -------------------------------------------------------------------------------------------
logging.file.path=data/logs/app-res-property/
logging.file.name=${logging.file.path}/log-for-blog-22Mar2021.log
```

> *Note:* that the keys can be referred with one other internally via the `${}` notation. We have referred
> the key `logging.file.path` to the `logging.file.name` key as `${logging.file.path}`.

## Console Output - Program

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=60541:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.4.4)

22-03-2021 23:20:24.923 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 13476 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
22-03-2021 23:20:24.926 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
22-03-2021 23:20:24.928 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
22-03-2021 23:20:25.358 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.795 seconds (JVM running for 1.36)
22-03-2021 23:20:25.360 [main] TRACE com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed more information - Value
22-03-2021 23:20:25.360 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
22-03-2021 23:20:25.360 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
22-03-2021 23:20:25.360 [main] WARN  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
22-03-2021 23:20:25.360 [main] ERROR com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0

```

## Console Output - Directory Tree Structure for the log file being generated

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo
λ tree /F data
Folder PATH listing for volume Windows-SSD
Volume serial number is C0000100 3287:9D9D
C:\USERS\RAGHAVAN MUTHU\ONEDRIVE\DOCUMENTS\PRFSNL\SPRING-BOOT-LOGBACK-DEMO\DATA
└───logs
    ├───app-res-property
    │       log-for-blog-22Mar2021.log
        
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo
λ
```

## Verification of the keys/properties in the `System` class

If we were to verify the keys/properites we configured reflecting at runtime, we can do so
by printing the keys and values of `System.getProperties()`

The below snippet is the output of printing

```java
==========================================
 System Properties configured for log*    
==========================================
System Property - LOG_PATH=data/logs/app-res-property/
System Property - FILE_LOG_CHARSET=UTF-8
System Property - LOG_FILE=data/logs/app-res-property//log-for-blog-22Mar2021.log
System Property - CONSOLE_LOG_CHARSET=UTF-8
System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
=========================================
```

## File Output

*data/logs/app-res-property/log-for-blog-22Mar2021.log*

```java
2021-03-22 23:20:24.923  INFO 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 13476 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
2021-03-22 23:20:24.926 DEBUG 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Running with Spring Boot v2.4.4, Spring v5.3.5
2021-03-22 23:20:24.928  INFO 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : No active profile set, falling back to default profiles: default
2021-03-22 23:20:25.358  INFO 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : Started SpringBootLogbackDemoApplication in 0.795 seconds (JVM running for 1.36)
2021-03-22 23:20:25.360 TRACE 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed more information - Value
2021-03-22 23:20:25.360 DEBUG 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed to debug - Value
2021-03-22 23:20:25.360  INFO 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff took input - Value
2021-03-22 23:20:25.360  WARN 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed to warn - Value
2021-03-22 23:20:25.360 ERROR 13476 --- [main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff encountered an error with value - Value
```

## Explanation

The configuration we made in the `application.properties` file has performed the following.

* Retained the `INFO` level logger to the `ROOT` logger,
* Set the `trace` level for the custom defined package `com.example.demo.logback`, that will facilitate the
  logger level to be lesser (`trace`) ONLY for the classes in the configured package.
* Overridden the `pattern` for the `Console` Logging with the specified/custom format, that has got a few placeholders
  as follows.
    * `%d{}` - specifies a format for the `DateFormatter` of Java
    * `%magenta()` to specify a predefined color for a particular aspect/element of a Logger Statement
    * `%highlight()` - will highlight the surrounded text in an appropriate color depends on the level of logger,
      that follows a set of predefined colors.
* The logger attributes to the `file` are configured with the `dir` and `name`.
* The pattern is *NOT* configured for the log file, hence it will take the _default configuration_
  (as that of Console before it was overwritten)

If you closely observe the console output, it has got the following changes.

> * The format specifier for the log statement is changed. `INFO 22188 --- [       main]` to `[main] INFO`
> * The logger statements for the custom package `com.example.demo.logback.*` appear from the log level `trace` and above.
> * The logging for `root` logger is not changed at all. The built-in Spring Boot output is limited for the brevity.
> * The color of the `thread name` is changed to `magenta` based on the config `%magenta([%thread])`
> * The log file `log-for-blog-22Mar2021.log` has been created inside a directory specified - `data/logs/app-res-property`
> * The log file has got the default pattern specified in Spring Boot as there was no specific configuration
    for the pattern for the log file in the configuration file.
> * The log file has got all the statements what we get in the Console, but with the default pattern
    and without any colors.
