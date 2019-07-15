package com.marshall.sky.core.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {


  public static String buildToken(long userId, long createAt) {
    String token = JWT.create().withAudience(String.valueOf(userId))
        .sign(Algorithm.HMAC256(String.valueOf(createAt)));
    return token == null ? "" : token;
  }

  public static void main(String[] args) {
    System.out.println(buildToken(1563037249943001L, 1563037249943L));
  }

}
