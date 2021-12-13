package com.product;

import lombok.Getter;

/**
 * {@link Product} is a entity class for product entity.This class act as entity in the demo
 */
@Getter
public class Product {

  private Long id;
  private String name;
  private Double price;
  private Double cost;
  private String supplier;

  public Product (Long id, String name, Double price, Double cost, String supplier) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.cost = cost;
    this.supplier = supplier;
  }

  public Product () {
  }

  public Product setId (Long id) {
    this.id = id;
    return this;
  }

  public Product setName (String name) {
    this.name = name;
    return this;
  }

  public Product setPrice (Double price) {
    this.price = price;
    return this;
  }

  public Product setCost (Double cost) {
    this.cost = cost;
    return this;
  }

  public Product setSupplier (String supplier) {
    this.supplier = supplier;
    return this;
  }

}
