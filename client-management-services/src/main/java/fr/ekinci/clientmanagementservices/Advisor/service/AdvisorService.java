package fr.ekinci.clientmanagementservices.Advisor.service;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by Ance on 30/10/2017.
 */
public class AdvisorService implements IAdvisorService {
    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        final String uri = "http://localhost:25002/data-access/account";

        RestTemplate restTemplate = new RestTemplate();
        AccountDto accountDtoResponse = restTemplate.postForObject(uri,null,AccountDto.class,accountDto);
        return accountDtoResponse;
    }

    public UserDto createUser(UserDto user) {
        System.out.print("----> APPEL CREATEUSER FROM ADVISOR SERVICE  :"+user.getFirstName()+" \n");

        final String uri = "http://localhost:25002/data-access/users";

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.postForObject(uri,user ,UserDto.class);
        return userDto;

    }


    @Override
    public AccountDto getClientAccountById(long userId)
    {
        final String uri = "http://localhost:25002/data-access/clientAccount/{id}";

        RestTemplate restTemplate = new RestTemplate();
        AccountDto accountDtoResponse = restTemplate.postForObject(uri,null,AccountDto.class,userId);
        return accountDtoResponse;
    }

    @Override
    public Optional<UserInfoDto> getUserInfoById(String id) {
        return null;
    }

    @Override
    public UserDto getUserById(long userId) {
        return null;
    }

}
