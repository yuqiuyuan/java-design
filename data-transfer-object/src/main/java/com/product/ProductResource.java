package com.product;

import java.util.List;
import java.util.stream.Collectors;

import com.product.ProductDto.Response.*;

/**
 * The resource class which serves products information.This class act as server in the demo.Which has all product details.
 */
public class ProductResource {

  private final List<Product> products;

  public ProductResource (List<Product> products) {
    this.products = products;
  }

  public List<ProductDto.Response.Private> getAllProductsForAdmin () {
    return products.stream().map(p -> new Private().setId(p.getId()).setName(p.getName()).setCost(p.getCost()).setPrice(p.getPrice()))
        .collect(
            Collectors.toList());
  }

  public List<ProductDto.Response.Public> getAllProductsForCustomer () {
    return products.stream().map(p -> new Public().setId(p.getId()).setPrice(p.getPrice()).setName(p.getName())).collect(Collectors.toList());
  }

  public void save (ProductDto.Request.Create createProductDto) {
    products.add(new Product().setId((long) (products.size() + 1)).setName(createProductDto.getName()).setPrice(createProductDto.getPrice()).setCost(
        createProductDto.getCost()));
  }

  public List<Product> getProducts () {
    return products;
  }
}
