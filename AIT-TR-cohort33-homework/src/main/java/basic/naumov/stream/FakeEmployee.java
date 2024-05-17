package basic.naumov.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FakeEmployee {
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private double hourRate;
}
