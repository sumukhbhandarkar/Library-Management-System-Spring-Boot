package com.developer.sumukh.lms.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private Integer userId;

    @NotNull
    private String userName;
    @NotNull
    private String userPhone;
    @NotNull
    private String userEmail;

    private Integer userBookCount;
}
