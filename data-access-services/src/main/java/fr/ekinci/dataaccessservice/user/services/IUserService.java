package fr.ekinci.dataaccessservice.user.services;

import fr.ekinci.dataaccessservice.user.models.AccountDto;
import fr.ekinci.dataaccessservice.user.models.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	List<UserDto> getAll();

	Optional<UserDto> getUserById(String id);

	UserDto create(UserDto userDto);

	AccountDto createAccount(AccountDto accountDto);

	void delete(String id);

	void update(String id, UserDto userDto);
}
