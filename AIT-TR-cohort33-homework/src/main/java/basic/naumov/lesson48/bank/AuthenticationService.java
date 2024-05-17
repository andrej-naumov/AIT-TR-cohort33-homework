package basic.naumov.lesson48.bank;

import java.util.logging.Level;
import java.util.logging.Logger;

// Класс для проверки аутентификации пользователей
class AuthenticationService {
    private static final User validUser = new User("user123", "password123");

    public void authenticate(String username, String password) {
        if (!validUser.getUsername().equals(username) || !validUser.getPassword().equals(password)) {
            logError("Authentication failed for user: " + username);
            throw new AuthenticationException("Authentication failed");
        }
        logInfo("Authentication successful for user: " + username);
    }

    // Пример использования java.util.logging для логирования
    private void logInfo(String message) {
        Logger.getLogger(AuthenticationService.class.getName()).log(Level.INFO, message);
    }

    private void logError(String message) {
        Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, message);
    }
}
