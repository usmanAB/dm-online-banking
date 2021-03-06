package fr.ekinci.dataaccessservice.user.repositories;

import fr.ekinci.dataaccessservice.user.entities.PhonesEntity;
import fr.ekinci.dataaccessservice.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	List<UserEntity> findAll();
	void save(PhonesEntity phonesEntity);
}
