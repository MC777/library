package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pl.sda.module.Borrow;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:26
 **/
public class BorrowRepository implements IBorrowRepository {

    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/borrow/borrow.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public BorrowRepository() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void save(Borrow borrow) throws IOException {
        List<Borrow> borrows = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Borrow>>() {
        });
        Long nextId = Long.valueOf(borrows.size() + 1);
        borrow.setBorrowId(nextId);
        borrows.add(borrow);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), borrows);
    }

    @Override
    public void updateBorrowFlag(Long bookId, Boolean borrowFlag) throws IOException {
        List<Borrow> borrows = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Borrow>>() {
        });

        for (Borrow b : borrows) {
            if (bookId.equals(b.getBookId()) || borrowFlag.equals(true)) {
                LocalDate backDate = LocalDate.now();
                b.setBackDate(backDate);
                b.setBorrowFlag(borrowFlag);
            }
        }
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), borrows);

    }
}
