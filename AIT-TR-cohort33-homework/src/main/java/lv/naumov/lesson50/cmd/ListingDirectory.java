package lv.naumov.lesson50.cmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDirectory {
    public static String ls(String path) throws IOException {
        Path directoryPath = Paths.get(path); // Путь к директории, которую хотите просмотреть
        StringBuilder listing = new StringBuilder();
        Files.list(directoryPath)
                .map(Path::getFileName)
                .forEach(fileName -> listing.append(fileName).append("\n"));
        return listing.toString();
    }

}
