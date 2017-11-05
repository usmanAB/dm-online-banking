package fr.ekinci.dataaccessservice.user.controllers;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;
import fr.ekinci.dataaccessservice.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */
@RestController
@RequestMapping(path = "/advisor")
public class AdvisorController {
    private final UserService userService;
    private static Logger logger;


    @Autowired
    public AdvisorController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/userInfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(@PathVariable String id) {
        // TODO
        final Optional<UserInfoDto> dtoOpt = userService.getUserInfoById(id);
        System.out.println("ID recu : "+id+"......"+dtoOpt.get().toString());
        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/consultAccount/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultUserAccounts(@PathVariable String id) {
        final List<AccountDto> userDtoList = userService.getAccountsByUserId(id);
        return (!userDtoList.isEmpty()) ?
                new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }


    @RequestMapping(path = "/account/{id}", method = RequestMethod.POST)
    public ResponseEntity<AccountDto> createAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
        final Optional<AccountDto> dtoOpt = userService.createAccount(id,accountDto);

//		logger.info("APPEL createAccount \n id : "+id+ "\n");

        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}