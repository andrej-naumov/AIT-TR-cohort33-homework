package lv.naumov.lesson46.exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Добро пожаловать в программу регистрации!");
        do {
            String username = getUsername(scanner, users);
            if (username.equals("exit")) {
                System.out.println("Программа регистрации пользователя завершена");
                return;
            }

            String password = getPassword(scanner);
            if (password.equals("exit")) {
                System.out.println("Программа регистрации пользователя завершена");
                return;
            }
            //
            users.addUser(new User(username, password));

        } while (wantToAddAnotherUser(scanner));
    }

    private static boolean wantToAddAnotherUser(Scanner scanner) {
        System.out.println("Хотите внести ещё одного пользователя? (да/нет)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("да");
    }

    private static String getUsername(Scanner scanner, Users users) {
        while (true) {
            System.out.println("Введите имя пользователя или exit для выхода из программы");
            String username = scanner.nextLine();

            if (username.equals("exit")) {
                return "exit";
            }

            if (users.isUserExists(username)) {
                System.out.println("Ошибка: Пользователь с таким именем уже существует.");
                continue;
            }

            try {
                PwdCheckTool.checkUsername(username);
                return username;
            } catch (UserRegistrationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static String getPassword(Scanner scanner) {
        while (true) {
            System.out.println("Введите пароль или exit для выхода из программы");
            String password = scanner.nextLine();
            if (password.equals("exit")) {
                System.out.println("Внимание! Пользователь не будет сохранён");
                System.out.println("Если хотите выйти из программы нажмите ещё раз exit");
                password = scanner.nextLine();
                if (password.equals("exit")) {
                    return "exit";
                }
            }

            try {
                PwdCheckTool.checkPassword(password);
                return password;
            } catch (UserRegistrationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

}
