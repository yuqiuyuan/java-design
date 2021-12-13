package com.customer;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerResource {

  private final List<CustomerDto> customers;

  public List<CustomerDto> getCustomers () {
    return customers;
  }

  public void save (CustomerDto customer) {
    customers.add(customer);
  }

  public void delete (String customerId) {
    customers.removeIf(customerDto -> customerDto.getId().equals(customerId));
  }
}
