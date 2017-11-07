package fr.ekinci.clientmanagementservices.Advisor.restutils;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */
public class Rest {


    public static UserDto createUser(UserDto user) {
        System.out.print("----> APPEL CREATEUSER FROM ADVISOR REST  :"+user.getFirstName()+" \n");

        final String uri = "http://localhost:25002/data-access/advisor/users";

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.postForObject(uri,user ,UserDto.class);

        return userDto;
    }

    public static UserInfoDto getUserInfo(String id) {
        System.out.print("----> APPEL CREATEUSER FROM ADVISOR REST  :"+id+" \n");
        //We have to use headers....
        final String uri = "http://localhost:25002/data-access/advisor/userInfo/{id}";

        RestTemplate restTemplate = new RestTemplate();
        UserInfoDto userInfoDto = restTemplate.getForObject(uri,UserInfoDto.class,id);

        return userInfoDto;
    }

    public static AccountDto createAccount(long id,AccountDto accountDto){
        System.out.print("----> APPEL createAccount FROM ADVISOR REST  :"+id+" \n");
        //We have to use headers....
        final String uri = "http://localhost:25002/data-access/advisor/account/{id}";

        RestTemplate restTemplate = new RestTemplate();
        AccountDto account = restTemplate.postForObject(uri,accountDto,AccountDto.class,id);

        return account;
    }

    public static UserDto getUserById(String id){
        System.out.print("----> APPEL getUserById FROM ADVISOR REST  :"+id+" \n");
        //We have to use headers....
        final String uri = "http://localhost:25002/data-access/client/{id}";

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForObject(uri,UserDto.class,id);

        return userDto;
    }




}
