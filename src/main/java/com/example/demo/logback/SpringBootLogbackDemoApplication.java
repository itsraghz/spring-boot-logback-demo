package com.example.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.Properties;

@SpringBootApplication
public class SpringBootLogbackDemoApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(SpringBootLogbackDemoApplication.class);

    public static void main(String[] args) {
        setProperties();

        SpringBootLogbackDemoApplication obj = new SpringBootLogbackDemoApplication();
        SpringApplication.run(SpringBootLogbackDemoApplication.class, args);
        //obj.printSystemProperties();
        obj.doStuff("Value");
    }

    private static void setProperties() {
        /* Flavor 3 - Placeholde set in Java for the logback.xml */
        /*System.setProperty("logFileNameWithPath", "data/logs/WIP/2021/03/22/dynamic-file-name.log");
        System.setProperty("logFileName", "dynamic-file-name.log");*/

        System.setProperty("LOG_PATH", "data/logs/JavaConfig/");
        //System.setProperty("LOG_FILE", "dynamic-file-name.log");
        //System.setProperty("LOG_FILE", "app-log_21Mar2021.log");
        System.setProperty("LOG_FILE", "app-log_22Mar2021-blog.log");

        System.setProperty("${LOG_PATH}", "data/logs/Java-Config/");
        System.setProperty("${LOG_FILE}", "dynamic-file-name-placeholder.log");
    }

    public void doStuff(final String value) {
        LOGGER.trace("doStuff needed more information - {}", value);
        LOGGER.debug("doStuff needed to debug - {}", value);
        LOGGER.info("doStuff took input - {}", value);
        LOGGER.warn("doStuff needed to warn - {}", value);
        LOGGER.error("doStuff encountered an error with value - {}", value);
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
                //System.out.println(key + "=" + value);
                LOGGER.info("System Property - " + key + "=" + value);
        }
        LOGGER.info("=========================================");
    }
}
