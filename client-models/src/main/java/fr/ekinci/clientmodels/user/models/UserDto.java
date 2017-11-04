package fr.ekinci.clientmodels.user.models;

import lombok.Builder;

/**
 * @author Gokan EKINCI
 */

//@Builder
public class UserDto {
	private String lastName;
	//@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private String firstName;
	private long phone;
	private String address;

}
