package com.tree.boot.util;

import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    /**
     * 当前时间戳，精确到毫秒
     *
     * @return
     */
    public static Long epochMilli() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 当前时间戳，精确到秒
     *
     * @return
     */
    public static Long epochSecond() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取指定格式的时间字符串
     *
     * @param milli
     * @param format
     * @param timeZoneOffset
     * @return
     */
    public static String format(Long milli, String format, Integer timeZoneOffset) {
        Assert.notNull(milli, "milli is null");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(milli),
                ZoneOffset.ofHours(timeZoneOffset)));
    }

    /**
     * 获取指定时间的时间戳
     *
     * @param time
     * @param format
     * @param timeZoneOffset
     * @return
     */
    public static Long milli(String time, String format, Integer timeZoneOffset) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime parse = LocalDateTime.parse(time, formatter);
        return LocalDateTime.from(parse)
                .atZone(ZoneOffset.ofHours(timeZoneOffset))
                .toInstant()
                .toEpochMilli();

    }


}
