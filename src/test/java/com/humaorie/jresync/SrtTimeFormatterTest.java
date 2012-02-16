package com.humaorie.jresync;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

public class SrtTimeFormatterTest {

    private final SrtTimeFormatter instance = new SrtTimeFormatter();

    @Test
    public void canFormatZero() {
        Assert.assertEquals("00:00:00,000", instance.format(0L));
    }

    @Test
    public void canFormatMillis() {
        Assert.assertEquals("00:00:00,001", instance.format(1L));
    }

    @Test
    public void canFormatSeconds() {
        Assert.assertEquals("00:00:01,000", instance.format(TimeUnit.SECONDS.toMillis(1)));
    }

    @Test
    public void canFormatMinutes() {
        Assert.assertEquals("00:01:00,000", instance.format(TimeUnit.MINUTES.toMillis(1)));
    }

    @Test
    public void canFormatHours() {
        Assert.assertEquals("01:00:00,000", instance.format(TimeUnit.HOURS.toMillis(1)));
    }
}