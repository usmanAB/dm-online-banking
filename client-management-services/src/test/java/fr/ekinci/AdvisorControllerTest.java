package fr.ekinci;

import fr.ekinci.clientmanagementservices.Advisor.controllers.AdvisorController;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.validation.constraints.AssertTrue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AdvisorControllerTest extends TestCase {

    @Mock
    private AdvisorController advisorController;



    //validAccountAge(UserInfoDto userInfoDto, AccountDto accountDto);
    @Test
    public void testValidAccountForYoung(){
        advisorController = new AdvisorController();
        boolean a = advisorController.validAccountAge("07-05-2005","LIVRETJEUNE");
        Assert.assertTrue(a);
    }

    @Test
    public void test0ValidAccountForAdult(){
        advisorController = new AdvisorController();
        boolean a = advisorController.validAccountAge("07-05-1994","LIVRETJEUNE");
        Assert.assertFalse(a);
    }

    @Test
    public void test2ValidAccount(){
        advisorController = new AdvisorController();
        boolean a = advisorController.validAccountAge("07-05-2005","CC");
        Assert.assertTrue(a);
    }

    @Test
    public void test3ValidAccount(){
        advisorController = new AdvisorController();
        boolean a = advisorController.validAccountAge("07-05-2005","LDD");
        Assert.assertTrue(a);
    }


    @Test
    public void testGetDiffYears() throws ParseException {
        advisorController = new AdvisorController();
        String dateN = "16-01-1994";
        String dateF = "16-01-2017";
        DateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date2 = formatDate.parse(dateN);
        Date date3 = formatDate.parse(dateF);
        int a = advisorController.getDiffYears(date2,date3);
        Assert.assertEquals(23,a);
    }
}
