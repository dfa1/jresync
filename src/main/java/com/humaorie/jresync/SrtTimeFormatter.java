package com.humaorie.jresync;

public class SrtTimeFormatter implements TimeFormatter {

    @Override
    public String format(long timeInMillis) {
        long millis = timeInMillis % 1000;
        long seconds = timeInMillis / (1000) % 60;
        long minutes = timeInMillis / (1000 * 60) % 60;
        long hours = timeInMillis / (1000 * 60 * 60);
        return String.format("%02d:%02d:%02d,%03d",
                hours,
                minutes,
                seconds,
                millis);
    }
}
