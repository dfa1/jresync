package com.humaorie.jresync;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

public class SrtTimeParserTest {

    private final SrtTimeParser instance = new SrtTimeParser();

    @Test
    public void canParseZero() {
        final long time = instance.parse("00:00:00,000");
        Assert.assertEquals(0L, time);
    }

    @Test
    public void canParseMillis() {
        final long got = instance.parse("00:00:00,100");
        final long expected = TimeUnit.MILLISECONDS.toMillis(100);
        Assert.assertEquals(expected, got);
    }

    @Test
    public void canParseSeconds() {
        final long got = instance.parse("00:00:01,000");
        final long expected = TimeUnit.SECONDS.toMillis(1);
        Assert.assertEquals(expected, got);
    }

    @Test
    public void canParseMinutes() {
        final long got = instance.parse("00:02:00,000");
        final long expected = TimeUnit.MINUTES.toMillis(2);
        Assert.assertEquals(expected, got);
    }

    @Test
    public void canParseHours() {
        final long got = instance.parse("01:00:00,000");
        final long expected = TimeUnit.HOURS.toMillis(1);
        Assert.assertEquals(expected, got);
    }
}
