import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Login1Test {

    private Login1 user;

    @Before
    public void setUp() {
        user = new Login1("usr_1", "Password1!", "John", "Doe");
    }

    @Test
    public void testCheckUsername() {
        assertTrue("Username should be valid", user.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue("Password should be valid", user.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() {
        assertEquals("Welcome John, Doe it is great to see you again.", user.registerUser());
    }

    @Test
    public void testLongUser() {
        assertTrue("Username and password should match", user.longUser("usr_1", "Password1!"));
    }

    @Test
    public void testReturnLoginStatus() {
        assertEquals("Welcome John, Doe it is great to see you again.", user.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again", user.returnLoginStatus(false));
    }
}

