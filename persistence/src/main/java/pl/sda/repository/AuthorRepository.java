package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.module.Author;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:26
 **/
public class AuthorRepository implements IAuthorRepository {

    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/authors/authors.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public void save(Author author) throws IOException {
        //List<Author> authors = new ArrayList<>();
        List<Author> authors = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Author>>() {
        });
        Long nextId = Long.valueOf(authors.size() + 1);
        author.setAuthorId(nextId);
        authors.add(author);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), authors);
    }
}