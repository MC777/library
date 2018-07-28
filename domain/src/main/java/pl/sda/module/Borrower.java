package pl.sda.module;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by MCK on 21.07.2018 12:41
 **/
@Getter
@Setter
public class Borrower {

    private Long borrowerId;
    private String borrowerFirstName;
    private String borrowerLastName;
    private String borrowerHomeAddress;
    private String borrowerPhoneNumber;
    private String borrowerEmail;

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerId=" + borrowerId +
                ", borrowerFirstName='" + borrowerFirstName + '\'' +
                ", borrowerLastName='" + borrowerLastName + '\'' +
                ", borrowerHomeAddress='" + borrowerHomeAddress + '\'' +
                ", borrowerPhoneNumber='" + borrowerPhoneNumber + '\'' +
                ", borrowerEmail='" + borrowerEmail + '\'' +
                '}';
    }
}
