package pl.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.module.Borrower;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:26
 **/
public class BorrowerRepository implements IBorrowerRepository{

    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/borrowers/borrowers.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void save(Borrower borrower) throws IOException {
        List<Borrower> borrowers = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new com.fasterxml.jackson.core.type.TypeReference<List<Borrower>>() {
        });
        Long nextId = Long.valueOf(borrowers.size() + 1);
        borrower.setBorrowerId(nextId);
        borrowers.add(borrower);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), borrowers);
    }
}
