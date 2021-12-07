package com;

/**
 * OrcKing makes request that are handled by the chain
 */
public class OrcKing {

  private RequestHandler chain;


  public OrcKing () {
    buildChain();
  }

  private void buildChain () {
    chain = new OcrCommander(new OrcOfficer(new OrcSoldier(null)));
  }

  public void makeRequest(Request req){
    chain.handleRequest(req);
  }
}
