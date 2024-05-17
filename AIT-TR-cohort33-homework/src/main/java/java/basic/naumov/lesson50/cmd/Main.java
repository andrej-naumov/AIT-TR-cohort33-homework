package java.basic.naumov.lesson50.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Введите команду (pwd, ls, cat, cp, mv, rm, mkdir, rmdir, touch, exit): ");
            try {
                String input = reader.readLine();

                if (input.equals("exit")) {
                    System.out.println("Программа завершена.");
                    break;
                }
            switch (input) {
                case "pwd":
                    System.out.println("Текущая директория: " + PresentWorkingDirectory.pwd());
                    break;
                case "ls":
                    System.out.println("Содержание текущей директории:");
                    System.out.println(ListingDirectory.ls(PresentWorkingDirectory.pwd()));
                    break;
                case "touch":
                    System.out.print("Введите имя нового файла:");
                    input = reader.readLine();
                    System.out.println(TouchFile.touch(input));
                    break;
                case  "cp":
                    // TODO
                    break;
                case  "mv":
                    // TODO
                    break;
                case "rm":
                    System.out.print("Введите имя файла для удаления:");
                    input = reader.readLine();
                    System.out.println(RemoveFile.rm(input));
                    break;
                case "mkdir":
                    System.out.print("Введите имя новой директории:");
                    input = reader.readLine();
                    System.out.println(CreateDirectory.mkdir(input));
                    break;
                case "rmdir":
                    System.out.print("Введите имя директории для удаления:");
                    input = reader.readLine();
                    System.out.println(RemoveDirectory.rmdir(input));
                    break;
                default:
                    System.out.println("Неверная команда");
            }

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                // reader.close();
            }
        }
    }
}
