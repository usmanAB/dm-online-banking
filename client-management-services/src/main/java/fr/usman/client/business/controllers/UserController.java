package fr.usman.client.business.controllers;

import fr.usman.client.business.services.ClientService;
import fr.usman.client.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Usman on 14/10/2017.
 */

@RestController
@RequestMapping(value = "/client")
public class UserController {



    @Autowired
    private ClientService cs;

    private List<UserDto> l;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "<H1>DM N ° 1</H1>";
    }

    @RequestMapping(value="/getall", method= RequestMethod.GET)
    public String getAllUser() {
        l = cs.getAllUsers();
        return "List clients";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public void addUser(@RequestParam(value = "lastname", required = false) String lastname,
                          @RequestParam(value = "firstname", required = false) String firstname) {
        cs.addUser(lastname,firstname);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public void updateUser(@RequestParam String lastname,
                             @RequestParam String firstname
                             ) {
        cs.updateUser(lastname,firstname);
    }

    @RequestMapping(value="/get", method= RequestMethod.GET)
    public String getUser(@RequestParam int id) {
        return cs.getUser(id);
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String deleteUser(@RequestParam int id) {
        return cs.deleteUser(id);
    }


}
