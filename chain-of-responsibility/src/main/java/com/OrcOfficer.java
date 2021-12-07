package com;

public class OrcOfficer extends RequestHandler {

  public OrcOfficer (RequestHandler handler) {
    super(handler);
  }

  @Override
  public void handleRequest (Request req) {
    if (RequestType.TORTURE_PRISONER == req.getRequestType()) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString () {
    return "orc officer";
  }
}
