package com.system.future.katharsis.repository;

import com.system.future.domain.ProjectPrototype;
import com.system.future.service.ProjectPrototypeService;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProjectPrototypeRepositoryImpl extends ResourceRepositoryBase<ProjectPrototype, Long> {

    @Autowired
    @Qualifier("projectPrototypeService")
    private ProjectPrototypeService projectPrototypeService;

    public ProjectPrototypeRepositoryImpl() {
        super(ProjectPrototype.class);
    }

    @Override
    public ResourceList<ProjectPrototype> findAll(QuerySpec querySpec) {
        return querySpec.apply(projectPrototypeService.findAll());
    }
}