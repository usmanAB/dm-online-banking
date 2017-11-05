package fr.ekinci.dataaccessservice.user.repositories;

import fr.ekinci.dataaccessservice.user.entities.HistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */
public interface HistoryRepository extends CrudRepository<HistoryEntity,Long> {


    @Query("select h from history h where user_entity_id = ?1")
    List<HistoryEntity> searchAll(long id);

}
