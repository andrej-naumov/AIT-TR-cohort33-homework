package basic.naumov.lesson50.cmd;

import java.nio.file.Path;

public class PresentWorkingDirectory {

    public static String  pwd() {
        Path currentWorkingDir = java.nio.file.Paths.get("");
        return "" + currentWorkingDir.toAbsolutePath();
    }
}
