package pl.sda.entry;

import pl.sda.controller.AuthorController;
import pl.sda.controller.BookController;
import pl.sda.controller.BorrowerController;
import pl.sda.entry.enums.State;
import pl.sda.module.Book;
import pl.sda.module.BooksType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static pl.sda.module.BooksType.HORROR;

/**
 * Created by MCK on 21.07.2018 12:28
 **/
public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
        while (state != State.EXIT){
            switch (state) {
                case INIT:
                    System.out.println("****************************************************************");
                    System.out.println("What would you like to do?");
                    System.out.println("****************************************************************");
                    System.out.println(" 1. Dodanie książki");
                    System.out.println(" 2. Usunięcie książki");
                    System.out.println(" 3. Edycja Książki");
                    System.out.println(" 4. Wyświetlenie wszystkich dostępnych książek w bibliotece");
                    System.out.println(" 5. Dodanie autora");
                    System.out.println(" 6. Wypożyczenie książki");
                    System.out.println(" 7. Oddanie książki");
                    System.out.println(" 0. Exit program");
                    System.out.println("****************************************************************");
                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            state = State.ADDING_BOOK;
                            break;

                        case ("2"):
                            state = State.REMOVING_BOOK;
                            break;

                        case ("3"):
                            state = State.EDITING_BOOK;
                            break;

                        case ("4"):
                            state = State.SHOWING_BOOKS;
                            break;

                        case ("5"):
                            state = State.ADDING_AUTHOR;
                            break;

                        case ("6"):
                            state = State.RENTTING_BOOK;
                            break;

                        case ("7"):
                            state = State.GETTING_BACK_BOOK;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            System.out.println("Good bye :)");
                            break;

                        default:
                            System.out.println("Please select one option");
                            state = State.INIT;
                            break;
                    }
                    break;

                case ADDING_BOOK:
                    System.out.println("Please provide book TITLE:");
                    String title = scanner.nextLine();
                    System.out.println("Please provide RELASE DATE (sample: 2018-01-20:");
                    LocalDate relase = LocalDate.parse(scanner.nextLine());
                    System.out.println("Please provide ISBN:");
                    String isbn = scanner.nextLine();
                    System.out.println("Please provide AUTHOR NAME:");
                    String authorName = scanner.nextLine();
                    System.out.println("Please provide BOOK TYPE:");
                    int i = 1;
                    for(BooksType b: BooksType.values()){
                        System.out.println(i + " - " + b.name());
                        i++;
                    }
                    Integer x = scanner.nextInt();
                    BooksType.values();
                    BooksType bookType = BooksType.getFromInt(x);

                    System.out.println("Please provide NO OF PAGES:");
                    Integer pages = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please provide SHORT SUMMARY:");
                    String summary = scanner.nextLine();

                    bookController.save(title,relase,isbn,authorName,bookType,pages,summary);
                    state = State.INIT;
                    break;
                case REMOVING_BOOK:
                    System.out.println("Please provide no of book to remove:");
                    Long idToDelete = scanner.nextLong();
                    bookController.deleteBook(idToDelete);
                    state = State.SHOWING_BOOKS;
                    break;
                case EDITING_BOOK:
                    break;
                case SHOWING_BOOKS:
                    bookController.readBooks();
                    state = State.INIT;
                    break;
                case ADDING_AUTHOR:
                    break;
                case RENTTING_BOOK:
                    break;
                case GETTING_BACK_BOOK:
                    break;
                case EXIT:
                    break;
            }
        }

        //AuthorController authorController = new AuthorController();
        //authorController.save("Janek", "Kowal", "Nowa Wieś");


        //bookController.save("Title", LocalDate.parse("2018-06-03"), "ISBN-200","Adam Mickiewicz",HORROR,390,"Adam Kowalski", "Bardzo ciekawa książka");
       // bookController.deleteBook(1L);
        //bookController.deleteBook(2L);

       // BorrowerController borrowerController = new BorrowerController();
       // borrowerController.save("Piotr","Piotrkowski","Polska 11","100-100-100", "piotrkowski@gmail.com");


    }
}