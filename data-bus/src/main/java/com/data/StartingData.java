package com.data;

import java.time.LocalDateTime;

import com.AbstractDataType;
import com.DataType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * An event raised when applications starts,containing the start of the application
 */
@Getter
@RequiredArgsConstructor
public class StartingData extends AbstractDataType {

  private final LocalDateTime when;

  public static DataType of (final LocalDateTime when) {
    return new StartingData(when);
  }

}
