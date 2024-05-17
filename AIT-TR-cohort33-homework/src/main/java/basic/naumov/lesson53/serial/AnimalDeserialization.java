package basic.naumov.lesson53.serial;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class AnimalDeserialization {

    public static List<Animal> deserializeAnimals(String filePath) {
        List<Animal> animals = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (fileIn.available() > 0) {
                Animal animal = (Animal) in.readObject();
                animals.add(animal);
            }

            log.info("Информация обо всех животных прочитана из файла " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.toString());
        }

        return animals;
    }
}

