package java.basic.naumov.holiday.calendar;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class HolidayUpdater extends Thread {
    // Создание экземпляра календаря
    Calendar calendar = Calendar.getInstance();

    private HolidayCalendar holidayCalendar;
    private Action action;

    public HolidayUpdater(HolidayCalendar holidayCalendar, Action action) {
        this.holidayCalendar = holidayCalendar;
        this.action = action;
        calendar.set(Calendar.YEAR, 2024);
    }

    @Override
    public void run() {
        switch (action) {
            case ADD -> {
                List<Holiday> addHolidays = getHolidaysToAdd();
                for (Holiday holiday : addHolidays) {
                    holidayCalendar.addHoliday(holiday);
                }
            }

            case REMOVE -> {
            }
            default ->
                    log.warn("Неподдерживаемое действие");
        }
    }


    private List<Holiday> getHolidaysToAdd() {
        List<Holiday> holidaysToAdd = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        holidaysToAdd.add(new Holiday(1, "День взятия Бастилии", setDate(calendar, Calendar.JULY, 14)));
        holidaysToAdd.add(new Holiday(2,"День святого Валентина", setDate(calendar, Calendar.MARCH, 14)));
        holidaysToAdd.add(new Holiday(3,"День плохого программиста", setDate(calendar, Calendar.APRIL, 4)));
        holidaysToAdd.add(new Holiday(4,"День независимости", setDate(calendar, Calendar.JULY, 4)));
        holidaysToAdd.add(new Holiday(5,"Международный женский день", setDate(calendar, Calendar.MARCH, 8)));
        holidaysToAdd.add(new Holiday(6,"День матери", setDate(calendar, Calendar.MAY, 12)));
        holidaysToAdd.add(new Holiday(7, "День программиста", setDate(calendar, Calendar.SEPTEMBER, 13)));
        holidaysToAdd.add(new Holiday(8, "День рождения компании", setDate(calendar, Calendar.NOVEMBER, 1)));
        holidaysToAdd.add(new Holiday(9, "День космонавтики", setDate(calendar, Calendar.APRIL, 12)));
        holidaysToAdd.add(new Holiday(10,"День города", setDate(calendar, Calendar.AUGUST, 30)));

        return holidaysToAdd;
    }



    private static Date setDate(Calendar calendar, int month, int day) {
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}