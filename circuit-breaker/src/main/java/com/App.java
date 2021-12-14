package com;

import lombok.extern.slf4j.Slf4j;

/**
 * decoupling 解偶 performance 性能 behavioral 行为 circuit breaker Programmatic
 */
@Slf4j
public class App {

  public static void main (String[] args) {
    final long serverStartTime = System.nanoTime();
    final DelayedRemoteService delayedService = new DelayedRemoteService(serverStartTime, 5);
    final DefaultCircuitBreaker delayedCircuitBreaker = new DefaultCircuitBreaker(3000, 2, delayedService, 2000 * 2000 * 100);
    final QuickRemoteService quickRemoteService = new QuickRemoteService();
    final DefaultCircuitBreaker quickCircuitBreaker = new DefaultCircuitBreaker(3000, 2, quickRemoteService, 2000 * 2000 * 100);
//    创建一个监控对象，用来调用本地服务与远程服务
    final MonitoringService monitoringService = new MonitoringService(delayedCircuitBreaker, quickCircuitBreaker);
//    请求本地资源
    log.info(monitoringService.localResourceResponse());
//    连续请求延迟服务两次，使其触发失败阈值
    log.info(monitoringService.delayServiceResponse());
    log.info(monitoringService.delayServiceResponse());
//  在触发延迟服务失败阈值之后，查看延迟服务断路器的状态，发现他是打开的
    log.info(delayedCircuitBreaker.getState());
//    与此同时，延迟服务关闭，开始请求 快速服务
    log.info(monitoringService.quicklyServiceResponse());
    log.info(quickCircuitBreaker.getState());
//  等待这个延时服务变成能够响应
    try {
      log.info("Waiting for delayed service to become responsive");
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    查看延迟服务断路器的状态，此时它应该是半开的状态
    log.info(delayedCircuitBreaker.getState());
//    请求延迟服务
    log.info(monitoringService.delayServiceResponse());
//    As successful response is fetched ,it should be CLOSED again；当存在成功响应的时候，断路器应该设置关闭
    log.info(delayedCircuitBreaker.getState());
  }

}
