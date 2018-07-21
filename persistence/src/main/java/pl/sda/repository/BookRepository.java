package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.module.Author;
import pl.sda.module.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:25
 **/
public class BookRepository implements IBookRepository {

    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/books/books.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public void save(Book book) throws IOException {
        //List<Author> authors = new ArrayList<>();
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Author>>() {
        });
        Long nextId = Long.valueOf(books.size() + 1);
        book.setAuthorId(nextId);
        books.add(book);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), books);
    }
}
