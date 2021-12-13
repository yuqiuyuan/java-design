package com.product;

/**
 * {@link ProductDto} is a data transfer object POJO. Instead of sending individual information to client We can send related information together in POJO.
 */
public enum ProductDto {
  ;

  public enum Request {
    ;

    /**
     * This is create dto class for requesting create new product
     */
    public static final class Create implements Name, Price, Cost, Supplier {

      private String name;
      private Double price;
      private Double cost;
      private String supplier;


      public Create setName (String name) {
        this.name = name;
        return this;
      }

      public Create setPrice (Double price) {
        this.price = price;
        return this;
      }

      public Create setCost (Double cost) {
        this.cost = cost;
        return this;
      }

      public Create setSupplier (String supplier) {
        this.supplier = supplier;
        return this;
      }

      @Override
      public String getName () {
        return this.name;
      }

      @Override
      public Double getPrice () {
        return this.price;
      }

      @Override
      public Double getCost () {
        return this.cost;
      }

      @Override
      public String getSupplier () {
        return this.supplier;
      }
    }
  }

  public enum Response {
    ;

    /**
     * This is Public dto class for API response with the lowest data security.`
     */
    public static final class Public implements Id, Name, Price {

      private Long id;
      private String name;
      private Double price;

      public Public setId (Long id) {
        this.id = id;
        return this;
      }

      public Public setName (String name) {
        this.name = name;
        return this;
      }

      public Public setPrice (Double price) {
        this.price = price;
        return this;
      }

      @Override
      public Long getId () {
        return this.id;
      }

      @Override
      public String getName () {
        return this.name;
      }

      @Override
      public Double getPrice () {
        return this.price;
      }
    }

    public static final class Private implements Id, Name, Price, Cost {

      private Long id;
      private String name;
      private Double price;
      private Double cost;

      public Private setId (Long id) {
        this.id = id;
        return this;
      }

      public Private setName (String name) {
        this.name = name;
        return this;
      }

      public Private setPrice (Double price) {
        this.price = price;
        return this;
      }

      public Private setCost (Double cost) {
        this.cost = cost;
        return this;
      }

      @Override
      public Long getId () {
        return this.id;
      }

      @Override
      public String getName () {
        return this.name;
      }

      @Override
      public Double getPrice () {
        return this.price;
      }

      @Override
      public Double getCost () {
        return this.cost;
      }

      @Override
      public String toString () {
        return "Private{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", cost=" + cost +
            '}';
      }
    }

  }

  /**
   * Use this interface whenever you want to provide the product Id in your DTO.
   */
  private interface Id {

    /**
     * Unique identifier of the product
     *
     * @return : id of the product
     */
    Long getId ();
  }

  private interface Name {

    String getName ();
  }

  private interface Price {

    Double getPrice ();
  }

  private interface Cost {

    Double getCost ();
  }

  private interface Supplier {

    String getSupplier ();
  }
}
