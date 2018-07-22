package pl.sda.entry;

import pl.sda.controller.AuthorController;
import pl.sda.controller.BookController;
import pl.sda.controller.BorrowerController;

import java.io.IOException;
import java.time.LocalDate;

import static pl.sda.module.BooksType.HORROR;

/**
 * Created by MCK on 21.07.2018 12:28
 **/
public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        AuthorController authorController = new AuthorController();
        authorController.save("Janek", "Kowal", "Nowa Wieś");

        BookController bookController = new BookController();
        bookController.save("Title", LocalDate.parse("2018-06-03"), "ISBN-200","Adam Mickiewicz",HORROR,390,"Adam Kowalski", "Bardzo ciekawa książka");

        BorrowerController borrowerController = new BorrowerController();
        borrowerController.save("Piotr","Piotrkowski","Polska 11","100-100-100", "piotrkowski@gmail.com");

    }
}