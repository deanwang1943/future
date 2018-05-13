package com.system.future.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeyVO implements Serializable {

    private String name;
    private String type;
    private String key;
    private String secret;
    private Long projectId;
}
