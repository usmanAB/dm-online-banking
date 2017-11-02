package fr.ekinci.clientservices.user.client;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;

/**
 * Created by Ance on 30/10/2017.
 */
public class ClientService implements IClientService {
    @Override
    public long getAccountBalance(UserDto userDto) {
        return 0;
    }

    @Override
    public void addMoney(AccountDto accountDto, int amount) {

    }

    @Override
    public void getMoney(AccountDto accountDto, int amount) {

    }
}
