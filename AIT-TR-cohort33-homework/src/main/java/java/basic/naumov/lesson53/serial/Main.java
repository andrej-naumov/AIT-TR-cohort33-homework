package java.basic.naumov.lesson53.serial;

import java.util.List;

public class Main {
    // Указываем путь к файлу для сохранения сериализованных данных
    static String filePath = "AIT-TR-cohort33-homework/src/main/resources/serializabled.txt";

    // Создаем список животных
    static List<Animal> animalList = List.of(
            new Animal("Барсик", "Кот", 5),
            new Animal("Шарик", "Собака", 3),
            new Animal("Рыжик", "Кот", 4)
            // другие объекты Animal, если необходимо
    );

    public static void main(String[] args) {
        // выводим на консоль всех животных
        printAnimals(animalList);
        // Вызываем метод для сериализации списка животных в файл
        AnimalSerialization.serializeAnimals(animalList, filePath);

        System.out.println(" --------------------");

        // Вызываем метод для десериализации списка животных из файла
        List<Animal> deserializedAnimals = AnimalDeserialization.deserializeAnimals(filePath);

        // выводим на консоль всех десериализированных животных
        printAnimals(deserializedAnimals);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.getName() + ", Вид: " + animal.getSpecies() + ", Возраст: " + animal.getAge());
        }
    }
}
