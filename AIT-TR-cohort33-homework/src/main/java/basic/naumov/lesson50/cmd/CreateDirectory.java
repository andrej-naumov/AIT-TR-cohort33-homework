package basic.naumov.lesson50.cmd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectory {
    public static String mkdir(String directoryName)  {
        File directory = new File(directoryName);
        if(directory.exists()) {
            return String.format("Директория '%s' уже существует.", directoryName);
        }

        try {
            Path newDirectoryPath = Paths.get(directoryName);
            Files.createDirectory(newDirectoryPath);
            return String.format("Директория '%s' создана успешно.", directoryName);
        } catch (IOException e) {
            return ("Ошибка при создании директории: " + e.getMessage());
        }
    }

}
