package pl.sda.entry;

import pl.sda.controller.AuthorController;
import pl.sda.controller.BookController;

import java.io.IOException;

/**
 * Created by MCK on 21.07.2018 12:28
 **/
public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        AuthorController authorController = new AuthorController();
        authorController.save("Janek", "Kowal", "Nowa Wieś");

        BookController bookController = new BookController();
        bookController.("Title", 4900000, "ISBN-200","Adam Mickiewicz","Horror",390,"Adam Kowalski", "Bardzo ciekawa książka");

    }
}