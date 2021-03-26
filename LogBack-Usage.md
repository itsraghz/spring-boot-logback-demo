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

 * [Flavor 1 - Default SpringBoot Application Main method run()](docs/Logback-Usage-Flavor1.md)
 * Flavor 2 - Configuration on the `application.properties` file 
    * Flavor 2.1 - Configuration via `application.properties` with direct values
    * Flavor 2.2 - Configuration via `application.properties`, with the placeholders of the `predefined` keys
    * Flavor 2.3 - Config via `application.properties`, with the placeholders of the `custom` keys
 * Flavor 3 - Configuration on the `logback.xml` or the `logback-spring.xml` file
   * Flavor 3.1 - Flavor 3.1 - External Config via `logback.xml` OR `logback-spring.xml`, with the simplest config - Console Appender 
   * Flavor 3.2 - External Config via `logback.xml` OR `logback-spring.xml`, with the direct values
   * Flavor 3.3 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `predefined` keys
   * Flavor 3.4 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `custom` keys
    
## Flavors

Three different flavors I had tried with Logback.

### Flavor 2.1 - Configuration via `application.properties` with direct values

The logback configurations can be customized via the `application.properties` file. 
Spring Boot has a predefined set of keys to facilitate the customization of logging, and they start with `logging.`.

Example: 

 * `logging.file.name` and `logging.file.path` to customize the name and location of the log file to be written.
 * `logging.level.root` specifies the LOG LEVEL of the Root Logger.It can be any of the 5 levels that can be configured in either lowercase or uppercase. `Trace` > `Debug` > `Info` > `Warn` > `Error`.
 * `logging.level.com.example.demo.logback` - to specify a Log level for a package and/or a class
 * `logging.pattern.console` - defines the format for the Console Logging.
 * `logging.pattern.file` - defines the format for the File Logging.

#### Code Sample

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

#### Console Output - Program

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

#### Console Output - Directory Tree Structure for the log file being generated

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

#### Verification of the keys/properties in the `System` class

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

#### File Output 

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

#### Explanation

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

### Flavor 2.2 - Configuration via `application.properties`, with the placeholders of the `predefined` keys

The `logging.file.name` and `logging.file.path` can be either configured as they are in the `application.properties` file
 OR they can be defined with a placeholder which can be supplied in a Java class, or via Command Line Argument via `-D<prop>=value`
while executing a Spring Boot application.

If they are to be provided via the predefined placeholders, they should be tagged as
`LOG_FILE` and `LOG_PATH` as follows.

*Note :* The placeholders are supplied in the configuration file, but the actual values 
are yet to be supplied further in the Java class or via the command line argument.

#### Code Sample

*application.properties*

Here we specify the predefined keys `${LOG_PATH}` and `${LOG_FILE}` as the values to the
keys `logging.file.path`

```java
logging.level.root=info
logging.level.com.example.demo.logback=trace
logging.pattern.console=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
        
## ---------------------------------------------------------------------------------------------
## Flavor 2.2 - specify the properties in the `application.properties` with the predefined keys
## ---------------------------------------------------------------------------------------------
logging.file.path=${LOG_PATH}
logging.file.name=${LOG_PATH}/${LOG_FILE}
logging.pattern.file=%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{36}.%M - %msg%n```
```

*SpringBootLogbackDemoApplication.java*

```java
private static void setProperties() {
    System.setProperty("LOG_PATH", "data/logs/JavaConfig/");
    System.setProperty("LOG_FILE", "app-log-for-blog-23Mar2021.log");
}

public void printSystemProperties() {
    Properties systemProps = System.getProperties();
    LOGGER.info("==========================================");
    LOGGER.info(" System Properties configured for log*    ");
    LOGGER.info("==========================================");
    for (Iterator<Object> it = systemProps.keySet().iterator(); it.hasNext(); ) {
    String key = (String) it.next();
    String value = systemProps.getProperty(key);
    if(key.toUpperCase().contains("LOG"))
        LOGGER.info("System Property - " + key + "=" + value);
    }
    LOGGER.info("=========================================");
}

public static void main(String[] args) {
    setProperties();
    SpringBootLogbackDemoApplication obj = new SpringBootLogbackDemoApplication();
    SpringApplication.run(SpringBootLogbackDemoApplication.class, args);
    obj.printSystemProperties();
    obj.doStuff("Value");
}
```

#### Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=59591:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.4.4)

23-03-2021 08:34:32.749 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 45588 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
23-03-2021 08:34:32.751 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
23-03-2021 08:34:32.752 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
23-03-2021 08:34:33.228 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.86 seconds (JVM running for 1.448)
23-03-2021 08:34:33.230 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 08:34:33.230 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*
23-03-2021 08:34:33.230 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 08:34:33.232 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_PATH=data/logs/JavaConfig/
23-03-2021 08:34:33.232 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
23-03-2021 08:34:33.232 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{36}.%M - %msg%n
23-03-2021 08:34:33.232 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_FILE=data/logs/JavaConfig//app-log-for-blog-23Mar2021.log
23-03-2021 08:34:33.233 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
23-03-2021 08:34:33.233 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
23-03-2021 08:34:33.233 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
23-03-2021 08:34:33.233 [main] TRACE com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed more information - Value
23-03-2021 08:34:33.235 [main] DEBUG com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
23-03-2021 08:34:33.236 [main] INFO  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
23-03-2021 08:34:33.236 [main] WARN  com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
23-03-2021 08:34:33.236 [main] ERROR com.example.demo.logback.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0
```

#### Console Output - Directory Tree Structure for the log file being generated

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (main)     
λ tree /F data                                                                        
Folder PATH listing for volume Windows-SSD                                            
Volume serial number is C0000100 3287:9D9D                                            
C:\USERS\RAGHAVAN MUTHU\ONEDRIVE\DOCUMENTS\PRFSNL\SPRING-BOOT-LOGBACK-DEMO\DATA       
└───logs                                                                              
    ├───app-res-property                                                              
    │       log-for-blog-22Mar2021.log                                                
    │                                                                                 
    ├───JavaConfig                                                                    
    │       app-log-for-blog-23Mar2021.log                                            
                                                                                               
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (main)     
λ                                                                                     
```
#### File Output

*data/logs/JavaConfig/app-log-for-blog-23Mar2021.log*

```java
23-03-2021 08:34:32.749 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 45588 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
23-03-2021 08:34:32.751 [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
23-03-2021 08:34:32.752 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
23-03-2021 08:34:33.228 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.86 seconds (JVM running for 1.448)
23-03-2021 08:34:33.230 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 08:34:33.230 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*    
23-03-2021 08:34:33.230 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
23-03-2021 08:34:33.232 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_PATH=data/logs/JavaConfig/
23-03-2021 08:34:33.232 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
23-03-2021 08:34:33.232 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{36}.%M - %msg%n
23-03-2021 08:34:33.232 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_FILE=data/logs/JavaConfig//app-log-for-blog-23Mar2021.log
23-03-2021 08:34:33.233 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
23-03-2021 08:34:33.233 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
23-03-2021 08:34:33.233 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
23-03-2021 08:34:33.233 [main] TRACE c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed more information - Value
23-03-2021 08:34:33.235 [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
23-03-2021 08:34:33.236 [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
23-03-2021 08:34:33.236 [main] WARN  c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
23-03-2021 08:34:33.236 [main] ERROR c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value
```

#### Explanation

We have made a significant changes to the Program to accommodate the configuration values as follows.

* Configured the predefined keys `${LOG_PATH}`, `${LOG_FILE}` as the values to the properties `logging.file.path` and `logging.file.name` respectively, 
  that instructs Spring Boot that the values should be supplied further in Java runtime for these placeholders.
* We had added a new method `setProperties()` to supply the values to the predefined keys - `LOG_PATH`, `LOG_FILE`.
* For a change,we have configured a pattern for the file logging in the `application.properties` file via the key `logging.pattern.file`.  
* Notice the following addition in the console log, and the file log, printed from the `printSystemProperties()` method, 
  where we see all the patterns configured in the `System` whose keys contain the term `log`. This includes the comprehensive
  set of properties, not just with what we had configured in the `setProperties()` method.
```java
==========================================
 System Properties configured for log*    
==========================================
System Property - LOG_PATH=data/logs/JavaConfig/
System Property - FILE_LOG_CHARSET=UTF-8
System Property - FILE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{36}.%M - %msg%n
System Property - LOG_FILE=data/logs/JavaConfig//app-log-for-blog-23Mar2021.log
System Property - CONSOLE_LOG_CHARSET=UTF-8
System Property - CONSOLE_LOG_PATTERN=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger.%M - %msg%n
=========================================
```
 You could see that the keys what we set in the `setProperties()` method reflects in the log as `LOG_PATH` and `LOG_FILE`, 
 and the keys `logging.pattern.console` and `logging.pattern.file` in the `application.properties` file, 
 reflects in the console log as `CONSOLE_LOG_PATTERN` and `FILE_LOG_PATTERN` respectively.

### Flavor 2.3 - Config via `application.properties`, with the placeholders of the `custom` keys

The `logging.file.name` and `logging.file.path` can be either configured as they are in the `application.properties` file
OR they can be defined with a placeholder which can be supplied in a Java class, or via Command Line Argument via `-D<prop>=value`
while executing a Spring Boot application.

If they are to be provided via the custom placeholders, they should be tagged as
meaningful placeholder name for us to easily identify in the code.

Only a change in this flavor when compared to a previous one `Flavor 2.2 - predefined keys` is that 
we specify a meaningful key of your choice, say for example, `logFileNameWithPath` to indiciate the log file 
name and the path.

#### Code Sample

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

#### Console Output - Program

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

#### Console Output - Directory Tree Structure for the log file being generated

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

#### File Output

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

#### Explanation

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

### Flavor 3.1 - External Config via `logback.xml` OR `logback-spring.xml`, with the simplest config - Console Appender

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

The flavor in the xml file is _no different_ from the configuration file (properties), except the syntax for each file.

We will have to *empty* (wipe off) the `application.properties` file as we want to drive the configuration from the xml file completely.

#### Code Sample

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

#### Console Output

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

#### Explanation

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
#### Enabling an Additional `<logger>` element in the XML file

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

### Flavor 3.2 - External Config via `logback.xml` OR `logback-spring.xml`, with the direct values for the keys

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

  In this flavor, we will see the configuration for a `FileAppender` in addition to the `ConsoleAppender`,
and the values to the file parameters can be specified directly in the XML elements, which is the simple and 
easy way when you are trying out the logback, or just happy with the simple log file name - without any dynamism. 

#### Code Sample

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

##### Direct Lookup of a variable/key in the XML file 

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

#### Console Output

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

#### Console Output - Directory Tree Structure for the log file being generated

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

#### File Output

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

#### Explanation

* You can observe that the timestamp value `2021_Mar_26_19_20_23.log` has been appended to the
  end of the log file name `log-for-blog-26Mar2021-2021_Mar_26_19_20_23.log` during the file creation,
  based on the format or pattern we specified for the `bySecond` variable in the XML file above.
* The output is no different from the other flavors. The output in the file follows the
  `pattern` specified in the `<appender>` for the `FileAppender`.

### Flavor 3.3 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `predefined` keys

> *Note*: Spring Boot officially recommends using the `-spring` variant of the 
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

Similar to the `application.properties`, we can specify the predefined keys for the log file name,
and the path via `LOG_PATH` and `LOG_FILE` parameters in the `<name>` element of the `<appender>` element
for the `FileAppender` as follows.

```xml
<file>${LOG_PATH}/${LOG_FILE}</file>
```
#### Code Sample

*logback-spring.xml*

```xml
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>${LOG_PATH}/${LOG_FILE}</file>
    <append>true</append>
    <!-- set immediateFlush to false for much higher logging throughput -->
    <immediateFlush>true</immediateFlush>
    <encoder>
        <pattern>%-4relative %d{yyyy-MM-dd} | %d{HH:mm:ss.SSS} | [%thread] %-5level %logger{35} - %msg%n</pattern>
    </encoder>
</appender>
```

We need to supply the values at runtime either via Java class or the Command Line Arugments 
via the `-D<key>=<value>`. 

*SpringBootLogbackDemoApplication.java*

```java
private static void setProperties() {
    System.setProperty("LOG_PATH", "data/logs/JavaConfig/");
    System.setProperty("LOG_FILE", "app-log-XML-config-26Mar2021.log");
}
```

#### Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=62083:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.4.4)

26-03-2021 19:35:21.499 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 6540 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
26-03-2021 19:35:21.501 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.logStarting - Running with Spring Boot v2.4.4, Spring v5.3.5
26-03-2021 19:35:21.501 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStartupProfileInfo - No active profile set, falling back to default profiles: default
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.logStarted - Started SpringBootLogbackDemoApplication in 0.704 seconds (JVM running for 1.196)
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties -  System Properties configured for log*
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - ==========================================
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_PATH=data/logs/JavaConfig/
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - FILE_LOG_CHARSET=UTF-8
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - LOG_FILE=app-log-XML-config-26Mar2021.log
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - System Property - CONSOLE_LOG_CHARSET=UTF-8
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.printSystemProperties - =========================================
26-03-2021 19:35:21.880 | [main] | DEBUG | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to debug - Value
26-03-2021 19:35:21.880 | [main] | INFO  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff took input - Value
26-03-2021 19:35:21.880 | [main] | WARN  | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff needed to warn - Value
26-03-2021 19:35:21.880 | [main] | ERROR | c.e.d.l.SpringBootLogbackDemoApplication.doStuff - doStuff encountered an error with value - Value

Process finished with exit code 0
```

The `systemProperties` proves that the values we supplied is effective at runtime.

```java
==========================================
 System Properties configured for log*    
==========================================
System Property - LOG_PATH=data/logs/JavaConfig/
System Property - FILE_LOG_CHARSET=UTF-8
System Property - LOG_FILE=app-log-XML-config-26Mar2021.log
System Property - CONSOLE_LOG_CHARSET=UTF-8
=========================================
```

#### Console Output - Directory Tree Structure for the log file being generated

```java
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)        
λ tree /F data                                                                                       
Folder PATH listing for volume Windows-SSD                                                           
Volume serial number is C0000100 3287:9D9D                                                           
C:\USERS\RAGHAVAN MUTHU\ONEDRIVE\DOCUMENTS\PRFSNL\SPRING-BOOT-LOGBACK-DEMO\DATA                      
└───logs                                                                                                      
    ├───JavaConfig                                                                                   
    │       app-log-XML-config-26Mar2021.log                                                                  
                                                                                                     
                                                                                                     
C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo (master -> origin)        
λ                                                                                                    
```

#### File Output

The output gets printed in the file `.data/logs/JavaConfig/app-log-XML-config-26Mar2021.log`
as per the configuration in the Java class.

The output is no different from the rest of the other flavors. 

```java
458  2021-03-26 | 19:35:21.499 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 6540 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
460  2021-03-26 | 19:35:21.501 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - Running with Spring Boot v2.4.4, Spring v5.3.5
460  2021-03-26 | 19:35:21.501 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - No active profile set, falling back to default profiles: default
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - Started SpringBootLogbackDemoApplication in 0.704 seconds (JVM running for 1.196)
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication -  System Properties configured for log*    
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - ==========================================
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - LOG_PATH=data/logs/JavaConfig/
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - FILE_LOG_CHARSET=UTF-8
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - LOG_FILE=app-log-XML-config-26Mar2021.log
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - System Property - CONSOLE_LOG_CHARSET=UTF-8
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - =========================================
839  2021-03-26 | 19:35:21.880 | [main] DEBUG c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to debug - Value
839  2021-03-26 | 19:35:21.880 | [main] INFO  c.e.d.l.SpringBootLogbackDemoApplication - doStuff took input - Value
839  2021-03-26 | 19:35:21.880 | [main] WARN  c.e.d.l.SpringBootLogbackDemoApplication - doStuff needed to warn - Value
839  2021-03-26 | 19:35:21.880 | [main] ERROR c.e.d.l.SpringBootLogbackDemoApplication - doStuff encountered an error with value - Value
```

#### Explanation

* The file name is specified via `LOG_PATH` and `LOG_FILE` parameters/keys in the XML file
* The actual log file name has got the values supplied in the Java config file
* The output is printed in both the Console and the File, basis on the appender references
added to the loggers specified, and the corresponding pattern/format for each appender.
* The content of the log (in `Console` and the `File`) does NOT differ from the rest of the
flavors.

### Flavor 3.4 - External Config via `logback.xml` OR `logback-spring.xml`, with the placeholders of the `custom` keys

> *Note*: Spring Boot officially recommends using the `-spring` variant of the
> configuration file (`logback-spring.xml`) whenever possible to have a better control, than the plain versions of the
> configuration `logback.xml`

#### Code Sample

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

#### Console Output

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

#### Console Output - Directory Tree Structure for the log file being generated

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

#### File Output

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

#### Explanation

* The `FileAppender` has got a custom key `logFileNameWithPath` defined for the `<name>` element
* The custom key is supplied a suitable value `data/logs/WIP/2021/03/26/app-log-XML-customKey-26Mar2021.log` in the 
`setProperties()` method of `SpringBootLogbackDemoApplication.java` class.
* There are two loggers - `Root` and `SpringBootLogbackDemoAppplication` with the appropriate
logger levels and the `<appender>` elements configured with the respective `<pattern>` elements 
* The output is printed on the console and the file. 

## Priority

> Needs to be revisited and verified.

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