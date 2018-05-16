package com.system.future.katharsis.repository;

import com.system.future.domain.Demoable;
import com.system.future.service.RestService;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gzhang061 on 5/15/18.
 */
@Component
public class DemoableRepositoryImpl extends ResourceRepositoryBase<Demoable, Long> {

    @Autowired
    private RestService restService;

    public DemoableRepositoryImpl() {
        super(Demoable.class);
    }

    @Override
    public <S extends Demoable> S create(S resource) {
        resource.setId(0L);
//        System.out.println(resource.getServerKey());

        return resource;
    }

    @Override
    public ResourceList<Demoable> findAll(QuerySpec querySpec) {
        return querySpec.apply(restService.findAll());
    }
}