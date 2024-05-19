package pro.naumov.home001;

public class Thread_ImplementRunnable implements Runnable {
    private final int start;
    private final int end;
    private final int divideWithoutRemainder;
    private final int digit;

    public Thread_ImplementRunnable(int start, int end, int divideWithoutRemainder, int digit) {
        this.start = start;
        this.end = end;
        this.divideWithoutRemainder = divideWithoutRemainder;
        this.digit = digit;
    }

    @Override
    public void run() {
        FindNumbers.inRangeWithConditions(start, end, divideWithoutRemainder, digit);
    }
}

