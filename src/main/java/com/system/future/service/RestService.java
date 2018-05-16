package com.system.future.service;

import com.system.future.domain.Demoable;
import io.katharsis.resource.list.ResourceList;

import java.util.List;

public interface RestService {
    List<Demoable> findAll();
}
