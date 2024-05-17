package basic.naumov.lesson51.text;


import static basic.naumov.lesson51.text.ReadWriteFile.readFile;

public class TextDecryption {
    private final String inputFile;

    public TextDecryption(String inputFile) {
        this.inputFile = inputFile;
    }

    public String decryptedText() {
        String text = readFile(inputFile);
        return decryptText(text);
    }

    private String decryptText(String text) {
        char[] chars = text.toCharArray();
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(ch))) { // только кириллица
                char encryptedChar = decryptCharacter(ch, i);
                decryptedText.append(encryptedChar);
            } else {
                decryptedText.append(ch); // оставляем символы, не являющиеся буквами, без изменений
            }
        }
        return decryptedText.toString();
    }

    private char decryptCharacter(char ch, int i) {
        char base = Character.isLowerCase(ch) ? 'а' : 'А'; // определяем базовую букву для регистра
        int shift = ch - ++i; // отнимаем сдвиг

        char decryptedChar = (char) ((base + shift) % 32 + base);
        return Character.isLowerCase(ch) ? decryptedChar : Character.toUpperCase(decryptedChar); // сохраняем регистр
    }


}
