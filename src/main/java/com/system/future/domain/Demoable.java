package com.system.future.domain;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;

/**
 * Created by gzhang061 on 5/15/18.
 */
@JsonApiResource(type = "demoables")
@Data
public class Demoable {

    @JsonApiId
    private Long id;

    private Long projectId;

    private String taskId;

    private String serverEndpoint;

    private String serverKey;

    private String serverOS;

    private String serverUser;
}
