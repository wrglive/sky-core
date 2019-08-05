package com.marshall.sky.core.token.user;

import com.marshall.sky.core.enums.GenderEnum;
import com.marshall.sky.core.enums.RoleEnum;
import com.marshall.sky.core.enums.StatusEnum;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

public interface UserAuthMapper {

  @Select("select * from user_info where user_id = #{userId}")
  @Results({
      @Result(property = "gender", column = "gender", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = GenderEnum.class),
      @Result(property = "status", column = "status", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = StatusEnum.class)
  })
  @Cacheable(value = "user-info", key = "#userId")
  UserInfo getById(long userId);

  @Select("select * from user_role where user_id = #{userId}")
  @Results({
      @Result(property = "roleType", column = "role_type", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = RoleEnum.class),
      @Result(property = "status", column = "status", typeHandler = com.marshall.sky.core.mybatis.EnumTransformHandler.class, javaType = StatusEnum.class)
  })
  List<UserRole> listUserRoleByUserId(long userId);

}
