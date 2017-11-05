package fr.ekinci.dataaccessservice.user.controllers;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.HistoryDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;

// import org.springframework.data.domain.PageRequest;
import fr.ekinci.dataaccessservice.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/client")
public class ClientController {

	private final UserService userService;
	private static Logger logger;

	@Autowired
	public ClientController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		// TODO
		final Optional<UserDto> dtoOpt = userService.getUserById(id);
		return (dtoOpt.isPresent()) ?
			new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//We have to use PATCH for best practices but Patch and Put methods work very badly with RestTemplate (from restutils in client-service)
	@RequestMapping(path = "/addMoney/{id}/{amount}/{accountType}", method = RequestMethod.POST)
	public ResponseEntity<String> addMoney(@PathVariable long id, @PathVariable long amount, @PathVariable String accountType) {
	//	logger.info("APPEL addMoney \n id : "+id+ "\n amount : " + amount+ "\n accounType : "+accountType+"\n");

		String msg = userService.addMoney(id,amount, accountType);
		System.out.println("ID recu pour ajout argent: "+id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	//We have to use PATCH for best practices but Patch and Put methods work very badly with RestTemplate (from restutils in client-service)
	@RequestMapping(path = "/removeMoney/{id}/{amount}/{accountType}", method = RequestMethod.POST)
	public ResponseEntity<String> removeMoney(@PathVariable long id, @PathVariable long amount, @PathVariable String accountType) {
	//	logger.info("APPEL removeMoney \n id : "+id+ "\n amount : " + amount+ "\n accounType : "+accountType+"\n");

		String msg = userService.removeMoney(id,amount, accountType);
		System.out.println("ID recu pour remove argent: "+id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@RequestMapping(path = "/userInfo/{id}/{accountType}", method = RequestMethod.POST)
	public ResponseEntity<AccountDto> getAccountByTypeAndUserId(@PathVariable long id, @PathVariable String accountType) {
	//	logger.info("APPEL getAccountByTypeAndUserId \n id : "+id+ "\n accounType : "+accountType+"\n");

		final Optional<AccountDto> dtoOpt = userService.getAccountByTypeAndUserId(accountType,id);
		System.out.println("ID recu : "+id);
		return (dtoOpt.isPresent()) ?
				new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@RequestMapping(path = "/historyInfo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHistory(@PathVariable long id) {
//		logger.info("APPEL getAllHistory \n id : "+id+ "\n");
		final List<HistoryDto> list = userService.getAllHistoryByUserId(id);
		return (!list.isEmpty()) ?
				new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>("Aucun historique !",HttpStatus.NO_CONTENT);
	}


	@RequestMapping(path = "/consultAccount/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultUserAccounts(@PathVariable String id) {
		final List<AccountDto> userDtoList = userService.getAccountsByUserId(id);
		return (!userDtoList.isEmpty()) ?
				new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	/**
	 * If page and size request parameters are filled, return a page. Otherwise, return a list of all elements.
	 *
	 * @param page      Page index, starts with 0
	 * @param size      Page size
	 * @return          Can return a TODO @link org.springframework.data.domain.Page OR a {@link List} of DTO
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> get(
		@RequestParam(value = "page", required = false) Integer page,
		@RequestParam(value = "size", required = false) Integer size
	) {
		// Pagination
		if (page != null && size != null) {
			// TODO
		}

		// TODO
		final List<UserDto> userDtoList = Collections.emptyList();
		return (!userDtoList.isEmpty()) ?
			new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto user) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
