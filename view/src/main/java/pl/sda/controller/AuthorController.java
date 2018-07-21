package pl.sda.controller;

import pl.sda.module.Author;
import pl.sda.service.AuthorService;
import pl.sda.service.IAuthorService;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 12:26
 **/
public class AuthorController {

    private IAuthorService authorService = new AuthorService();

    public void save(String firstName, String lastName, String placeOfBirth) throws IOException {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setPlaceOfBirth(placeOfBirth);
        authorService.save(author);
    }
}
