package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DbCustomerDao implements CustomerDao {

  private final DataSource dataSource;

  @Override
  public Stream<Customer> getAll () throws Exception {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER");// NOSONAR
    ResultSet resultSet = preparedStatement.executeQuery();
//    return StreamSupport.stream(new Spliterators.AbstractSpliterator<Customer>(Long.MAX_VALUE, Spliterator.ORDERED));
    return null;
  }

  @Override
  public Optional<Customer> getById (int id) throws Exception {
    return Optional.empty();
  }

  @Override
  public boolean add (Customer customer) throws Exception {
    return false;
  }

  @Override
  public boolean update (Customer customer) throws Exception {
    return false;
  }

  @Override
  public boolean delete (Customer customer) throws Exception {
    try (Connection connection = getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE ID = ?")) {
      preparedStatement.executeQuery();
    } catch (Exception e) {
    }
    return false;
  }

  private Connection getConnection () throws SQLException {
    return dataSource.getConnection();
  }
}
