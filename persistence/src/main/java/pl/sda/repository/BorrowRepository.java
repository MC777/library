package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.module.Borrow;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:26
 **/
public class BorrowRepository implements IBorrowRepository {

    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/borrow/borrow.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void save(Borrow borrow) throws IOException {
        List<Borrow> borrows = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Borrow>>() {
        });
        Long nextId = Long.valueOf(borrows.size() + 1);
        borrow.setBorrowerId(nextId);
        borrows.add(borrow);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), borrows);
    }
}
