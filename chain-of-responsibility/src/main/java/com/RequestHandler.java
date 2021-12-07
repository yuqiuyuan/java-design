package com;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public abstract class RequestHandler {

  private final RequestHandler next;

  public void handleRequest (Request req) {
    if (null != next) {
      next.handleRequest(req);
    }
  }

  protected void printHandling (Request req) {
    log.info("{} handling request {}", this, req);
  }

  @Override
  public abstract String toString ();
}
