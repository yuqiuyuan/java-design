package com;

public class DelayedRemoteService implements RemoteService {

  private final long serverStartTime;
  private final int delay;

  public DelayedRemoteService (long serverStartTime, int delay) {
    this.serverStartTime = serverStartTime;
    this.delay = delay;
  }

  public DelayedRemoteService () {
    this.serverStartTime = System.nanoTime();
    this.delay = 20;
  }

  @Override
  public String call () throws RemoteServiceException {
    long currentTime = System.nanoTime();
    if ((currentTime - serverStartTime) * 1.0 / (1000 * 1000 * 1000) < delay) {
      throw new RemoteServiceException("Delayed service is down");
    }
    return "Delayed service is working";
  }
}
