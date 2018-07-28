package pl.sda.module;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Created by MCK on 21.07.2018 12:42
 **/
@Getter
@Setter
@ToString
public class Book {

    private Long bookId;
    private Long authorId;
    private String title;
    private LocalDate release;
    private String isbn;
    private String authorName;
    private BooksType bookType;
    private Integer pages;
    private boolean isBorrow;
    private String borrowerName;
    private String summary;

    public Book() {

    }

    public Book(Long bookId, String title, LocalDate relase, String isbn, String authorName, BooksType bookType, Integer pages, String summary) {
        this.bookId = bookId;
        this.title = title;
        this.release = relase;
        this.isbn = isbn;
        this.authorName = authorName;
        this.bookType = bookType;
        this.pages = pages;
        this.summary = summary;
    }

    public Book(Long bookId, String title, LocalDate relase, String isbn, String authorName, BooksType bookType, Integer pages, String summary, boolean isBorrow) {
        this.bookId = bookId;
        this.title = title;
        this.release = relase;
        this.isbn = isbn;
        this.authorName = authorName;
        this.bookType = bookType;
        this.pages = pages;
        this.summary = summary;
        this.isBorrow = isBorrow;
    }

    public Book(Long bookId) {
        this.bookId = bookId;
    }
}
