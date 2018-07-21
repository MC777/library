package pl.sda.module;

/**
 * Created by MCK on 21.07.2018 12:42
 **/
public enum BooksType {


    SCIENCE_FICTION("Science Fiction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy");

    private String text;

    BooksType(String text){
        this.text = text;
    }

    public String getText(){return text;}
}
