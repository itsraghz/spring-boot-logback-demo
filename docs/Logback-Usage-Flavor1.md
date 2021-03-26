### Flavor 1 - Default SpringBoot Application Main method run()

Without any extra works, run any SpringBoot Application - via the `main()` method.
The default logging is logback enabled.

#### Code Sample

*SpringBootLogbackDemoApplication.java*

It has a set of methods to logger instance with all the LOG levels from `trace` > `debug` > `info` > `warn` > `error`.

> *NOTE*: By default, the `root` logger is set to `INFO` level.

````java
@SpringBootApplication
public class SpringBootLogbackDemoApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(SpringBootLogbackDemoApplication.class);

    public static void main(String[] args) {
        SpringBootLogbackDemoApplication obj = new SpringBootLogbackDemoApplication();
        SpringApplication.run(SpringBootLogbackDemoApplication.class, args);
        obj.doStuff("Value");
    }

    public void doStuff(final String value) {
        LOGGER.trace("doStuff needed more information - {}", value);
        LOGGER.debug("doStuff needed to debug - {}", value);
        LOGGER.info("doStuff took input - {}", value);
        LOGGER.warn("doStuff needed to warn - {}", value);
        LOGGER.error("doStuff encountered an error with value - {}", value);
    }
````

#### Console Output

```java
"C:\Users\Raghavan Muthu\Downloads\jdk-14.0.2_windows-x64_bin\jdk-14.0.2\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always "-javaagent:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\lib\idea_rt.jar=58601:C:\Users\Raghavan Muthu\Downloads\ideaIU-2020.2.1.win\bin" -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath "C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter\2.4.4\spring-boot-starter-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot\2.4.4\spring-boot-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-context\5.3.5\spring-context-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-aop\5.3.5\spring-aop-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-beans\5.3.5\spring-beans-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-expression\5.3.5\spring-expression-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.4.4\spring-boot-autoconfigure-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.4.4\spring-boot-starter-logging-2.4.4.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;C:\Users\Raghavan Muthu\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-core\5.3.5\spring-core-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\springframework\spring-jcl\5.3.5\spring-jcl-5.3.5.jar;C:\Users\Raghavan Muthu\.m2\repository\org\yaml\snakeyaml\1.27\snakeyaml-1.27.jar;C:\Users\Raghavan Muthu\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.example.demo.logback.SpringBootLogbackDemoApplication
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

2021-03-22 21:34:14.092  INFO 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : Starting SpringBootLogbackDemoApplication using Java 14.0.2 on Raghs-LegionY540-TPIN with PID 22188 (C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo\target\classes started by raghs in C:\Users\Raghavan Muthu\OneDrive\Documents\prfsnl\spring-boot-logback-demo)
2021-03-22 21:34:14.094  INFO 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : No active profile set, falling back to default profiles: default
2021-03-22 21:34:14.546  INFO 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : Started SpringBootLogbackDemoApplication in 0.777 seconds (JVM running for 1.346)
2021-03-22 21:34:14.546  INFO 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff took input - Value
2021-03-22 21:34:14.546  WARN 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff needed to warn - Value
2021-03-22 21:34:14.546 ERROR 22188 --- [           main] c.e.d.l.SpringBootLogbackDemoApplication : doStuff encountered an error with value - Value
```

#### Explanation

The output we see in the terminal is only greater than above the `INFO` which is the default setting of `ROOT` logger in Spring Boot.
Hence, we see only 3 lines of statement - `info`, `warn` and `error` as these two are of higher priority than `info`.

> By default, the logs in the Console will have the colors turned on, which will not reflect in the log file. \
> Refer: https://www.tutorialcup.com/spring-boot/spring-boot-logging-configurations.htm#Color_Coded_Output