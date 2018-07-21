package pl.sda.service;

import pl.sda.module.Book;
import pl.sda.repository.BookRepository;
import pl.sda.repository.IBookRepository;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:52
 **/
public class BookService implements IBookService{

    private IBookRepository bookRepository = new BookRepository();

    @Override
    public void save(Book book) throws IOException {
        bookRepository.save(book);
    }

}
