package pl.sda.entry;

import pl.sda.controller.AuthorController;
import pl.sda.controller.BookController;
import pl.sda.controller.BorrowerController;
import pl.sda.entry.enums.State;
import pl.sda.module.Book;
import pl.sda.module.BooksType;
import pl.sda.module.Borrower;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MCK on 21.07.2018 12:28
 **/
public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
        AuthorController authorController = new AuthorController();
        BorrowerController borrowerController = new BorrowerController();

        while (state != State.EXIT) {
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
                    System.out.println("Please provide RELASE DATE (sample: 2018-01-20):");
                    LocalDate relase = LocalDate.parse(scanner.nextLine());
                    System.out.println("Please provide ISBN:");
                    String isbn = scanner.nextLine();
                    System.out.println("Please provide AUTHOR NAME:");
                    String authorName = scanner.nextLine();
                    System.out.println("Please provide BOOK TYPE:");
                    int i = 1;
                    for (BooksType b : BooksType.values()) {
                        System.out.println(i + " - " + b.name());
                        i++;
                    }
                    Integer x = scanner.nextInt();
                    scanner.nextLine();
                    BooksType.values();
                    BooksType bookType = BooksType.getFromInt(x);

                    System.out.println("Please provide NO OF PAGES:");
                    Integer pages = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please provide SHORT SUMMARY:");
                    String summary = scanner.nextLine();

                    bookController.save(title, relase, isbn, authorName, bookType, pages, summary);
                    state = State.INIT;
                    break;
                case REMOVING_BOOK:
                    System.out.println("Please provide no of book to remove:");
                    bookController.readBooks();
                    Long idToDelete = scanner.nextLong();
                    scanner.nextLine();
                    bookController.deleteBook(idToDelete);
                    state = State.INIT;
                    break;
                case EDITING_BOOK:
                    System.out.println("Please select book for editing:");
                    bookController.readBooks();
                    Long idToEdit = scanner.nextLong();
                    scanner.nextLine();
                    Book book = bookController.getBook(idToEdit);

                    System.out.println("Please provide book TITLE. /If you don't want edit that field, please press enter/");
                    title = scanner.nextLine();
                    if (title.equals("")) {
                        title = book.getTitle();
                    } else {
                        book.setTitle(title);
                    }

                    System.out.println("Please provide book RELEASE DATE. /If you don't want edit that field, please press enter/");
                    String scCheck1 = scanner.nextLine();

                    if (scCheck1.equals("")) {
                        relase = book.getRelease();
                    } else {
                        relase = LocalDate.parse(scCheck1);
                        book.setRelease(relase);
                    }

                    System.out.println("Please provide book ISBN. /If you don't want edit that field, please press enter/");
                    isbn = scanner.nextLine();
                    if (isbn.equals("")) {
                        isbn = book.getIsbn();
                    } else {
                        book.setIsbn(isbn);
                    }

                    System.out.println("Please provide book AUTHOR NAME. /If you don't want edit that field, please press enter/");
                    authorName = scanner.nextLine();
                    if (authorName.equals("")) {
                        authorName = book.getAuthorName();
                    } else {
                        book.setAuthorName(authorName);
                    }

                    System.out.println("Please provide book TYPE. /If you don't want edit that field, please press enter/");
                    i = 1;
                    for (BooksType b : BooksType.values()) {
                        System.out.println(i + " - " + b.name());
                        i++;
                    }

                    String scCheck3 = scanner.nextLine();

                    if (scCheck3.equals("")) {
                        bookType = book.getBookType();
                    } else {
                        x = Integer.parseInt(scCheck3);
                        //BooksType.values();
                        bookType = BooksType.getFromInt(x);
                        book.setBookType(bookType);
                    }

                    System.out.println("Please provide book NO OF PAGES. /If you don't want edit that field, please press enter/");
                    String scCheck2 = scanner.nextLine();

                    if (scCheck2.equals("")) {
                        pages = book.getPages();
                    } else {
                        pages = Integer.parseInt(scCheck2);
                        book.setPages(pages);
                    }

                    System.out.println("Please provide book SUMMARY. /If you don't want edit that field, please press enter/");
                    summary = scanner.nextLine();
                    if (summary.equals("")) {
                        summary = book.getSummary();
                    } else {
                        book.setSummary(summary);
                    }

                    book = new Book(idToEdit, title, relase, isbn, authorName, bookType, pages, summary);
                    bookController.editBook(book);
                    state = State.INIT;
                    break;
                case SHOWING_BOOKS:
                    bookController.readBooks();
                    state = State.INIT;
                    break;
                case ADDING_AUTHOR:
                    System.out.println("Please provide author FIRST NAME:");
                    String authorFirstName = scanner.nextLine();
                    System.out.println("Please provide author LAST NAME:");
                    String authorLastName = scanner.nextLine();
                    System.out.println("Please provide author PLACE OF BIRTH:");
                    String authorPlaceOfBirth = scanner.nextLine();
                    authorController.save(authorFirstName, authorLastName, authorPlaceOfBirth);
                    state = State.INIT;
                    break;
                case RENTTING_BOOK:
                    System.out.println("Please select book to borrow:");
                    bookController.readAvailableBooks();
                    //Integer noOfBookToBorrow = scanner.nextInt();
                    //scanner.nextLine();

                    System.out.println("Please create new borrower or select existing one:");
                    System.out.println("0 - add new one");


                    int borrowerListSize = borrowerController.getBorrowersList().size();
                    for (int y = 0; y < borrowerListSize; y++){
                        System.out.println(borrowerController.getBorrowersList().get(y).getBorrowerId() + " - " +
                                borrowerController.getBorrowersList().get(y).getBorrowerFirstName() + " | " +
                                borrowerController.getBorrowersList().get(y).getBorrowerLastName() + " | " +
                                borrowerController.getBorrowersList().get(y).getBorrowerHomeAddress() + " | " +
                                borrowerController.getBorrowersList().get(y).getBorrowerPhoneNumber() + " | " +
                                borrowerController.getBorrowersList().get(y).getBorrowerEmail());
                    }

                    borrowerController.readAllBorrowers();

                    Long borrowerSelectionOrCreation = scanner.nextLong();
                    scanner.nextLine();

                    if (borrowerSelectionOrCreation.equals(0L)) {
                        System.out.println("Please provide borrower FIRST NAME:");
                        String borrowerFirstName = scanner.nextLine();
                        System.out.println("Please provide borrower LAST NAME:");
                        String borrowerLastName = scanner.nextLine();
                        System.out.println("Please provide borrower HOME ADDRESS:");
                        String borrowerHomeAddress = scanner.nextLine();
                        System.out.println("Please provide borrower PHONE NUMBER:");
                        String borrowerPhoneNumber = scanner.nextLine();
                        System.out.println("Please provide borrower BORROWER EMAIL:");
                        String borrowerEmail = scanner.nextLine();
                        borrowerController.save(borrowerFirstName, borrowerLastName, borrowerHomeAddress, borrowerPhoneNumber, borrowerEmail);
                        state = State.RENTTING_BOOK;
                        break;
                    } else {
                        //Borrower borrower = borrowerController.getBorrower(borrowerSelectionOrCreation);
                    }

                    state = State.INIT;
                    break;
                case GETTING_BACK_BOOK:
                    break;
                case EXIT:
                    break;
            }
        }
    }
}