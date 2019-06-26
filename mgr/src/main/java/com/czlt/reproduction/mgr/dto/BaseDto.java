package com.czlt.reproduction.mgr.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDto implements Serializable {
    private Integer start = 0;
    private Integer size = 1;
}
