package com;

/**
 * OrcSoldier
 */
public class OrcSoldier extends RequestHandler {

  public OrcSoldier (RequestHandler next) {
    super(next);
  }

  @Override
  public void handleRequest (Request req) {
    if (RequestType.COLLECT_TAX == req.getRequestType()) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString () {
    return "Orc soldier";
  }
}
