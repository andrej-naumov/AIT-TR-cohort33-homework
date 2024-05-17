package java.basic.naumov.serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EmployeeOutputStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeOutputStream.class);

    private static String path = "employees.txt";

    public static void main(String[] args) {
        Employee employeeBatman = new Employee(1876, "Batman");
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(employeeBatman);
            outputStream.flush();
            LOGGER.info("Данные сотрудника успешно сохранены. id: {}", employeeBatman.getId());
        } catch (FileNotFoundException exception) {
            LOGGER.error("Файл {} не найден или не создан {}", path, exception.getMessage());
        } catch (IOException exception) {
            LOGGER.error("Ошибка в обработке данных. Файл {}, {}", path, exception.getMessage());
        }
    }
}