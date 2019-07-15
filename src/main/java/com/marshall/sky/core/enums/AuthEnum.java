package com.marshall.sky.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : livE
 */
@Getter
@AllArgsConstructor
public enum AuthEnum {
  NONE(1),
  PM(2),
  ADMIN(3);

  int index;
}
