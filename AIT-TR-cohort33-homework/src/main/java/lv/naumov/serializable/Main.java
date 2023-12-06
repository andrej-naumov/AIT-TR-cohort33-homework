package lv.naumov.serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static String path = "AIT-TR-cohort33-homework/src/main/resources/employees.txt";

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Employee employee = (Employee) objectInputStream.readObject();
            LOGGER.info("Обьект успешно создан, ID: {}, Name: {}", employee.getId(), employee.getName());

        } catch (FileNotFoundException exception) {
            LOGGER.error("Файл {} не найден или не создан {}", path, exception.getMessage());

        } catch (IOException exception) {
            LOGGER.error("Ошибка в обработке данных. Файл {}, {}", path, exception.getMessage());

        } catch (ClassNotFoundException exception) {
            LOGGER.error("Ошибка в поиску класса для десериализации. {}", exception.getMessage());
        }


    }
}