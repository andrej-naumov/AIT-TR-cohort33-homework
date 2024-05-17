package basic.naumov.holiday.calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Holiday {
    private int id;
    private String name;
    private Date date;
}
