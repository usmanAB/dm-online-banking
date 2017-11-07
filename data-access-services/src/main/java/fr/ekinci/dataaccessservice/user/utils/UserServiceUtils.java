package fr.ekinci.dataaccessservice.user.utils;

/**
 * Created by Usman ABID BUTT on 07/11/2017.
 */
public class UserServiceUtils {



    //NOT ALLOW TO USER TO remove or add money from LDDS account
    public static boolean validAccountType(String type){

        if(type.equals("LDDS")){
            return false;
        }
        else
            return true;
    }
}
