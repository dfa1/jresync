package com.humaorie.jresync;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final String inFile = args[0];
        final String outFile = args[1];
        final String resyncDelay = args[2];
        final FileReader reader = new FileReader(inFile);
        final FileWriter writer = new FileWriter(outFile);
        final long resyncDelayInMillis = Long.parseLong(resyncDelay);
        final SrtResyncer resyncer = new SrtResyncer(new SrtTimeParser(), new SrtTimeFormatter());

        try {
            resyncer.resync(reader, writer, resyncDelayInMillis);
        } finally {
            writer.close();
            reader.close();
        }
    }
}
