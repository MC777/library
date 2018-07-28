package pl.sda.repository;

import pl.sda.module.Borrower;

import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 11:24
 **/
public interface IBorrowerRepository {

    void save(Borrower borrower) throws IOException;

    Borrower getBorrower(Long borrowerId) throws IOException;

    void readAllBorrowers() throws IOException;

    List<Borrower> getBorrowersList() throws IOException;
}
