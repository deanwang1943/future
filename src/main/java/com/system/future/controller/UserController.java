package com.system.future.controller;

import com.system.future.entity.UserDO;
import com.system.future.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Get User by id:" + id);
        }
        userService.get(id);
    }

    @GetMapping("/listAll")
    public void listAll() {
        userService.listAll();
    }

    @PostMapping("/add")
    public void add(UserDO record) {
        userService.save(record);
    }

    @PostMapping("/{id}")
    public void update(UserDO record, @PathVariable("id") Long id) {
        userService.update(record, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
