package fr.ekinci.clientservices.user.restutils;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.HistoryDto;
import fr.ekinci.clientmodels.user.models.UserDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Usman ABID BUTT on 05/11/2017.
 */
public class Rest {


    public static String addMoney(long id,long amount,String accountType) {
        System.out.print("----> APPEL addMoney FROM CLIENT REST  :"+id+" \n");

        final String uri = "http://localhost:25002/data-access/client/addMoney/{id}/{amount}/{accountType}";

        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.postForObject(uri,null,String.class,id,amount,accountType);
        return msg;
    }

    public static String removeMoney(long id,long amount,String accountType) {
        System.out.print("----> APPEL remove FROM CLIENT REST  :"+id+" \n");

        final String uri = "http://localhost:25002/data-access/client/removeMoney/{id}/{amount}/{accountType}";

        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.postForObject(uri,null,String.class,id,amount,accountType);
        return msg;
    }




    public static List<AccountDto> getAccountsByUserId(String id) {
        System.out.print("----> APPEL getAccountsByUserId FROM CLIENT REST  :"+id+" \n");

        final String uri = "http://localhost:25002/data-access/client/consultAccount/{id}";

        RestTemplate restTemplate = new RestTemplate();
        List<AccountDto> list = restTemplate.getForObject(uri,List.class,id);
        return list;
    }

    public static List<HistoryDto> getAllHistoryByUserId(long id) {
        System.out.print("----> APPEL getAllHistoryByUserId FROM CLIENT REST  :"+id+" \n");

        final String uri = "http://localhost:25002/data-access/client/historyInfo/{id}";

        RestTemplate restTemplate = new RestTemplate();
        List<HistoryDto> list = restTemplate.getForObject(uri,List.class,id);
        return list;
    }
}
