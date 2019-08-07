package com.marshall.sky.core.mybatis;

/**
 * @author : livE
 */
public class BaseExample {

  protected Integer offset;

  protected Integer limit;


  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }
}
