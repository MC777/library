package pl.sda.service;

import pl.sda.module.Book;
import pl.sda.repository.BookRepository;
import pl.sda.repository.IBookRepository;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by MCK on 21.07.2018 10:52
 **/
public class BookService implements IBookService{

    private IBookRepository bookRepository = new BookRepository();

    @Override
    public void save(Book book) throws IOException {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) throws IOException {
        bookRepository.deleteBook(bookId);
        System.err.println("[Book has been deleted] Id: " + bookId);
    }

    @Override
    public void readBooks() throws IOException {
        bookRepository.readBooks();
    }

    @Override
    public void readBooks(Long bookId) throws IOException {
        bookRepository.readBooks(bookId);
    }

    @Override
    public void readAvailableBooks() throws IOException {
        bookRepository.readAvailableBooks();
    }

    @Override
    public Book getBook(Long bookId) throws IOException {
        return  bookRepository.getBook(bookId);
    }


    @Override
    public void editBook(Book book) throws IOException {
        bookRepository.editBook(book);
    }

}
