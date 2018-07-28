package pl.sda.repository;

import pl.sda.module.Borrow;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 11:24
 **/
public interface IBorrowRepository {
    void save (Borrow borrow) throws IOException;
}
