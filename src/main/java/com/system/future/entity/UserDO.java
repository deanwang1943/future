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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDO implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String email;

    private String password;

    private Date createDate;
}
