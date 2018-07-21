package pl.sda.module;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by MCK on 21.07.2018 12:42
 **/
@Getter
@Setter
public class Book {

    private Long bookId;
    private Long authorId;
    private String title;
    private LocalDate release;
    private String isbn;
    private String authorName;
    private BooksType type;
    private Integer pages;
    // private boolean borrow
    private String borrowerName;
    private String summary;
}
