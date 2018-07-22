package pl.sda.entry;

import pl.sda.controller.BookController;
import pl.sda.entry.enums.State;
import pl.sda.module.Book;
import pl.sda.module.BooksType;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by MCK on 21.07.2018 12:28
 **/
public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
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
                    System.out.println("Please provide RELASE DATE (sample: 2018-01-20:");
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
                    bookController.readBooks(idToEdit);
                    //TODO
                    Book book = new Book();
                    System.out.println("Please provide book TITLE. /If you don't want edit that field, please press enter/");
                    title = scanner.nextLine();
                    if (title.equals("")) {
                        book.setTitle(book.getTitle());
                    } else {
                        book.setTitle(title);
                    }
                    System.out.println("Please provide book RELASE DATE. /If you don't want edit that field, please press enter/");
                    //TODO - error for blank value
                    try {
                        relase = LocalDate.parse(scanner.nextLine());
                    } catch (Exception e){
                        relase = null;
                    }


                    if (relase.equals(null)) {
                        book.setRelease(book.getRelease());
                    } else {
                        book.setRelease(relase);
                    }

                    System.out.println("Please provide book ISBN. /If you don't want edit that field, please press enter/");
                    isbn = scanner.nextLine();
                    if (isbn.equals("")) {
                        book.setIsbn(book.getIsbn());
                    } else {
                        book.setIsbn(isbn);
                    }
                    System.out.println("Please provide book AUTHOR NAME. /If you don't want edit that field, please press enter/");
                    authorName = scanner.nextLine();
                    if (authorName.equals("")) {
                        book.setAuthorName(book.getAuthorName());
                    } else {
                        book.setAuthorName(authorName);
                    }
                    System.out.println("Please provide book TYPE. /If you don't want edit that field, please press enter/");
                    i = 1;
                    for (BooksType b : BooksType.values()) {
                        System.out.println(i + " - " + b.name());
                        i++;
                    }
                    x = scanner.nextInt();
                    scanner.nextLine();
                    BooksType.values();
                    bookType = BooksType.getFromInt(x);
                    if (bookType.getFromInt(x).getText().equals("")) {
                        book.setBookType(book.getBookType());
                    } else {
                        book.setBookType(bookType);
                    }

                    System.out.println("Please provide book NO OF PAGES. /If you don't want edit that field, please press enter/");
                    pages = scanner.nextInt();
                    scanner.nextLine();
                    if (pages.equals(null)) {
                        book.setPages(book.getPages());
                    } else {
                        book.setPages(pages);
                    }
                    System.out.println("Please provide book SUMMARY. /If you don't want edit that field, please press enter/");
                    summary = scanner.nextLine();
                    if (summary.equals("")) {
                        book.setSummary(book.getSummary());
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
                    break;
                case RENTTING_BOOK:
                    break;
                case GETTING_BACK_BOOK:
                    break;
                case EXIT:
                    break;
            }
        }
    }
}