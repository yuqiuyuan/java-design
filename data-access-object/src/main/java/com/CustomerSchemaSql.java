package com;

import java.security.PublicKey;

/**
 * Customer Schema SQL Class
 */
public class CustomerSchemaSql {

  public CustomerSchemaSql () {
  }

  public static final String CREATE_SCHEMA_SQL = "CREATE TABLE CUSTOMERS (ID NUMBER,F_NAME VARCHAR(100), L_NAME VARCHAR(100))";

  public static final String DELETE_SCHEMA_SQL = "DROP TABLE CUSTOMER";

}
