package com.mycompany.prog5121poepart1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNGTest {
    private PROG5121POEPART1 login;

    @BeforeMethod
    public void setUp() {
        login = new PROG5121POEPART1("kyle", "smith");
    }

    @Test
    public void testValidUsername() {
        Assert.assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testValidPassword() {
        Assert.assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testValidCellPhone() {
        Assert.assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testInvalidCellPhone() {
        Assert.assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testSuccessfulLogin() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Assert.assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testFailedLogin() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Assert.assertFalse(login.loginUser("kyl_1", "wrongPass"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String message = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        Assert.assertEquals(message, "Welcome kyle ,smith it is great to see you again.");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String message = login.returnLoginStatus("kyl_1", "wrongPass");
        Assert.assertEquals(message, "Username or password incorrect, please try again.");
    }
}
