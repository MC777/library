package pl.sda.service;

import pl.sda.module.Book;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:14
 **/
public interface IBookService {

    void save(Book book) throws IOException;
}
