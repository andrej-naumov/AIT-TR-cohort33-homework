package lv.naumov.lesson51.text;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

        // входной файл
        String inputFile = "/input.txt";
        // зашифрованный файл
        String encryptedFile = "AIT-TR-cohort33-homework/src/main/resources/encrypted.txt";
        String encryptedResource = "/encrypted.txt";
        // дешифрованный файл
        String decryptedFile = "AIT-TR-cohort33-homework/src/main/resources/decrypted.txt";


        // Шаг 1 - читаем исходный файл и шифруем
        TextEncryption textEncryption = new TextEncryption(inputFile);
        String encryptedText = textEncryption.encryptedText();

        // Шаг 2 - записываем щифрованный текст в файл
        ReadWriteFile.writeToResource(encryptedFile, encryptedText);

        // Шаг 3 - читаем щифрованный текст и дешифруем
        TextDecryption textDecryption = new TextDecryption(encryptedResource);
        String decryptedText = textDecryption.decryptedText();

        // Шаг4 - записываем дешифрованный текст в файл
        ReadWriteFile.writeToResource(decryptedFile, decryptedText);

    }



}
