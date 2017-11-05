package fr.ekinci.clientmodels.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Usman ABID BUTT on 01/11/2017.
 */
@Data
@Builder
@ToString
public class AccountDto {
   // @Pattern(regexp = "[0-9]{1,}")
    private String accountNumber;
    private String amount;
    private String userId;
    private TypeAccountDto type;
}
