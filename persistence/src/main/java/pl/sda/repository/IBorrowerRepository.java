package pl.sda.repository;

import pl.sda.module.Borrower;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:24
 **/
public interface IBorrowerRepository {

    void save(Borrower borrower) throws IOException;
}
