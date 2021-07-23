package com.cwi.testcwi;

import com.cwi.testcwi.modules.pauta.service.PautaService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class TestcwiApplication {

  @Autowired
  PautaService pautaService;

  public static void main(String[] args) {
    SpringApplication.run(TestcwiApplication.class, args);
  }

}
