package fr.ekinci.dataaccessservice.user.services;

import fr.ekinci.dataaccessservice.user.models.AccountDto;
import fr.ekinci.dataaccessservice.user.entities.AccountEntity;
import fr.ekinci.dataaccessservice.user.entities.UserEntity;
//import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.dataaccessservice.user.models.UserDto;
import fr.ekinci.dataaccessservice.user.repositories.AccountRepository;
import fr.ekinci.dataaccessservice.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;
	private final AccountRepository accountRepository;

	@Autowired
	public UserService(UserRepository userRepository, AccountRepository accountRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
			.stream()
			.map(
				u -> UserDto.builder()
				.id(String.valueOf(u.getId()))
				.firstName(u.getFirstName())
				.lastName(u.getLastName())
				.build()
			)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<UserDto> getUserById(String id) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
			Optional.of(
				UserDto.builder()
					.id(String.valueOf(userEntity.getId()))
					.firstName(userEntity.getFirstName())
					.lastName(userEntity.getLastName())
					.build()
			)
			: Optional.empty();
	}

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());

		UserEntity userEntity1 = userRepository.save(userEntity);
		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
			.build();
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		AccountEntity account = new AccountEntity();
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setType("Epargne");
		account.setAmount(0);
		account.setUserId(accountDto.getUserId());

		AccountEntity account1 = accountRepository.save(account);
		return AccountDto.builder()
				.accountNumber(account1.getAccountNumber())
				.amount(account1.getAmount())
				.userId(account1.getUserId())
				.build();
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public void update(String id, UserDto userDto) {

	}
}
