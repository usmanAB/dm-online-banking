package fr.ekinci.clientmanagementservices.Advisor.controllers;


import fr.ekinci.clientmanagementservices.Advisor.service.AdvisorService;
import fr.ekinci.clientmanagementservices.Advisor.restutils.Rest;
import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/advisor")
public class AdvisorController {
	private AdvisorService advisorService;
	private static Rest rest;


	@RequestMapping(path = "/client/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable String id) {
		// TODO
		final Optional<UserDto> dtoOpt = Optional.of(rest.getUserById(id));
		return (dtoOpt.isPresent()) ?
				new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CONFLICT);
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

	@RequestMapping(path = "/client",method = RequestMethod.POST)
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
		UserInfoDto userInfoDto = rest.getUserInfo(String.valueOf(id));

		String msg ="Age valide !";
		boolean validAge = validAccountAge(userInfoDto.getUserDto().getDateOfBirth(),accountDto.getType().name().toString());

		if(validAge){
			final Optional<AccountDto> dtoOpt = Optional.of(rest.createAccount(id,accountDto));
			return new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("ko",HttpStatus.CONFLICT);
	}



	public boolean validAccountAge(String userDate, String type){
		System.out.print("FONCTION VALIDACCOUNTAGE");
		String date1 = userDate;

		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date now = new Date();
		try {
			Date date2 = format.parse(date1);
			int age = getDiffYears(date2,now);

			if(age>18 && type.equals("LIVRETJEUNE")){
				//System.out.println("Erreur age insuffisant ! "+age);
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static int getDiffYears(Date first, Date last) {
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		int diff = b.get(YEAR) - a.get(YEAR);
		if (a.get(MONTH) > b.get(MONTH) ||
				(a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
			diff--;
		}
		return diff;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}





}
