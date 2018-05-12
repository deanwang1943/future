package com.system.future.service;

import java.util.List;

/**
 * Common Server
 * @param <T>
 */
public interface BaseService<T> {
    List<T> listAll();

    T get(Long id);

    void save(T record);

    void delete(Long id);

    void update(T record, Long id);
}
