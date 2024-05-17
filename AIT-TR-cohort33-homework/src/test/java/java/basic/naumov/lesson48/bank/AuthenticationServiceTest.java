package java.basic.naumov.lesson48.bank;

import naumov.lesson48.bank.AuthenticationException;
import naumov.lesson48.bank.AuthenticationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    @Test
    void testAuthenticateSuccess() {
        AuthenticationService authService = new AuthenticationService();
        authService.authenticate("user123", "password123");
        // If no exception is thrown, the test passes
    }

    @Test
    void testAuthenticateFailure() {
        AuthenticationService authService = new AuthenticationService();
        assertThrows(AuthenticationException.class, () -> authService.authenticate("invalidUser", "invalidPassword"));
    }
}