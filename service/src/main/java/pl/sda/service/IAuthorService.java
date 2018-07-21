package pl.sda.service;

import pl.sda.module.Author;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:51
 **/
public interface IAuthorService {

    void save(Author author) throws IOException;

}
