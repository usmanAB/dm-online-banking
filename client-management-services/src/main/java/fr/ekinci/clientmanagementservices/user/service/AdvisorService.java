package fr.ekinci.clientmanagementservices.user.service;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import org.springframework.web.client.RestTemplate;

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

    public void createClient() {

    }

    @Override
    public void update(UserDto userDto) {

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
    public UserDto getClient(int userId) {
        return null;
    }

}
