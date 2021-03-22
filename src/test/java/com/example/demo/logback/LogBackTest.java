package com.example.demo.logback;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class LogBackTest {

    private final Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    /*@BeforeAll
    static void setup() {
        System.setProperty("logFileNameWithPath", "./data/logs/WIP/2021/03/19/dynamic-file-name.log");
        System.out.println("setup() - System Property - logFileNameWithPath - has been set");
    }*/

    @Test
    void testLogback() {
        System.setProperty("logFileNameWithPath", "./data/logs/WIP/2021/03/19/dynamic-file-name.log");
        logger.info("setup() - System Property - logFileNameWithPath - has been set");

        logger.info("Example log from {}", LogBackTest.class.getSimpleName());
        logger.debug("Debug message from {}", LogBackTest.class.getSimpleName());
        int val = 1;
        assertEquals(1, val);
    }
}
