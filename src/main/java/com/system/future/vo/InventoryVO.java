package com.system.future.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryVO implements Serializable {

    private String name;
    private String inventory;
    private Long keyId;
    private Long sshKeyId;
    private Long projectId;
    private String type;
}
