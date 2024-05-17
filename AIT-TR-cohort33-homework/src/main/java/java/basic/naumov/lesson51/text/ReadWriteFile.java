package java.basic.naumov.lesson51.text;

import java.io.*;

public class ReadWriteFile {
    // Метод для чтения текста из файла
    public static String readFile(String inputFile) {
        InputStream inputStream = ReadWriteFile.class.getResourceAsStream(inputFile);
        StringBuilder text = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            try (BufferedReader reader = new BufferedReader(streamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return text.toString();
    }


    public static void writeToResource(String outputFile, String content) {
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            if (outputStream != null) {
                writer.write(content);
            } else {
                throw new IOException("Output stream creation failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
