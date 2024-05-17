package java.basic.naumov.lesson50.cmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class TouchFile {
    public static String touch(String fileName) {
        Path path = Paths.get(fileName);

        if (Files.exists(path)) {
            // Файл уже существует - обновляем время модификации
            try {
                Files.setLastModifiedTime(path, FileTime.from(Instant.now()));
                return String.format("Время модификации файла '%s' обновлено.", fileName);
            } catch (IOException e) {
                return "Ошибка при обновлении времени модификации: " + e.getMessage();
            }
        } else {
            // Файл не существует - создаем новый пустой файл
            try {
                Files.createFile(path);
                return  String.format("Файл '%s' создан успешно.", fileName);
            } catch (IOException e) {
                return "Ошибка при создании файла: " + e.getMessage();
            }
        }
    }
}
