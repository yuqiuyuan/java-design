package com;

public class MonitoringService {

  private final CircuitBreaker delayedService;
  private final CircuitBreaker quickService;

  public MonitoringService (CircuitBreaker delayedService, CircuitBreaker quickService) {
    this.delayedService = delayedService;
    this.quickService = quickService;
  }

  /**
   * Assumption: local service won't fail,no need to wrap it in a circuit breaker logic
   *
   * @return response string
   */
  public String localResourceResponse () {
    return "Local service is working";
  }


  /**
   * Fetch response from the delayed service (with some simulated startup time)
   *
   * @return response string
   */
  public String delayServiceResponse () {
    try {
      return this.delayedService.attemptRequest();
    } catch (RemoteServiceException e) {
      return e.getMessage();
    }
  }

  /**
   * Fetches response from a healthy service without any failure
   *
   * @return response string
   */
  public String quicklyServiceResponse () {
    try {
      return this.quickService.attemptRequest();
    } catch (RemoteServiceException e) {
      return e.getMessage();
    }
  }
}
