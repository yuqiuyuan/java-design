package com;

public class OcrCommander extends RequestHandler {

  public OcrCommander (RequestHandler next) {
    super(next);
  }

  @Override
  public void handleRequest (Request req) {
    if (RequestType.DEFEND_CASTLE == req.getRequestType()) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString () {
    return "orc commander";
  }
}
