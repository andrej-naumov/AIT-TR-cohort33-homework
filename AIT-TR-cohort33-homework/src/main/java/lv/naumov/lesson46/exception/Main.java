package lv.naumov.lesson46.exception;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Users users = new Users();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу регистрации!");

        String username = "";
        String password = "";

        boolean isUsernameOk = false;
        boolean isPasswordOk = false;
        boolean isCanceled = false;

        // вводим имя пользователя
        while (!isUsernameOk) {
            System.out.println("Введите имя пользователя или exit для выхода из программы");
            username = scanner.next();

            if (username.equals("exit")) {
                isCanceled = true;
                System.out.println("Программа регистрации пользователя завершена");
                break;
            }

            // проверяем сначала имя пользователя
            try {
                isUsernameOk = PwdCheckTool.checkUsername(username);

                }
             catch (UserRegistrationException e) {
                // TODO

                }
        }

        while (!isCanceled && !isPasswordOk) {
            System.out.println("Ввведите пароль или exit для выхода из программы");
            password = scanner.next();

            if (password.equals("exit")) {
                System.out.println("Внимание! Пользователь не будет сохранён");
                System.out.println("Если хотите выйти из программы нажмите ещё раз exit");
                password = scanner.next();
                if (password.equals("exit")) {
                    System.out.println("Программа регистрации пользователя завершена");
                    isCanceled = true;
                    break;
                }
            }

            try {
                isPasswordOk = PwdCheckTool.checkPassword(password);
            } catch (UserRegistrationException e) {
                // TODO
            }
        }

        //
        if (isCanceled) {
            return;
        }

        //

        users.addUser(new User(username,password));


    }

}
