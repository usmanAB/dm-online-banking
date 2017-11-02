package fr.ekinci.clientmodels.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by usman on 29/10/2017.
 */

@Data
@Builder
@ToString
public class AccountDto {
    // @Pattern(regexp = "[0-9]{1,}")
    private int accountNumber;
    private int amount;
    private int userId;
    private AccountType type;

}
