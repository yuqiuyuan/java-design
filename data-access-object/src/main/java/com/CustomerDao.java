package com;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * In an application the Data Access Object (DAO) is a part of Data access layer. It is an object that provides an interface to some type of persistence
 * mechanism. By mapping application calls to the persistence layer,DAO provides some specific data operations without exposing details of the database. This
 * isolation supports the Single responsibility principle. It separates what data accesses the application needs.in terms of domain-specific objects and data
 * types (the public interface of the DAO),from how these can be satisfied with a specific DBMS,database schema ,etc.
 *
 * <p>
 * Any change in the way data is stored and retrieved will not change the client code as the client will be using interface and need not worry about exact
 * source.
 * </p>
 */
public interface CustomerDao {

  /**
   * Get all customers
   *
   * @return all the customers as a stream,The stream may be lazily or eagerly evaluated based on the the implementation. The stream must be closed after use.
   * @throws Exception if any error occur
   */
  Stream<Customer> getAll () throws Exception;

  Optional<Customer> getById (int id) throws Exception;

  boolean add (Customer customer) throws Exception;

  boolean update (Customer customer) throws Exception;

  boolean delete (Customer customer) throws Exception;

}
