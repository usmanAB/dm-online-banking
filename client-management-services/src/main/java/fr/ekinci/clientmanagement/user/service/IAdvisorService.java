package fr.ekinci.clientmanagement.user.service;

import fr.ekinci.clientmanagement.user.models.AccountDto;
import fr.ekinci.clientmanagement.user.models.UserDto;

/**
 * Created by Ance on 30/10/2017.
 */
public interface IAdvisorService {
    AccountDto createAccount(AccountDto accountDto);

    void update(UserDto userDto);

    AccountDto getClientAccountById(long userId);

    UserDto getClient(int userId);

    void createClient();
}
