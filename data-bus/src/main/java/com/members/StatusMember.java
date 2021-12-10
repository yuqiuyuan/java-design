package com.members;

import java.time.LocalDateTime;

import com.DataType;
import com.Member;
import com.data.MessageData;
import com.data.StartingData;
import com.data.StoppingData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Receiver of Data-Bus events.
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public class StatusMember implements Member {

  private final int id;
  private LocalDateTime started;
  private LocalDateTime stopped;

  @Override
  public void accept (DataType data) {
    if (data instanceof StartingData) {
      handleEvent((StartingData) data);
    } else if (data instanceof StoppingData) {
      handleEvent((StoppingData) data);
    }
  }

  private void handleEvent (StartingData data) {
    started = data.getWhen();
    log.info("Receiver {} sees application started at {}", id, started);
  }

  private void handleEvent (StoppingData data) {
    stopped = data.getWhen();
    log.info("Receiver {} sees application stopping at {}", id, stopped);
    log.info("Receiver {} seeding goodbye message ", id);
    data.getDataBus().publish(MessageData.of(String.format("Goodbye cruel world from #%d!", id)));
  }
}
