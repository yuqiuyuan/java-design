package com;

public class Request {

  private final RequestType requestType;
  private final String requestDescription;
  private boolean handled;

  public Request (RequestType requestType, String requestDescription) {
    this.requestType = requestType;
    this.requestDescription = requestDescription;
  }

  public String getRequestDescription () {
    return requestDescription;
  }

  public RequestType getRequestType () {
    return requestType;
  }

  public void markHandled () {
    this.handled = true;
  }

  public boolean isHandled () {
    return this.handled;
  }

  @Override
  public String toString () {
    return getRequestDescription();
  }
}
