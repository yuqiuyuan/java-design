package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.customer.CustomerDto;
import com.customer.CustomerResource;
import com.product.Product;
import com.product.ProductDto.Request.Create;
import com.product.ProductResource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  public static void main (String[] args) {
    final CustomerDto customerOne = new CustomerDto("1", "Kelly", "Brown");
    final CustomerDto customerTwo = new CustomerDto("2", "Alfonso", "Bass");
    final List<CustomerDto> customers = new ArrayList<>(Arrays.asList(customerOne, customerTwo));
    final CustomerResource customerResource = new CustomerResource(customers);
    log.info("All customers:-");
    List<CustomerDto> allCustomers = customerResource.getCustomers();
    printCustomerDetails(allCustomers);
    log.info("------------------------------------------------");
    log.info("Deleting customer with id {1}");
    customerResource.delete(customerOne.getId());
    allCustomers = customerResource.getCustomers();
    printCustomerDetails(allCustomers);
    log.info("------------------------------------------------");
    log.info("Adding customer three");
    final CustomerDto customerThree = new CustomerDto("3", "Lynda", "Blair");
    customerResource.save(customerThree);
    allCustomers = customerResource.getCustomers();
    printCustomerDetails(allCustomers);
//    Example 2: Product DTO
    Product tv = new Product().setId(1L).setName("TV").setSupplier("Sony").setPrice(1000D).setCost(1090D);
    Product microwave = new Product().setId(2L).setName("microwave").setSupplier("Delonghi").setPrice(1000D).setCost(1090D);
    Product refrigerator = new Product().setId(3L).setName("refrigerator").setSupplier("Botsch").setPrice(1000D).setCost(1090D);
    Product airConditioner = new Product().setId(4L).setName("airConditioner").setSupplier("LG").setPrice(1000D).setCost(1090D);

    final ArrayList<Product> products = new ArrayList<>(Arrays.asList(tv, microwave, refrigerator, airConditioner));
    final ProductResource productResource = new ProductResource(products);
    log.info("####### List of products including sensitive data just for admins : \n {}", Arrays.toString(productResource.getAllProductsForAdmin().toArray()));
    log.info("####### List of products for customers: \n {}", Arrays.toString(productResource.getAllProductsForCustomer().toArray()));
    log.info("####### Going to save Sony PS5 ...");
    final Create create = new Create().setName("PS5").setCost(1000D).setPrice(1220D).setSupplier("Sony");
    productResource.save(create);
    log.info("####### List of products after adding PS5:{}", Arrays.toString(productResource.getProducts().toArray()));
  }

  private static void printCustomerDetails (List<CustomerDto> customers1) {
    customers1.forEach(customerDto -> log.info(customerDto.getFirstName()));
  }
}
