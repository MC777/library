package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

    public BookRepository() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public void save(Book book) throws IOException {
        //List<Author> authors = new ArrayList<>();
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });
        Long nextId = Long.valueOf(books.size() + 1);
        book.setBookId(nextId);
        books.add(book);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), books);
    }

    @Override
    public void deleteBook(Long bookId) throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });
        for (Book b : books) {
            if (bookId.equals(b.getBookId())) {
                books.remove(b);
                break;
            }
        }
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), books);
    }

    @Override
    public void readBooks() throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });
        for (Book b : books) {
            System.out.println(b.getBookId() + " - " + b.getTitle() + " | " + b.getRelease() + " | " + b.getIsbn() + " | " + b.getAuthorName() + " | " + b.getBookType() + " | " + b.getPages() + " | " + b.getSummary() + " | " + b.isBorrow());
        }
    }

    @Override
    public void readBooks(Long bookId) throws IOException {

    }

    @Override
    public void readAvailableBooks() throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });
        for (Book b : books) {
            if (!b.isBorrow())
            System.out.println(b.getBookId() + " - " + b.getTitle() + " | " + b.getRelease() + " | " + b.getIsbn() + " | " + b.getAuthorName() + " | " + b.getBookType() + " | " + b.getPages() + " | " + b.getSummary() + " | " + b.isBorrow());
        }
    }

    @Override
    public Book getBook(Long bookId) throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });

        for (Book b : books) {
            if (bookId.equals(b.getBookId())) {
                return b;
            }
        }
        return null;
    }

    @Override
    public void editBook(Book book) throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });
        int i = 0;
        for (Book b : books) {
            if (book.getBookId().equals(b.getBookId())) {

                books.set(i, book);
                break;
            }
            i++;
        }
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), books);
    }

    @Override
    public void updateBookFlag(Long bookId, boolean bookFlag) throws IOException {
        List<Book> books = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Book>>() {
        });

        for (Book b : books) {
            if (bookId.equals(b.getBookId())) {
                b.setBorrow(bookFlag);
            }
        }
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), books);
    }

}
