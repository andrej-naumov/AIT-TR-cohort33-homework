package lv.naumov.lesson51.text;

import static lv.naumov.lesson51.text.ReadWriteFile.readFile;

public class TextEncryption {
    private final String inputFile;

    public TextEncryption(String inputFile) {
        this.inputFile = inputFile;
    }

    public String encryptedText() {
        String text = readFile(inputFile);
        return encryptText(text);
    }

    private String encryptText(String text) {
        char[] chars = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(ch))) { // только кириллица
                char encryptedChar = encryptCharacter(ch, i);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch); // оставляем символы, не являющиеся буквами, без изменений
            }
        }
        return encryptedText.toString();
    }

    private char encryptCharacter(char ch, int i) {
        char base = Character.isLowerCase(ch) ? 'а' : 'А'; // определяем базовую букву для регистра
        int shift = ch + ++i; // прибавляем сдвиг i+1

        char encryptedChar = (char) ((base + shift) % 32 + base); // модуль для всех букв алфавита
        return Character.isLowerCase(ch) ? Character.toLowerCase(encryptedChar) : Character.toUpperCase(encryptedChar);
    }
}
