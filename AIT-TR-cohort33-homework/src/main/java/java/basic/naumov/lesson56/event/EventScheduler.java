package java.basic.naumov.lesson56.event;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EventScheduler {
    private final List<Event> events;

    public EventScheduler() {
        this.events = new ArrayList<>();
    }

    // Методы для управления событиями
    public void addEvent(Event event) {
        log.info("Added event: " + event);
        events.add(event);
    }

    public void removeEvent(Event event) {
        log.info("Remove event: " + event);
        events.remove(event);
    }

    public List<Event> getAllEvents() {
        return events;
    }

    // Методы для управления временем событий
    public List<Event> getEventsByDate(LocalDateTime date) {
        int count = 0;
        log.info("get all events by date: {}", date);
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : events) {
            if (event.getStartDateTime().toLocalDate().isEqual(date.toLocalDate())) {
                eventsOnDate.add(event);
                log.info("added event" + event);
                count++;
            }
        }
        log.info("count of events: {}", count);

        return eventsOnDate;
    }

    public boolean doEventsOverlap(Event event1, Event event2) {
        log.info("overlap events ({}) and ({})", event1, event2);

        LocalDateTime start1 = event1.getStartDateTime();
        LocalDateTime end1 = event1.getEndDateTime();
        LocalDateTime start2 = event2.getStartDateTime();
        LocalDateTime end2 = event2.getEndDateTime();

        boolean isOverlap = (start1.isBefore(end2) || start1.isEqual(end2)) &&
                (end1.isAfter(start2) || end1.isEqual(start2));
        if (isOverlap) {
            log.info("is overlap");
        } else {
            log.info("not overlap");
        }

        return isOverlap;
    }
}
