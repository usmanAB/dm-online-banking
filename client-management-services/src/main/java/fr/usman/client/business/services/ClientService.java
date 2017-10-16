package fr.usman.client.business.services;

import fr.usman.client.business.repositories.IClientService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by Usman on 16/10/2017.
 */

@Component
@Service
public class ClientService implements IClientService {

    private static final Logger logger = Logger.getLogger(String.valueOf(IClientService.class));


    public String getAllUsers() {
        return "getAllUsers";
    }

    public String addUser(String lastname,String firstname) {
        String s= "{Add user : "+lastname+" - "+firstname+"}";
        System.out.print(s);
        return s;
    }

    public String updateUser() {
        return "updateUser";
    }

    public String getUser() {
        return "getUser";
    }

    public String deleteUser() {
        return "deleteUser";
    }
}
