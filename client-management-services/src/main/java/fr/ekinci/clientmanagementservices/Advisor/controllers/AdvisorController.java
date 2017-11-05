package fr.ekinci.clientmanagementservices.Advisor.controllers;


import fr.ekinci.clientmanagementservices.Advisor.service.AdvisorService;
import fr.ekinci.clientmanagementservices.Advisor.restutils.Rest;
import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/advisor")
public class AdvisorController {
	private AdvisorService advisorService;
	private static Rest rest;


	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable long id) {
		// TODO
		final Optional<UserDto> dtoOpt = Optional.of(advisorService.getUserById(id));
		return (dtoOpt.isPresent()) ?
			new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(path = "/clientAccount/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> getClientAccount(@PathVariable Long id) {

		return new ResponseEntity<>(advisorService.getClientAccountById(id), HttpStatus.OK);


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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		System.out.print("----> APPEL CREATEUSER FROM CLIENT MANAGEMENT  : \n");

		final Optional<UserDto> dtoOpt = Optional.of(rest.createUser(user));
		return (dtoOpt.isPresent()) ?
				new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CONFLICT);

	}

	@RequestMapping(path = "/userInfo/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserInfoDto> getUserInfo(@PathVariable String id) {

		final Optional<UserInfoDto> dtoOpt = Optional.of(rest.getUserInfo(id));

		return (dtoOpt.isPresent()) ?
				new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@RequestMapping(path = "/account/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
		final Optional<AccountDto> dtoOpt = Optional.of(rest.createAccount(id,accountDto));

//		logger.info("APPEL createAccount \n id : "+id+ "\n");

		return (dtoOpt.isPresent()) ?
				new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}




}
