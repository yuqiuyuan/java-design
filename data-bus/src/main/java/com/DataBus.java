package com;

import java.util.HashSet;
import java.util.Set;

public class DataBus {

  private static final DataBus INSTANCE = new DataBus();
  private final Set<Member> listener = new HashSet<>();

  public static DataBus getInstance () {
    return INSTANCE;
  }

  public void subscribe (final Member member) {
    this.listener.add(member);
  }

  public void unsubscribe(final Member member){
    this.listener.remove(member);
  }

  public void publish(final DataType data){
    data.setDataBus(this);
    listener.forEach(listener->listener.accept(data));
  }
}
