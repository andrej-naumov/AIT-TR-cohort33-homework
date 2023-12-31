package lv.naumov.lesson48.bank;

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