package fr.ekinci.dataaccessservice.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Usman ABID BUTT on 30/10/2017.
 */


@Data
@Entity(name = "account")
public class AccountEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number", insertable =false, updatable = false)
    private int accountNumber;


    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private int amount;
//(cascade = {CascadeType.PERSIST})
    @ManyToOne
    private UserEntity userEntity;
}
