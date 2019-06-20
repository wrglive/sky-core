package com.marshall.sky.core.test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseServiceTest {

  public BaseServiceTest() {
  }

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }
}
