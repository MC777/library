package pl.sda.repository;

import pl.sda.module.Book;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:22
 **/
public interface IBookRepository {

    void save(Book book) throws IOException;

    void deleteBook(Long bookId) throws IOException;

    void readBooks() throws IOException;

    void readBooks(Long bookId) throws IOException;

    void readAvailableBooks() throws IOException;

    void readBorrowedBooks() throws IOException;

    Book getBook(Long bookId) throws IOException;

    void editBook(Book book) throws IOException;

    void updateBookFlag(Long bookId, boolean bookFlag) throws IOException;

}
