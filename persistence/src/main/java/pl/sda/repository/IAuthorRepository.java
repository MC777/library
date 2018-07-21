package pl.sda.repository;

import pl.sda.module.Author;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:23
 **/
public interface IAuthorRepository {

    void save(Author author) throws IOException;


}
