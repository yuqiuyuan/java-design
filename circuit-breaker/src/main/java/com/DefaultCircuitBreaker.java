package com;

public class DefaultCircuitBreaker implements CircuitBreaker {

  private final long timeout;
  private final long retryTimePeriod;
  private final RemoteService remoteService;
  long lastFailureTime;
  private String lastFailureResponse;
  int failureCount;
  private final int failureThreshold;
  private State state;
  private final long futureTime = 1000 * 1000 * 1000 * 1000;

  public DefaultCircuitBreaker (long timeout, long retryTimePeriod, RemoteService remoteService, int failureThread) {
    this.timeout = timeout;
    this.retryTimePeriod = retryTimePeriod;
    this.remoteService = remoteService;
    this.failureThreshold = failureThread;
    this.state = State.CLOSED;
    this.failureCount = 0;
    this.lastFailureTime = System.nanoTime() + futureTime;
  }

  //  Reset everything to default
  @Override
  public void recordSuccess () {
    this.failureCount = 0;
    this.lastFailureTime = System.nanoTime() + futureTime;
    this.state = State.CLOSED;
  }

  @Override
  public void recordFailure (String response) {
    failureCount++;
    this.lastFailureTime = System.nanoTime();
    this.lastFailureResponse = response;
  }

  @Override
  public String getState () {
    evaluateState();
    return state.name();
  }

  protected void evaluateState () {
    if (failureCount >= failureThreshold) {
      if ((System.nanoTime() - lastFailureTime) > retryTimePeriod) {
        state = State.HALF_OPEN;
      } else {
//        Service would still probably be down
        state = State.OPEN;
      }
    } else {
//      Everything is working fine
      state = State.CLOSED;
    }
  }

  /**
   * Break the circuit beforehand if it is known service is dowm Or connect the circuit manually if service comes online before expected.
   *
   * @param state State at which circuit is in
   */
  @Override
  public void setState (State state) {
    this.state = state;
    switch (state) {
      case OPEN:
        this.failureCount = failureThreshold;
        this.lastFailureTime = System.nanoTime();
        break;
      case HALF_OPEN:
        this.failureCount = failureThreshold;
        this.lastFailureTime = System.nanoTime() - retryTimePeriod;
        break;
      default:
        this.failureCount = 0;
    }
  }

  @Override
  public String attemptRequest () throws RemoteServiceException {
    evaluateState();
    if (state == State.OPEN) {
      return this.lastFailureResponse;
    } else {
      try {
//        In a real application,this would be run in a thread and the timeout parameter of the circuit breaker would be utilized to know if service is working.
//        Here,we simulate that based on server response itself
        final String call = remoteService.call();
//        Yay!! the API responded fine.let's reset everything.
        recordSuccess();
      } catch (RemoteServiceException ex) {
        recordFailure(ex.getMessage());
        throw ex;
      }
    }
    return null;
  }
}
