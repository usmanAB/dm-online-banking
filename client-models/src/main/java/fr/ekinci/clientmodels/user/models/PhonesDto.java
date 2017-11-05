package fr.ekinci.clientmodels.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Usman ABID BUTT on 04/11/2017.
 */

@Data
@Builder
@ToString
public class PhonesDto {
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;
}
