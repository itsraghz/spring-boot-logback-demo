# Flavor 2.2 - Configuration via `application.properties`, with the placeholders of the `predefined` keys

The `logging.file.name` and `logging.file.path` can be either configured as they are in the `application.properties` file
OR they can be defined with a placeholder which can be supplied in a Java class, or via Command Line Argument via `-D<prop>=value`
while executing a Spring Boot application.

If they are to be provided via the predefined placeholders, they should be tagged as
`LOG_FILE` and `LOG_PATH` as follows.

*Note :* The placeholders are supplied in the configuration file, but the actual values
are yet to be supplied further in the Java class or via the command line argument.

## Code Sample

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

## Console Output

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

## Console Output - Directory Tree Structure for the log file being generated

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
## File Output

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

## Explanation

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