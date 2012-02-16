package com.humaorie.jresync;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrtTimeParser implements TimeParser {

    private static final Pattern srtTimeParser = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2}),(\\d{3}).*");

    @Override
    public long parse(String string) {
        Matcher matcher = srtTimeParser.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("cannot parse time '%s'", string));
        }

        long timeInMillis = 0;
        timeInMillis += TimeUnit.HOURS.toMillis(Long.parseLong(matcher.group(1)));
        timeInMillis += TimeUnit.MINUTES.toMillis(Long.parseLong(matcher.group(2)));
        timeInMillis += TimeUnit.SECONDS.toMillis(Long.parseLong(matcher.group(3)));
        timeInMillis += Long.parseLong(matcher.group(4));
        return timeInMillis;
    }
}
