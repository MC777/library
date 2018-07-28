package pl.sda.module;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by MCK on 21.07.2018 11:55
 **/

@Getter
@Setter
public class Author {

    private Long authorId;
    private String firstName;
    private String lastName;
    private String placeOfBirth;
}
