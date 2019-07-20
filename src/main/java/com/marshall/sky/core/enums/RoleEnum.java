package com.marshall.sky.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : livE
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {
  NONE(0),
  PM(1),
  ADMIN(2);

  int index;
}
