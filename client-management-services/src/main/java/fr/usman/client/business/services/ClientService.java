package fr.usman.client.business.services;

import fr.usman.client.business.repositories.IClientService;
import fr.usman.client.business.models.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Usman on 16/10/2017.
 */


/**
 * ClientService class implements IClientService to provide features about users (add, delete, get...)
 */
@Component
@Service
public class ClientService implements IClientService {


    public List<UserDto> getAllUsers() {
        return new ArrayList<UserDto>();
    }

    public void addUser(String lastname,String firstname) {
        String s= "{Add user : "+lastname+" - "+firstname+"}";
//        logger.info(s);
    }

    public void updateUser(String lastname,String firstname) {
    }

    public String getUser(int id) {
        return "getUser";
    }

    public String deleteUser(int id) {
        return "deleteUser";
    }
}
