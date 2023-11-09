package lv.naumov.lesson46.exception;

public class PwdCheckTool {

    public static void checkUsername(String name) throws UserRegistrationException {
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            throw new UserRegistrationException("Имя пользователя должно содержать только буквы и цифры.");
        }
    }

    public static void checkPassword(String password) throws UserRegistrationException {
        if (password.length() < 8) {
            throw new UserRegistrationException("Пароль должен быть не менее 8 символов.");
        }

        if (!password.matches(".*\\d.*")) {
            throw new UserRegistrationException("Пароль должен содержать хотя бы одну цифру.");
        }

        if (!password.matches(".*[!@#].*")) {
            throw new UserRegistrationException("Пароль должен содержать хотя бы один специальный символ (!, @, #).");
        }
    }
}

