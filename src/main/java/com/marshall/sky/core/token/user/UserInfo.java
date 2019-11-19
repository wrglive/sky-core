package com.marshall.sky.core.token.user;

import com.marshall.sky.core.enums.GenderEnum;
import com.marshall.sky.core.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

  private Long userId;

  private String openId;

  private String mobile;

  private String nickName;

  private GenderEnum gender;

  private String avatarId;

  private Long createAt;

  private Date updateTime;

  private StatusEnum status;
}
