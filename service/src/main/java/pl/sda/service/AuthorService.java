package pl.sda.service;

import pl.sda.module.Author;
import pl.sda.repository.AuthorRepository;
import pl.sda.repository.IAuthorRepository;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:51
 **/
public class AuthorService implements IAuthorService{

    private IAuthorRepository authorRepository = new AuthorRepository();

    @Override
    public void save(Author author) throws IOException {
        authorRepository.save(author);
    }
}
