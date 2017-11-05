package fr.ekinci.dataaccessservice.user.entities;

import fr.ekinci.clientmodels.user.models.TypeAccountDto;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */

@Data
@Entity(name = "history")
public class HistoryEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable =false, updatable = false)
    private Long id;
    @Column(name = "date_operation")
    private Date date;
    @Column(name = "amount")
    private String amount;
    @Column(name = "type")
    private String type;

    @ManyToOne
    private UserEntity userEntity;

}
