package lv.naumov.lesson56.event;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventScheduler scheduler = new EventScheduler();

        // Создание событий
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2);
        LocalDateTime superLater = now.plusHours(Integer.MAX_VALUE);
        LocalDateTime evening = now.plusHours(5);
        LocalDateTime superEvening = now.plusHours(Integer.MAX_VALUE);

        Event event1 = new Event("Meeting", now, later);
        Event event2 = new Event("Party", later, evening);
        Event event3 = new Event("Doomsday", superLater, superEvening);

        // Добавление событий в планировщик
        scheduler.addEvent(event1);
        scheduler.addEvent(event2);
        scheduler.addEvent(event3);

        // Удалим конец света
        scheduler.removeEvent(event3);

        // Получение всех событий
        System.out.println("All Events:");
        for (Event event : scheduler.getAllEvents()) {
            System.out.println(event.getName() + " from " + event.getStartDateTime() + " to " + event.getEndDateTime());
        }

        // Получение событий на конкретную дату
        LocalDateTime specificDate = LocalDateTime.of(2023, 12, 6, 0, 0);
        List<Event> eventsOnSpecificDate = scheduler.getEventsByDate(specificDate);
        System.out.println("\nEvents on " + specificDate.toLocalDate() + ":");
        for (Event event : eventsOnSpecificDate) {
            System.out.println(event.getName() + " from " + event.getStartDateTime() + " to " + event.getEndDateTime());
        }

        // Проверка пересечения времен двух событий
        boolean overlap = scheduler.doEventsOverlap(event1, event2);
        System.out.println("\nDo events overlap? " + overlap);
    }
}
