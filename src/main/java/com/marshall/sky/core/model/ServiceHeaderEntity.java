package com.marshall.sky.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * header实体
 *
 * @author wangruigang
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ServiceHeaderEntity {
    Long userId;

    String token;

    Long logId;

}
