package java.basic.naumov.holiday.calendar;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
public class HolidayCalendar {
    private final List<Holiday> holidays;

    public HolidayCalendar() {
        this.holidays = new ArrayList<>();
    }
    //private final Calendar calendar;

    public synchronized void addHoliday(Holiday holiday) {
        log.info("add holiday: {}", holiday);
        holidays.add(holiday);
    }

    public synchronized void removeHoliday(Holiday holiday) {
        log.info("remove holiday {}", holiday);
        holidays.remove(holiday);
    }

    public synchronized List<Holiday> getHolidaysForPeriod(Date startDate, Date endDate) {
        List<Holiday> holidaysInRange = new ArrayList<>();
        for (Holiday holiday : holidays) {
            Date holidayDate = holiday.getDate();
            if (holidayDate.after(startDate) && holidayDate.before(endDate)) {
                // TODO logging
                holidaysInRange.add(holiday);
            }
        }
        return holidaysInRange;
    }

    public synchronized boolean isHoliday(Date date) {
        for (Holiday holiday : holidays) {
            if (holiday.getDate().equals(date)) {
                // TODO: logging
                return true;
            }
        }
        // TODO: logging
        return false;
    }

}
