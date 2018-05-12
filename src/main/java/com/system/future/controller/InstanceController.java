package com.system.future.controller;

import com.system.future.entity.InstanceDO;
import com.system.future.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instance")
@Slf4j
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Get Instance by id:" + id);
        }
        instanceService.get(id);
    }

    @GetMapping("/listAll")
    public void listAll() {
        instanceService.listAll();
    }

    @PostMapping("/add")
    public void add(InstanceDO record) {
        instanceService.save(record);
    }

    @PostMapping("/{id}")
    public void update(InstanceDO record,@PathVariable("id") Long id) {
        instanceService.update(record, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        instanceService.delete(id);
    }
}
