package fr.ekinci.clientmanagement.user.service;

import fr.ekinci.clientmanagement.user.models.UserDto;

/**
 * Created by Ance on 30/10/2017.
 */
public interface IAdvisorService {
    void createAccount(UserDto userDto);

    void update(UserDto userDto);

    void getUserInfo(int userId);

}
