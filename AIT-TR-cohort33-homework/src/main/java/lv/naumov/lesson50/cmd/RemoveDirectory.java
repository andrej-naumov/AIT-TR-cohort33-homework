package lv.naumov.lesson50.cmd;

import java.io.File;

public class RemoveDirectory {

    public static String rmdir(String directoryName) {
        File directory = new File(directoryName);

        if (directory.exists() && directory.isDirectory()) {
            if (directory.delete()) {
                return String.format("Директория '%s' удалена успешно.", directoryName);
            } else {
                return String.format("Не удалось удалить директорию '%s'.", directoryName);
            }
        } else {
            return String.format("Директория '%s' не существует или это не директория.", directoryName);
        }
    }
}
