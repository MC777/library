package pl.sda.controller;

import pl.sda.module.Book;
import pl.sda.module.BooksType;
import pl.sda.service.BookService;
import pl.sda.service.IBookService;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by MCK on 21.07.2018 14:09
 **/

public class BookController {

    private IBookService bookService = new BookService();

    public void save(String title, LocalDate release, String isbn, String authorName, BooksType type, Integer pages, String summary) throws IOException {
        Book book = new Book();
        //book.setAuthorId(authorId);
        book.setTitle(title);
        book.setRelease(release);
        book.setIsbn(isbn);
        book.setAuthorName(authorName);
        book.setBookType(type);
        book.setPages(pages);
        //book.setBorrowerName(borrowerName);
        book.setSummary(summary);
        bookService.save(book);
    }

    public void deleteBook(Long bookId) throws IOException{
        bookService.deleteBook(bookId);
    }

    public void readBooks() throws IOException{
        bookService.readBooks();
    }

    public void readAvailableBooks() throws IOException{
        bookService.readAvailableBooks();
    }

    public void readBooks(Long bookId) throws IOException{
        bookService.readBooks(bookId);
    }

    public void editBook(Book book) throws IOException{
        bookService.editBook(book);
    }

    public Book getBook(Long bookId) throws IOException {
        return bookService.getBook(bookId);
    }

    public void updateBookFlag(Long bookId, boolean bookFlag) throws IOException{
        bookService.updateBookFlag(bookId,bookFlag);
    }
}
