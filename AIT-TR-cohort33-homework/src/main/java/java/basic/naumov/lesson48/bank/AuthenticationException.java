package java.basic.naumov.lesson48.bank;

// Исключение для аутентификации
class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}