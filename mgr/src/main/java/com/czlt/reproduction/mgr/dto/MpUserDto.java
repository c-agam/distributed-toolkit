package com.czlt.reproduction.mgr.dto;

import lombok.Data;

@Data
public class MpUserDto extends BaseDto {
    private String account;
    private String username;
    private String locked;
}
