package app.utils;

import java.time.Instant;

public class GetTimestamp {
    public static long getTimestamp() {
        Instant time = Instant.now();
        return time.toEpochMilli() / 1000;
    }
}
