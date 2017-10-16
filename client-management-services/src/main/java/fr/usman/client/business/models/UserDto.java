package fr.usman.client.business.models;

/**
 * Created by Usman on 16/10/2017.
 */
public class UserDto {
    private String lastname;
    private String firstname;

    public UserDto(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


}
