package com.system.future.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateVO implements Serializable {
    private Long id;
    private Long sshKeyId;
    private Long projectId;
    private Long inventoryId;
    private Long repositoryId;
    private Long environmentId;
    private String alias;
    private String playbook;
    private String arguments;
    private Boolean overrideArgs;
}
