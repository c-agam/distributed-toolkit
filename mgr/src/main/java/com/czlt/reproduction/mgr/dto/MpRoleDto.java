package com.czlt.reproduction.mgr.dto;

import lombok.Data;

@Data
public class MpRoleDto extends BaseDto {
    private String rolename;
    private Integer locked;
}
