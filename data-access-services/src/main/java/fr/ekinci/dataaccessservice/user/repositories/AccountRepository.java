package fr.ekinci.dataaccessservice.user.repositories;

import fr.ekinci.dataaccessservice.user.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Usman ABID BUTT on 01/11/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}
