package java.basic.naumov.lesson56.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Event {
    private String name;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
