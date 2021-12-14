package com;

/**
 * The remote service interface,used bu {@link CircuitBreaker} for fetching response from remote services
 */
public interface RemoteService {

  String call() throws RemoteServiceException;

}
