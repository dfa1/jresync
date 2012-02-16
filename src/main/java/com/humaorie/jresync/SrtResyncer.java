package com.humaorie.jresync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class SrtResyncer {

    private final TimeParser timeParser;
    private final TimeFormatter timeFormatter;

    public SrtResyncer(TimeParser timeParser, TimeFormatter timeFormatter) {
        if (timeParser == null) {
            throw new IllegalArgumentException("time parser cannot be null");
        }
        
        if (timeFormatter == null) {
            throw new IllegalArgumentException("time parser cannot be null");
        }
        
        this.timeParser = timeParser;
        this.timeFormatter = timeFormatter;
    }

    public void resync(Reader reader, Writer writer, long resyncTimeInMillis) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("-->")) {
                final String[] timeRange = line.split(" --> ");
                long startTime = timeParser.parse(timeRange[0]);
                long endTime = timeParser.parse(timeRange[1]);
                line = String.format("%s --> %s",
                        timeFormatter.format(startTime + resyncTimeInMillis),
                        timeFormatter.format(endTime + resyncTimeInMillis));
            }

            writer.write(line);
            writer.write("\n");
        }
    }
}
