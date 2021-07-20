package com.cwi.testcwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestcwiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestcwiApplication.class, args);
  }
}
