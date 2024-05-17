package java.basic.naumov.lesson46.exception.test;

import static org.junit.jupiter.api.Assertions.*;

import java.basic.naumov.lesson46.exception.PwdCheckTool;
import java.basic.naumov.lesson46.exception.UserRegistrationException;
import org.junit.Test;


public class PwdCheckToolTest {

    @Test
    public void testCheckUsernameValid() {
        // Тестирование валидного имени пользователя
        assertDoesNotThrow(() -> PwdCheckTool.checkUsername("validUsername"));
    }

    @Test
    public void testCheckUsernameInvalid() {
        // Тестирование невалидного имени пользователя
        assertThrows(UserRegistrationException.class, () -> {
            PwdCheckTool.checkUsername("invalid@username");
        });
    }

    @Test
    public void testCheckPasswordValid() {
        // Тестирование валидного пароля
        assertDoesNotThrow(() -> PwdCheckTool.checkPassword("ValidPassword!123"));
    }

    @Test
    public void testCheckPasswordTooShort() {
        // Тестирование слишком короткого пароля
        assertThrows(UserRegistrationException.class, () -> {
            PwdCheckTool.checkPassword("Short!1");
        });
    }

    @Test
    public void testCheckPasswordNoDigit() {
        // Тестирование пароля без цифры
        assertThrows(UserRegistrationException.class, () -> {
            PwdCheckTool.checkPassword("NoDigit!");
        });
    }

    @Test
    public void testCheckPasswordNoSpecialChar() {
        // Тестирование пароля без специального символа
        assertThrows(UserRegistrationException.class, () -> {
            PwdCheckTool.checkPassword("NoSpecialChar123");
        });
    }
}
