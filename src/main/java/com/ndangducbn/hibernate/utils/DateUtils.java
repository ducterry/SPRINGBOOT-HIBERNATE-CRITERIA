package com.ndangducbn.hibernate.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateUtils {
    public static ZonedDateTime toZoneDateTime(long milli) {
        Instant instant = Instant.ofEpochMilli(milli);
        return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
}
