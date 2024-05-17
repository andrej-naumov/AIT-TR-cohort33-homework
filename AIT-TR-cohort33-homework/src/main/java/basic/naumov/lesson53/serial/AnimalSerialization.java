package basic.naumov.lesson53.serial;

import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@Slf4j
public class AnimalSerialization {
    public static void serializeAnimals(List<Animal> animals, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            for (Animal animal : animals) {
                out.writeObject(animal);
            }
            log.info("Информация обо всех животных записана в файл " + filePath);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }
}
