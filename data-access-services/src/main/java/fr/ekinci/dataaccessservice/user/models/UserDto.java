package fr.ekinci.dataaccessservice.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * @author Gokan EKINCI
 */
@Data
@Builder
@ToString
public class UserDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}
}
