package fr.ekinci.dataaccessservice.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by Usman ABID BUTT on 04/11/2017.
 */


@Data
@Builder
@ToString
public class UserInfoDto {

    private List<AccountDto> accountDto;
    private UserDto userDto;

}
