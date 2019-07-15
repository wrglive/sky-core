package com.marshall.sky.core.token.user;

import com.marshall.sky.core.enums.GenderEnum;
import com.marshall.sky.core.enums.StatusEnum;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface BaseUserMapper {

  @Select("select * from user_info where user_id = #{userId}")
  @Results({
      @Result(property = "gender", column = "gender", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = GenderEnum.class),
      @Result(property = "status", column = "status", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = StatusEnum.class)
  })
  UserInfo getById(long userId);
}
