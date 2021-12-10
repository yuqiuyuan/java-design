package com.members;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@Getter
@Slf4j
@RequiredArgsConstructor
public class MessageCollectorMember implements Member {

  private final String name;
  private final List<String> message = new ArrayList<>();


  @Override
  public void accept (DataType event) {
    if (event instanceof MessageData) {
      handleEvent((MessageData) event);
    }
  }

  private void handleEvent (MessageData event) {
    log.info("{} sees message {}", name, event.getMessage());
    message.add(event.getMessage());
  }

  public List<String> getMessages () {
    return List.copyOf(message);
  }
}
