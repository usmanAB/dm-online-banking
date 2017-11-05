package fr.ekinci.dataaccessservice.user.entities;

import fr.ekinci.clientmodels.user.models.HistoryDto;
import fr.ekinci.clientmodels.user.models.PhonesDto;
import lombok.Data;

import javax.persistence.*;
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

	@Column(name = "dateOfBirth")
	private String dateOfBirth;


   // @JoinColumn(name="id", referencedColumnName="account_number")
	//private AccountEntity accountEntity;
//    @OneToMany(mappedBy = "Advisor")
    private AccountEntity accountEntity;

	private HistoryEntity historyEntity;


	private PhonesEntity phonesEntity;


	@OneToMany(mappedBy = "userEntity")
	public Set<HistoryEntity> history;


	@OneToMany(mappedBy = "userEntity")
    public Set<AccountEntity> account;


	@OneToMany(mappedBy = "userEntity")
	public Set<PhonesEntity> phones;
}