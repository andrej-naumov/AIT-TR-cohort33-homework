package lv.naumov.lesson56.event;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

public class EventSchedulerTest {

    @Test
    public void testAddRemoveEventAndRetrieveAllEvents() {
        EventScheduler scheduler = new EventScheduler();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2);

        Event event1 = new Event("Meeting1", now, later);
        Event event2 = new Event("Meeting2", now, later);
        scheduler.addEvent(event1);
        scheduler.addEvent(event2);

        scheduler.removeEvent(event2);

        List<Event> events = scheduler.getAllEvents();
        assertEquals(1, events.size());
        assertEquals("Meeting1", events.get(0).getName());
    }

    @Test
    public void testGetEventsByDate() {
        EventScheduler scheduler = new EventScheduler();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2);

        Event event1 = new Event("Meeting", now, later);
        scheduler.addEvent(event1);

        LocalDateTime specificDate = now.toLocalDate().atStartOfDay();
        List<Event> eventsOnSpecificDate = scheduler.getEventsByDate(specificDate);

        assertEquals(1, eventsOnSpecificDate.size());
        assertEquals("Meeting", eventsOnSpecificDate.get(0).getName());
    }

    @Test
    public void testDoEventsOverlap() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2);
        LocalDateTime evening = now.plusHours(3);

        Event event1 = new Event("Event 1", now, later);
        Event event2 = new Event("Event 2", later, evening);

        EventScheduler scheduler = new EventScheduler();
        assertTrue(scheduler.doEventsOverlap(event1, event2));
    }
}

