package java.basic.naumov.holiday.calendar;

public class Main {

    public static void main(String[] args) {
        // Создание экземпляра календаря
        HolidayCalendar holidayCalendar = new HolidayCalendar();

        // Создание экземпляров HolidayUpdater с различными действиями
        HolidayUpdater addUpdater = new HolidayUpdater(holidayCalendar, Action.ADD); // Поток для добавления праздников
        HolidayUpdater removeUpdater = new HolidayUpdater(holidayCalendar, Action.REMOVE); // Поток для удаления праздников

        // Запуск потоков
        addUpdater.start();
        removeUpdater.start();





    }


}
