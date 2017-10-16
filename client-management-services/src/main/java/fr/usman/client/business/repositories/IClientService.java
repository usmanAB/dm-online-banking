package fr.usman.client.business.repositories;


/**
 * Created by Usman on 16/10/2017.
 */

public interface IClientService {

    public String getAllUsers();

    public String addUser(String lastname,String firstname);

    public String updateUser();

    public String getUser();

    public String deleteUser();




}
