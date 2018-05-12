package com.system.future.dao;

import com.system.future.entity.InstanceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstanceDao extends JpaRepository<InstanceDO, Long> {

    List<InstanceDO> findByServerIP(String serverIP);
}
