package com.marshall.sky.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : livE
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {

  SUCCESS(1, "success"),
  FAILURE(-1, "failure");

  int index;
  String code;
}
