package pl.sda.service;

import pl.sda.module.Borrower;
import pl.sda.repository.BorrowerRepository;
import pl.sda.repository.IBorrowerRepository;

import java.io.IOException;
import java.util.List;

/**
 * Created by MCK on 21.07.2018 10:53
 **/
public class BorrowerService implements IBorrowerService{

    private IBorrowerRepository borrowerRepository = new BorrowerRepository();

    @Override
    public void save(Borrower borrower) throws IOException {
        borrowerRepository.save(borrower);
    }

    @Override
    public Borrower getBorrower(Long borrowerId) throws IOException{
        borrowerRepository.getBorrower(borrowerId);
        return null;
    }

    @Override
    public Borrower readAllBorrowers() throws IOException{
        borrowerRepository.readAllBorrowers();
        return null;
    }

    @Override
    public List<Borrower> getBorrowersList() throws IOException{
        return borrowerRepository.getBorrowersList();
    }

}
