package fr.ekinci.dataaccessservice.user.repositories;

import fr.ekinci.dataaccessservice.user.entities.AccountEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Usman ABID BUTT on 01/11/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    @Modifying
    @Query("update account set amount = ?1 where account_number = ?2")
    @Transactional
    void updateAmount(long amount, long accountNb);

//
//    @Query("select a from account a where type=?1 and account_number=?2")
//    List<AccountEntity> getAccountByTypeAndUserId(String type, long userId);

    @Query("select a from account a where type = ?1 and user_entity_id = ?2")
    List<AccountEntity> getAccountByTypeAndUserId(String type, long userId);

    @Query("select a from account a where user_entity_id = ?1")
    List<AccountEntity> getAccountByTypeAndUserId(long userId);
}
