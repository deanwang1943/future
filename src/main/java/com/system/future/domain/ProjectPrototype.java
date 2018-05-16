package com.system.future.domain;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;

@JsonApiResource(type = "project-prototypes")
@Data
public class ProjectPrototype {

    @JsonApiId
    private Long id;

    private String name;

    private String owner;

    private String description;

    private String version;

    private Long semaphoreProjectId;

    private Long demoDeploymentTaskId;
}
