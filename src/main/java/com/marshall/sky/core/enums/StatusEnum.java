package com.marshall.sky.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum StatusEnum {
  OFFLINE(0),
  ONLINE(1),
  ;

  int index;

  public int getIndex() {
    return index;
  }

  StatusEnum(int index) {
    this.index = index;
  }
}
