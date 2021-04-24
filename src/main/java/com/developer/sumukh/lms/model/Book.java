package com.developer.sumukh.lms.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    private int bookId;

    private String bookTitle;
    private String bookAuthor;
    private String bookGenre;
    private String bookTags;
}
