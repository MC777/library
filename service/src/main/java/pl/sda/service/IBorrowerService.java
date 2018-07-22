package pl.sda.service;

import pl.sda.module.Borrower;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:53
 **/
public interface IBorrowerService {
    void save(Borrower borrower) throws IOException;
}
