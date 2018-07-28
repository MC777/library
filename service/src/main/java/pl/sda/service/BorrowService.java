package pl.sda.service;

import pl.sda.module.Borrow;
import pl.sda.repository.BorrowRepository;
import pl.sda.repository.IBorrowRepository;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:54
 **/
public class BorrowService implements IBorrowService {

    private IBorrowRepository borrowRepository = new BorrowRepository();

    @Override
    public void save(Borrow borrow) throws IOException {
        borrowRepository.save(borrow);
    }
}
