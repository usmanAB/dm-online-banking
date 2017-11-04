package fr.ekinci.dataaccessservice.user.services;

import fr.ekinci.dataaccessservice.user.models.AccountDto;
import fr.ekinci.dataaccessservice.user.models.UserDto;
import fr.ekinci.dataaccessservice.user.models.UserInfoDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	List<UserDto> getAll();

	Optional<UserDto> getUserById(String id);

	Optional<AccountDto> getAccountById(String id);

	List<AccountDto> getAccountsByUserId(String id);


	Optional<AccountDto> getAccountByTypeAndUserId(String type, long userId);

	Optional<UserInfoDto> getUserInfoById(String id);

	UserDto create(UserDto userDto);

	AccountDto createAccount(long userId, AccountDto accountDto);

	void delete(String id);

	void update(String id, UserDto userDto);

	String addMoney(long userId, long amount,String accounttype);

	String removeMoney(long userId, long amount, String accountType);
}
