package fr.ekinci.clientmanagementservices.Advisor.service;


import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;

import java.util.Optional;

/**
 * Created by Ance on 30/10/2017.
 */
public interface IAdvisorService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getClientAccountById(long userId);

    Optional<UserInfoDto> getUserInfoById(String id);

    UserDto getUserById(long userId);

    UserDto createUser(UserDto userDto);
}
