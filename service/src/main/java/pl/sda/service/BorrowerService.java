package pl.sda.service;

import pl.sda.module.Borrower;
import pl.sda.repository.BorrowerRepository;
import pl.sda.repository.IBorrowerRepository;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 10:53
 **/
public class BorrowerService implements IBorrowerService{

    private IBorrowerRepository borrowerRepository = new BorrowerRepository();

    @Override
    public void save(Borrower borrower) throws IOException {
        borrowerRepository.save(borrower);
    }

}
