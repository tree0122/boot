package com.tree.boot.map.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 高德地图 缩放级别-比例尺
 * <p>
 * 20-10m-（19=<zoom<20）
 * 19-10m-（19=<zoom<20）
 * 18-25m-（18=<zoom<19）
 * 17-50m-（17=<zoom<18）
 * 16-100m-（16=<zoom<17）
 * 15-200m-（15=<zoom<16）
 * 14-500m-（14=<zoom<15）
 * 13-1km-（13=<zoom<14）
 * 12-2km-（12=<zoom<13）
 * 11-5km-（11=<zoom<12）
 * 10-10km-（10=<zoom<11）
 * 9-20km-（9=<zoom<10）
 * 8-30km-（8=<zoom<9）
 * 7-50km-（7=<zoom<8）
 * 6-100km-（6=<zoom<7）
 * 5-200km-（5=<zoom<6）
 * 4-500km-（4=<zoom<5）
 * 3-1000km-（3=<zoom<4）
 * 2-1000km-（3=<zoom<4）
 */

@Getter
public enum ScaleEnum {

    TWO(2, 1000 * 1000),
    THREE(3, 1000 * 1000),
    FOUR(4, 500 * 1000),
    FIVE(5, 200 * 1000),
    SIX(6, 100 * 1000),
    SEVEN(7, 50 * 1000),
    EIGHT(8, 30 * 1000),
    NINE(9, 10 * 1000),
    TEN(10, 10 * 1000),
    ELEVEN(11, 5 * 1000),
    TWELVE(12, 2 * 1000),
    THIRTEEN(13, 1 * 1000),
    FOURTEEN(14, 500),
    FIFTEEN(15, 200),
    SIXTEEN(16, 100),
    SEVENTEEN(17, 50),
    EIGHTEEN(18, 25),
    NINETEEN(19, 10);

    /**
     * 比例
     */
    private int scale;

    /**
     * 单位米
     */
    private long meter;

    ScaleEnum(int scale, long meter) {
        this.scale = scale;
        this.meter = meter;
    }
}
