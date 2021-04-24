package com.developer.sumukh.lms.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BookIssued {

    @Id
    private Integer bookId;

    @NotNull
    private Integer userId;

    private Integer fine;
    private Date doi;
    private Date dor;

}
