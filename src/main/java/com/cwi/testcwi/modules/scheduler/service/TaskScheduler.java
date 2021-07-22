package com.cwi.testcwi.modules.scheduler.service;

import java.util.Date;

public interface TaskScheduler {

  void schedule(Runnable task, Date startTime);

  void teste();
}
