package com.marshall.sky.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  public static Object getObject(String id) {
    Object object = null;
    object = applicationContext.getBean(id);
    return object;
  }

  public static <T> T getObject(Class<T> tClass) {
    return applicationContext.getBean(tClass);
  }

  public static Object getBean(String tClass) {
    return applicationContext.getBean(tClass);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContextParam) {
    applicationContext = applicationContextParam;
  }

  public <T> T getBean(Class<T> tClass) {
    return applicationContext.getBean(tClass);
  }
}