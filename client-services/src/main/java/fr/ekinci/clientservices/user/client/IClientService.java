package fr.ekinci.clientservices.user.client;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;

/**
 * Created by Ance on 30/10/2017.
 */
public interface IClientService {

    long getAccountBalance(UserDto userDto);

    void addMoney(AccountDto accountDto, int amount);

    void getMoney(AccountDto accountDto, int amount);

}