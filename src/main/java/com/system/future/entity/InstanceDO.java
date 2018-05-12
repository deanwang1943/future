package com.system.future.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstanceDO implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date createDate;

    private String userName;

    private String serverIP;

    private String serverUser;

    private String serverPrivateKey;

    private Long projectId;

    private String remark;
}
