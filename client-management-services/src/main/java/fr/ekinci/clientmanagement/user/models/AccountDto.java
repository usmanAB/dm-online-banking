package fr.ekinci.clientmanagement.user.models;

import lombok.Data;
import lombok.ToString;

/**
 * Created by usman on 29/10/2017.
 */
@Data
@ToString
public class AccountDto {
    private int accountNumber;
    private Double amount;
    private UserDto userDto;

}
