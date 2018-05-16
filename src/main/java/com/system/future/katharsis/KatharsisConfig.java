package com.system.future.katharsis;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RestController
@Import(KatharsisConfigV3.class)
public class KatharsisConfig {
    @Autowired
    private ResourceRegistry resourceRegistry;

    @RequestMapping("/resourcesInfo")
    public Map<?, ?> getResources() {
        Map<String, String> result = new HashMap<>();
        // Add all resources (i.e. Project and Task)
        for (RegistryEntry entry : resourceRegistry.getResources().values()) {
            result.put(entry.getResourceInformation().getResourceType(), resourceRegistry.getResourceUrl(entry.getResourceInformation().getResourceClass()));
        }
        return result;
    }
}
