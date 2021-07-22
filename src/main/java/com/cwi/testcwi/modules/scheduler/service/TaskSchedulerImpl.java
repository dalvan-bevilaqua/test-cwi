package com.cwi.testcwi.modules.scheduler.service;

import com.cwi.testcwi.modules.pauta.service.PautaService;
import com.cwi.testcwi.modules.scheduler.PautaRunnable.PautaRuneable;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class TaskSchedulerImpl implements TaskScheduler {

  @Autowired private PautaService pautaService;

  @Override
  public void schedule(Runnable task, Date startTime) {
    ConcurrentTaskScheduler tarefa = new ConcurrentTaskScheduler();
    tarefa.schedule(task, startTime);
  }

  public void teste() {
    var date = DateUtils.addSeconds(new Date(), 15);
    this.schedule(new PautaRuneable(101001, pautaService), date);
  }
}
