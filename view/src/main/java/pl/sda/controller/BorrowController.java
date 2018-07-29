package pl.sda.controller;

import pl.sda.module.Borrow;
import pl.sda.service.BorrowService;
import pl.sda.service.IBorrowService;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by MCK on 28.07.2018 22:23
 **/
public class BorrowController {

    private IBorrowService borrowService = new BorrowService();

    public void save(LocalDate borrowDate, Long borrowerId, Long bookId,boolean borrowFlag)throws IOException{
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDate);
        borrow.setBorrowerId(borrowerId);
        borrow.setBookId(bookId);
        borrow.setBorrowFlag(borrowFlag);
        borrowService.save(borrow);
    }

    public void updateBorrowFlag(Long bookId,boolean borrowFlag) throws IOException{
        borrowService.updateBorrowFlag(bookId, borrowFlag);
    }
}
