package com;

/**
 * Members receive events from the Data-bus
 */
public interface Member {

  void accept (DataType event);

}
