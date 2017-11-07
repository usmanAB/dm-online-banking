package fr.ekinci;

import fr.ekinci.clientmodels.user.models.AccountDto;
import fr.ekinci.clientmodels.user.models.TypeAccountDto;
import fr.ekinci.dataaccessservice.user.services.UserService;
import fr.ekinci.dataaccessservice.user.utils.UserServiceUtils;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.mockito.Mock;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UserServiceTest
    extends TestCase
{
    @Mock
    private UserServiceUtils userServiceUtils;
    @Mock
    private TypeAccountDto typeAccountDto;
    @Mock
    private AccountDto accountDto;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserServiceTest(String testName )
    {
        super( testName );
    }

    @Test
    public void testValidAccount(){
        boolean a = userServiceUtils.validAccountType("CC");
        Assert.assertTrue(a);

        boolean b = userServiceUtils.validAccountType("LDDS");
        Assert.assertFalse(b);

    }



}
