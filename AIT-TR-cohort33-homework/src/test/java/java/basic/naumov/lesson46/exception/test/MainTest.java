package java.basic.naumov.lesson46.exception.test;

import java.basic.naumov.lesson46.exception.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    void testUserRegistration() {
        // Моделируем ввод пользователя
        String input = "user123\r\npassword!2\r\nнет\r\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Запускаем тест
        Main.main(new String[]{});

        // Проверяем ожидаемый вывод
        String expectedOutput = "Добро пожаловать в программу регистрации!\r\n" +
                "Введите имя пользователя или exit для выхода из программы\r\n" +
                "Введите пароль или exit для выхода из программы\r\n" +
                "Хотите внести ещё одного пользователя? (да/нет)\r\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
