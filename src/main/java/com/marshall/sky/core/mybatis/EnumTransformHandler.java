package com.marshall.sky.core.mybatis;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class EnumTransformHandler<T> extends BaseTypeHandler<T> {

  private Class<T> type;

  /**
   * 构造函数<br>
   */
  public EnumTransformHandler(Class<T> type) {
    this.type = type;
  }

  @Override
  public T getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
    int value = rs.getInt(columnName);
    if (rs.wasNull()) {
      return null;
    } else {
      return convertToEnum(value);
    }
  }

  @Override
  public T getNullableResult(ResultSet rs, int columnIndex)
      throws SQLException {
    int value = rs.getInt(columnIndex);
    if (rs.wasNull()) {
      return null;
    } else {
      return convertToEnum(value);
    }
  }

  @Override
  public T getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    // 数据库中存储int类型
    int value = cs.getInt(columnIndex);
    if (cs.wasNull()) {
      return null;
    } else {
      return convertToEnum(value);
    }
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, T param,
      JdbcType jdbcType) throws SQLException {
    Method method;
    int index;
    try {
      method = param.getClass().getDeclaredMethod("getIndex");
      index = (int) method.invoke(param);
    } catch (Exception e) {
      throw new RuntimeException("the enum" + param + "not getIndex method!");
    }
    ps.setInt(i, index);
  }

  private T convertToEnum(int value) {

    T[] iEnums = type.getEnumConstants();
    for (T iEnum : iEnums) {
      Method method;
      int index;
      try {
        method = iEnum.getClass().getDeclaredMethod("getIndex");
        index = (int) method.invoke(iEnum);
      } catch (Exception e) {
        throw new RuntimeException("the enum " + iEnum + " not getIndex method!");
      }
      if (index == value) {
        return iEnum;
      }
    }
    return null;
  }

}
