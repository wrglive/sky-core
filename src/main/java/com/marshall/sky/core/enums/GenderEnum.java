package com.marshall.sky.core.enums;

public enum GenderEnum {
  MAN(1),
  WOMEN(2);

  int index;

  GenderEnum(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
