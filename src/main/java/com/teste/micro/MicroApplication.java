package com.teste.micro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class MicroApplication {

  private static final Logger LOGGER = LogManager.getLogger(MicroApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(MicroApplication.class, args);

    LOGGER.info("Info level log message");
    LOGGER.debug("Debug level log message");
    LOGGER.error("Error level log message");
  }
}
