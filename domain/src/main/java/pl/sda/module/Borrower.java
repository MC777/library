package pl.sda.module;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by MCK on 21.07.2018 12:41
 **/
@Getter
@Setter
public class Borrower {

    private Long borrowerId;
    private String borrowerFirstName;
    private String borrowerLastname;
    private String borrowerHomeAddress;
    private String borrowerPhoneNumber;
    private String borrowerEmail;
}
