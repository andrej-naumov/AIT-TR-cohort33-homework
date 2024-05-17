package java.basic.naumov.lesson57.battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   Добро пожаловать в игру 'Морской бой'!");

        // Создаем доски для игрока и компьютера
        BattleshipGame playerBoard = new BattleshipGame(10);
        BattleshipGame computerBoard = new BattleshipGame(10);

        // размещаем корабли случайным образом
        playerBoard.placeShipsRandomly();
        computerBoard.placeShipsRandomly();

        while (!playerBoard.isGameOver() && !computerBoard.isGameOver()) {
            // Отображаем доски
            BattleshipGame.displayBothBoards(playerBoard, computerBoard);

            // Ход игрока
            boolean validPlayerMove = false;
            while (!validPlayerMove) {
                validPlayerMove = playerBoard.playerMove(computerBoard);
            }

            // Ход компьютера (это нужно реализовать)
            // ...

            // Отображаем доски после хода компьютера
            BattleshipGame.displayBothBoards(playerBoard, computerBoard);
        }

        // Определяем победителя и выводим сообщение
        if (playerBoard.isGameOver()) {
            System.out.println("Поздравляем, вы победили!");
        } else {
            System.out.println("Компьютер победил. Попробуйте еще раз!");
        }
    }
}

