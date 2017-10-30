package fr.ekinci.clientmanagement.user.models;

import lombok.Data;
import lombok.ToString;

/**
 * @author Gokan EKINCI
 */
@Data
@ToString
public class UserDto {
	private String lastName;
	private String firstName;
	private long phone;
	private String address;

}
