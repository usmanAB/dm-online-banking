package fr.ekinci.clientmanagementservices.user.controllers;


import fr.ekinci.clientmanagementservices.user.service.AdvisorService;
import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
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
@RequestMapping(path = "/users")
public class UserController {
	private AdvisorService advisorService;


	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable Long id) {
		// TODO
		final Optional<UserDto> dtoOpt = Optional.of(new UserDto());
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

	@RequestMapping(path = "/client", method = RequestMethod.POST)
	public ResponseEntity<UserDto> createClient(@RequestBody UserDto user) {
		return new ResponseEntity<>(new UserDto(), HttpStatus.OK);
	}

	@RequestMapping(path = "/account", method = RequestMethod.POST)
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {

		//advisorService.createAccount(accountDto);

		return new ResponseEntity<>(advisorService.createAccount(accountDto), HttpStatus.OK);
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
