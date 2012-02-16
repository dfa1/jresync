package com.humaorie.jresync;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Test;

public class SrtResyncerTest {

    @Test
    public void canReplaceTime() throws IOException {
        final StringReader stringReader = new StringReader("00:00:00,000 --> 00:00:00,100");
        final StringWriter stringWriter = new StringWriter();
        final SrtResyncer resyncer = new SrtResyncer(new SrtTimeParser(), new SrtTimeFormatter());
        resyncer.resync(stringReader, stringWriter, 100);
        final String expected = "00:00:00,100 --> 00:00:00,200\n";
        final String got = stringWriter.toString();
        Assert.assertEquals(expected, got);
    }
    
    @Test
    public void ignoresLinesWithoutTime() throws IOException {
        final String expected = "I must be ignored\n";
        final StringReader stringReader = new StringReader(expected);
        final StringWriter stringWriter = new StringWriter();
        final SrtResyncer resyncer = new SrtResyncer(new SrtTimeParser(), new SrtTimeFormatter());
        resyncer.resync(stringReader, stringWriter, 100);
        final String got = stringWriter.toString();
        Assert.assertEquals(expected, got);
    }
}
