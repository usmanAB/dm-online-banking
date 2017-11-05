package fr.ekinci.clientmodels.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */

@Data
@Builder
@ToString
public class HistoryDto {

    private TypeAccountDto type;
    private String amount;
    private String userId;
    private String date;
}
