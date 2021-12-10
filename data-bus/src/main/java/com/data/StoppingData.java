package com.data;

import java.time.LocalDateTime;

import com.AbstractDataType;
import com.DataType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * An event raised when applications stops,containing the stop time of the application.
 */
@Getter
@RequiredArgsConstructor
public class StoppingData extends AbstractDataType {

  private final LocalDateTime when;

  public static DataType of (final LocalDateTime when) {
    return new StoppingData(when);
  }


}
