package fr.ekinci.clientservices.user.controllers;

// import org.springframework.data.domain.PageRequest;
import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.HistoryDto;
import fr.ekinci.clientservices.user.restutils.Rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private static Rest rest;


    @RequestMapping(path = "/addMoney/{id}/{amount}/{accountType}", method = RequestMethod.POST)
    public ResponseEntity<?> addMoney(@PathVariable long id, @PathVariable long amount, @PathVariable String accountType) {
        //	logger.info("APPEL addMoney \n id : "+id+ "\n amount : " + amount+ "\n accounType : "+accountType+"\n");


        System.out.println("ID recu pour retrait argent: "+id);

        String msg = rest.addMoney(id,amount, accountType);
        System.out.println("ID recu pour remove argent: "+id);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @RequestMapping(path = "/removeMoney/{id}/{amount}/{accountType}", method = RequestMethod.POST)
    public ResponseEntity<?> removeMoney(@PathVariable long id, @PathVariable long amount, @PathVariable String accountType) {
        //	logger.info("APPEL addMoney \n id : "+id+ "\n amount : " + amount+ "\n accounType : "+accountType+"\n");


        System.out.println("ID recu pour retrait argent: "+id);

        String msg = rest.removeMoney(id,amount, accountType);
        System.out.println("ID recu pour remove argent: "+id);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @RequestMapping(path = "/consultAccount/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultUserAccounts(@PathVariable String id) {
        final List<AccountDto> userDtoList = rest.getAccountsByUserId(id);
        return (!userDtoList.isEmpty()) ?
                new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/historyInfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllHistory(@PathVariable long id) {
//		logger.info("APPEL getAllHistory \n id : "+id+ "\n");
        final List<HistoryDto> list = rest.getAllHistoryByUserId(id);
        return (!list.isEmpty()) ?
                new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>("Aucun historique !",HttpStatus.NO_CONTENT);
    }


}
