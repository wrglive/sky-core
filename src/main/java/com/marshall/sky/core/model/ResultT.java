package com.marshall.sky.core.model;

import com.marshall.sky.core.enums.ResultEnum;
import lombok.Data;

/**
 * @author : livE
 */
@Data
public class ResultT<T> {

  private T data;
  private String msg;
  private String result;
  private Integer code;

  private ResultT(T data, String msg, String result, Integer code) {
    this.data = data;
    this.msg = msg;
    this.result = result;
    this.code = code;
  }

  public static <K> ResultT<K> isSuccess(K data, String msg, Integer code) {
    return new ResultT(data, msg, ResultEnum.SUCCESS.getCode(), code);
  }

  public static <K> ResultT<K> isFailure(K data, String msg, Integer code) {
    return new ResultT(data, msg, ResultEnum.FAILURE.getCode(), code);
  }
}
