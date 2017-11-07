package fr.ekinci.dataaccessservice.user.services;


import fr.ekinci.clientmodels.user.models.*;
import fr.ekinci.dataaccessservice.user.entities.HistoryEntity;
import fr.ekinci.dataaccessservice.user.entities.PhonesEntity;

import fr.ekinci.dataaccessservice.user.entities.AccountEntity;
import fr.ekinci.dataaccessservice.user.entities.UserEntity;
//import fr.ekinci.clientmodels.Advisor.models.AccountDto;
import fr.ekinci.dataaccessservice.user.repositories.AccountRepository;
import fr.ekinci.dataaccessservice.user.repositories.HistoryRepository;
import fr.ekinci.dataaccessservice.user.repositories.UserRepository;
import fr.ekinci.dataaccessservice.user.utils.UserServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;
	private final AccountRepository accountRepository;
	private final HistoryRepository historyRepository;

	private static Logger logger;


	@Autowired
	public UserService(UserRepository userRepository, AccountRepository accountRepository, HistoryRepository historyRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
		this.historyRepository = historyRepository;
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


    public List<AccountDto> getAccountsByUserId(String id) {
        return  accountRepository.getAccountByTypeAndUserId(Long.parseLong(id))
                .stream()
                .map(
                        a -> AccountDto.builder()
                                .accountNumber(String.valueOf(a.getAccountNumber()))
                                .amount(String.valueOf(a.getAmount()))
                                .userId(String.valueOf(a.getUserEntity().getId()))
                                .type(TypeAccountDto.valueOf(a.getType().toString()))
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
                    .dateOfBirth(userEntity.getDateOfBirth())
					.build()
			)
			: Optional.empty();
	}

	public Optional<AccountDto> getAccountById(String id) {
		AccountEntity accountEntity = accountRepository.findOne(Long.parseLong(id));
		return (accountEntity != null) ?
				Optional.of(
						AccountDto.builder()
								.accountNumber(String.valueOf(accountEntity.getAccountNumber()))
								.amount(String.valueOf(accountEntity.getAmount()))
                                .type(TypeAccountDto.valueOf(accountEntity.getType().toString()))
								.build()
				)
				: Optional.empty();
	}


    public Optional<AccountDto> getAccountByTypeAndUserId(String type, long id) {
	    System.out.print("Parametre recus : "+type+id);
        List<AccountEntity> accountEntity1 = accountRepository.getAccountByTypeAndUserId(type,id);
        if(accountEntity1.isEmpty()){
        	return Optional.empty();
		}
        AccountEntity accountEntity =  accountEntity1.get(0);
        return (accountEntity != null) ?
                Optional.of(
                        AccountDto.builder()
                                .accountNumber(String.valueOf(accountEntity.getAccountNumber()))
                                .amount(String.valueOf(accountEntity.getAmount()))
                                .type(TypeAccountDto.valueOf(accountEntity.getType().toString()))
                                .build()
                )
                : Optional.empty();
    }

	public Optional<UserInfoDto> getUserInfoById(String id) {

		List<AccountDto> accountDto = getAccountsByUserId(id);
		UserDto userDto = getUserById(id).get();
		System.out.println("Info Advisor : "+userDto.getFirstName());

		return (accountDto != null || userDto !=null) ?
				Optional.of(
						UserInfoDto.builder()
								.accountDto(accountDto)
								.userDto(userDto)
								.build()
				)
				: Optional.empty();
	}


	@Override
	public UserDto create(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setPhonesEntity(phoneDtoToEntityPhone(userDto));
		userEntity.setDateOfBirth(userDto.getDateOfBirth());

		UserEntity userEntity1 = userRepository.save(userEntity);
		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
            .dateOfBirth(userEntity.getDateOfBirth())
            .phone(userEntity1.getPhonesEntity().getPhone())
			.build();
	}


	@Override
	public Optional<AccountDto> createAccount(long userId, AccountDto accountDto) {
		AccountEntity account = new AccountEntity();
		account.setType(accountDto.getType().toString());
		account.setAmount(Long.parseLong(accountDto.getAmount()));
		account.setUserEntity(UserDtoToEntityUser(getUserById(String.valueOf(userId)).get()));
        Optional<AccountDto> accountDto1 = getAccountByTypeAndUserId(accountDto.getType().toString(),userId);
        if(accountDto1.isPresent()){
            return accountDto1;
        }
		AccountEntity account1 = accountRepository.save(account);
		return (account!= null) ?
				Optional.of(
				AccountDto.builder()
				.accountNumber(String.valueOf(account1.getAccountNumber()))
				.amount(String.valueOf(account1.getAmount()))
				.userId(String.valueOf(account1.getUserEntity().getId()))
				.build()
				)
				: Optional.empty();
	}


	public AccountEntity dtoAccountToEntityAccount(AccountDto accountDto){
		AccountEntity ae = new AccountEntity();
		ae.setAmount(Long.parseLong(accountDto.getAmount()));
		ae.setType(accountDto.getType().toString());
		ae.setAccountNumber(Long.parseLong(accountDto.getAccountNumber()));
	return ae;
	}

	public UserEntity UserDtoToEntityUser(UserDto userDto){
		UserEntity ue = new UserEntity();
		ue.setLastName(userDto.getLastName());
		ue.setFirstName(userDto.getFirstName());
		ue.setDateOfBirth(userDto.getDateOfBirth());
		ue.setId(Long.valueOf(userDto.getId()));
		return ue;
	}
	public PhonesEntity phoneDtoToEntityPhone(UserDto userDto){
		PhonesEntity pe = new PhonesEntity();
		pe.setPhone(userDto.getPhone());
		return pe;
	}


	@Override
	public List<HistoryDto> getAllHistoryByUserId(long userId) {
		return historyRepository.searchAll(userId)
				.stream()
				.map(
						h -> HistoryDto.builder()
								.type(TypeAccountDto.valueOf(h.getType().toString()))
								.amount(h.getAmount())
								.userId(String.valueOf(h.getId()))
								.date(h.getDate().toString())
								.build()
				)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public void update(String id, UserDto userDto) {

	}

	@Override
	public String addMoney(long userId, long amount, String accountType) {
		String msg;
		Calendar currenttime = Calendar.getInstance();

		Date sqldate = new Date((currenttime.getTime()).getTime());

		try{
			System.out.print("---------> Date : "+sqldate+"\n");
			AccountDto accountDto = getAccountByTypeAndUserId(accountType,userId).get();
			//----------------- very bad way ... avoid ! -----------------
			long current = Long.parseLong(accountDto.getAmount());
			current = current + amount;
            //------------------------------------------------------------

			HistoryEntity h = new HistoryEntity();
			h.setAmount("+"+amount);
			h.setType(accountDto.getType().toString());
			h.setDate(sqldate);
			h.setUserEntity(UserDtoToEntityUser(getUserById(String.valueOf(userId)).get()));

            if(UserServiceUtils.validAccountType(accountDto.getType().name().toString())){
                accountRepository.updateAmount(current,Long.parseLong(accountDto.getAccountNumber()));
                historyRepository.save(h);
                msg="Vous avez déposé "+amount+" €";
            }else
                msg = "Dépôt non autorisé !";
		}catch (Exception e){
			//logger.info("Error on addMoney ! "+e);

			msg = "Erreur lors de l'ajout d'argent !";
		}
		return msg;
	}

	@Override
	public String removeMoney(long userId, long amount, String accountType) {
		String msg;
		Calendar currenttime = Calendar.getInstance();

		try{
			Date sqldate = new Date((currenttime.getTime()).getTime());

			AccountDto accountDto = getAccountByTypeAndUserId(accountType,userId).get();
			//----------------- very bad way ... avoid ! -----------------
			long current = Long.parseLong(accountDto.getAmount());
			current = current - amount;
            //------------------------------------------------------------


			HistoryEntity h = new HistoryEntity();
			h.setAmount("-"+amount);
			h.setType(accountDto.getType().toString());
			h.setDate(sqldate);
			h.setUserEntity(UserDtoToEntityUser(getUserById(String.valueOf(userId)).get()));

            if(UserServiceUtils.validAccountType(accountDto.getType().name().toString())){
                accountRepository.updateAmount(current,Long.parseLong(accountDto.getAccountNumber()));
				historyRepository.save(h);

				msg="Vous avez retiré"+amount+" €";
			}else
                msg = "Retrait non autorisé !";
		}catch (IllegalAccessError e){
			//logger.info("Error on removeMoney ! "+e);
			msg = "Erreur lors du retrait d'argent !";
		}
		return msg;
	}

	//NOT ALLOW TO USER TO remove or add money from LDDS account
	public boolean validAccountType(String type){

        if(type.equals("LDDS")){
            return false;
        }
        else
            return true;
	}
}
