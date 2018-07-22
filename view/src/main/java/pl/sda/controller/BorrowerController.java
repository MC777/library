package pl.sda.controller;

import pl.sda.module.Borrower;
import pl.sda.service.BorrowerService;
import pl.sda.service.IBorrowerService;

import java.io.IOException;

/**
 * Created by MCK on 22.07.2018 09:53
 **/
public class BorrowerController {

    private IBorrowerService borrowerService = new BorrowerService();

    public void save(String borrowerFirstName, String borrowerLastName, String borrowerHomeAddress, String borrowerPhoneNumber, String borrowerEmail) throws IOException {
        Borrower borrower = new Borrower();
        borrower.setBorrowerFirstName(borrowerFirstName);
        borrower.setBorrowerLastName(borrowerLastName);
        borrower.setBorrowerHomeAddress(borrowerHomeAddress);
        borrower.setBorrowerPhoneNumber(borrowerPhoneNumber);
        borrower.setBorrowerEmail(borrowerEmail);
        borrowerService.save(borrower);
    }
}
