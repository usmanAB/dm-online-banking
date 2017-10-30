package fr.ekinci.clientmanagement.user.entities;

import fr.ekinci.clientmanagement.user.models.UserDto;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Usman ABID BUTT on 30/10/2017.
 */


@Data
@Entity(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;

    @Column(name = "amount")
    private Double amount;

}
