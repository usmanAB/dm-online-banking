package fr.ekinci.dataaccessservice.user.services;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.HistoryDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import fr.ekinci.clientmodels.user.models.UserInfoDto;



import java.util.List;
import java.util.Optional;

public interface IUserService {
	/**
	 * search all users from database and return a list of all elements.
	 * @return List of usersDTO
	 */
	List<UserDto> getAll();

	/**
	 * search an user by his id from database and return a {@link UserDto}
	 * @param id
	 * @return returns {@link UserDto}
	 */
	Optional<UserDto> getUserById(String id);

	Optional<AccountDto> getAccountById(String id);

	/**
	 * search all accounts by users id from database and return a list of all elements.
	 * @param id
	 * @return List of {@link AccountDto}
	 */
	List<AccountDto> getAccountsByUserId(String id);

	/**
	 * search all accounts by users ud and account type and return user's account
	 * @param type
	 * @param userId
	 * @return List of {@link AccountDto}
	 */
	Optional<AccountDto> getAccountByTypeAndUserId(String type, long userId);

	/**
	 * search all accounts and user information  by users id only from database and return a list of all elements.
	 * @param id
	 * @return List of {@link UserInfoDto}
	 */
	Optional<UserInfoDto> getUserInfoById(String id);

	/**
	 * create an user and return created user
	 * @param userDto
	 * @return return {@link UserDto}
	 */
	UserDto create(UserDto userDto);

	/**
	 * create account with userId parameter and accountDto parameter
	 * @param userId
	 * @param accountDto
	 * @return return {@link fr.ekinci.clientmodels.user.models.AccountDto}
	 */
	Optional<AccountDto> createAccount(long userId, AccountDto accountDto);

	/**
	 * Not implemented yet
	 * @param id
	 */
	void delete(String id);

	/**
	 * Not implemented yet
	 * @param id
	 * @param userDto
	 */
	void update(String id, UserDto userDto);

	/**
	 * This method allow to add money in account by user id parameter and accounttypr parameter
	 * @param userId
	 * @param amount
	 * @param accounttype
	 * @return confirmation message String
	 */
	String addMoney(long userId, long amount,String accounttype);

	/**
	 * This method allow to remove money from user account by user id parameter and account type parameter
	 * @param userId
	 * @param amount
	 * @param accountType
	 * @return confirmation message String
	 */
	String removeMoney(long userId, long amount, String accountType);

	/**
	 * this method returns all transaction from database by user id
	 * @param id
	 * @return List of {@link HistoryDto}
	 */
	List<HistoryDto> getAllHistoryByUserId(long id);

}
