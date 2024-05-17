package java.basic.naumov.lesson53.serial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
@AllArgsConstructor
public class Animal implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Идентификатор версии для контроля сериализации
    private String name;
    private String species;
    private int age;
}
