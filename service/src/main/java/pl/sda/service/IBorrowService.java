package pl.sda.service;

import pl.sda.module.Borrow;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:54
 **/
public interface IBorrowService {
    void save(Borrow borrow) throws IOException;
}
