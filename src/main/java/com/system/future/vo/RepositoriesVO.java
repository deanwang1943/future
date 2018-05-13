package com.system.future.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RepositoriesVO implements Serializable {
    private String name;
    private Long projectId;
    private String gitUrl;
    private Long sshKeyId;
}
