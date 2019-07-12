package com.marshall.sky.core.token.user;

import com.marshall.sky.core.enums.GenderEnum;
import com.marshall.sky.core.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

  Long userId;
  String nickName;
  GenderEnum gender;
  StatusEnum status;
  Long createAt;
  Long avatarId;
}
