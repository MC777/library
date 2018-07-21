package pl.sda.repository;

import pl.sda.module.Book;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:22
 **/
public interface IBookRepository {

    void save(Book book) throws IOException;
}
