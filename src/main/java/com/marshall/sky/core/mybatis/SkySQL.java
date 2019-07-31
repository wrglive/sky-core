package com.marshall.sky.core.mybatis;

/**
 * ibatis的SQL改进版 新增一个简单的LIMIT以便于分页, 但是生成的provider都必须 用他来实现。
 *
 * @author : livE
 */
public class SkySQL extends AbstractSkySQL<SkySQL> {

  @Override
  public SkySQL getSelf() {
    return this;
  }

}
