package fr.ekinci.clientmodels.user.models;

import lombok.Builder;

/**
 * @author Gokan EKINCI
 */

@Builder
public class UserDto {
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//@Pattern(regexp = "[0-9]{1,}")
	private String id;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String firstName;
	private long phone;
	private String address;

}
