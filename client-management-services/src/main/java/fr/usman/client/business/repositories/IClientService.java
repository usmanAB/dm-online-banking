package fr.usman.client.business.repositories;


import fr.usman.client.business.models.UserDto;

import java.util.List;

/**
 * Created by Usman on 16/10/2017.
 */

public interface IClientService {
    /**
     * This method gives all users from a UserDto List
     *
     * @return List of UserDto
     */
    public List<UserDto> getAllUsers();

    /**
     * Use this method to add an user into database with lastname (required) and firstname (required)
     * @param lastname String
     * @param firstname String
     * @return void
     */
    public void addUser(String lastname,String firstname);

    /**
     * Use this method to update an user into database.
     * @param lastname String
     * @param firstname String
     * @return
     */
    public void updateUser(String lastname,String firstname);

    /**
     * Use this method to delete an user into database.
     * @param id int
     * @return name of user
     */
    public String getUser(int id);

    /**
     * Use this method to delete a specific user
     * @param id int
     * @return name of user
     */
    public String deleteUser(int id);




}
