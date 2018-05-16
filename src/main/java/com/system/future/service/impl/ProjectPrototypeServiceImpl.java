package com.system.future.service.impl;

import com.system.future.domain.ProjectPrototype;
import com.system.future.service.ProjectPrototypeService;
import org.springframework.stereotype.Service;

@Service("projectPrototypeService")
public class ProjectPrototypeServiceImpl implements ProjectPrototypeService {
    @Override
    public Iterable<ProjectPrototype> findAll() {
        return null;
    }
}
