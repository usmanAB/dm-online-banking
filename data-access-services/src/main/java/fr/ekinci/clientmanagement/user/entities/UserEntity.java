package fr.ekinci.clientmanagement.user.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
@Entity(name = "users")
public class UserEntity implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

   // @JoinColumn(name="id", referencedColumnName="account_number")
	//private AccountEntity accountEntity;
//    @OneToMany(mappedBy = "user")
    private AccountEntity accountEntity;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public AccountEntity getAccountEntity() {
        return this.accountEntity;
    }


}