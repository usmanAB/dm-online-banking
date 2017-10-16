package fr.usman.client.business.controllers;

import fr.usman.client.business.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Usman on 14/10/2017.
 */

@RestController
@RequestMapping(value = "/client")
public class UserController {

    @Autowired
    private ClientService cs;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "<H1>DM N ° 1</H1>";
    }

    @RequestMapping(value="/getall", method= RequestMethod.GET)
    public String getAllUser() {
        return cs.getAllUsers();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String addUser(@RequestParam(value = "lastname", required = false) String lastname,
                          @RequestParam(value = "firstname", required = false) String firstname) {
        return cs.addUser(lastname,firstname);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    public String updateUser(@RequestParam String lastname,
                             @RequestParam String firstname
                             ) {
        return cs.updateUser();
    }

    @RequestMapping(value="/get", method= RequestMethod.GET)
    public String getUser(@RequestParam int id) {
        return cs.getUser();
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public String deleteUser(@RequestParam int id) {
        return cs.deleteUser();
    }




}
