package com.marshall.sky.core.token.user;

import com.marshall.sky.core.enums.RoleEnum;
import com.marshall.sky.core.enums.StatusEnum;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : livE
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {

  Long id;
  Long userId;
  RoleEnum roleType;
  StatusEnum status;
  Date createAt;

}
