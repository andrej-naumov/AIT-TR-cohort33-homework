package basic.naumov.lesson50.cmd;

import java.io.File;

public class RemoveFile {
    public static String rm(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                return String.format("Файл '%s' удален успешно.", fileName);
            } else {
                return String.format("Не удалось удалить файл '%s' .", fileName);
            }
        } else {
            return String.format("Файл '%s'  не существует.", fileName);
        }
    }
}
