package com.tree.boot.map.enums;

import lombok.Getter;

/**
 * mapScale --> geohash
 * 11 -- 5
 * 14 -- 6
 * 15 -- 7
 * <p>
 * <p>
 * geohash长度	Lat位数	Lng位数	Lat误差	Lng误差	km误差
 * 1	2	3	±23	±23	±2500
 * 2	5	5	± 2.8	±5.6	±630
 * 3	7	8	± 0.70	± 0.7	±78
 * 4	10	10	± 0.087	± 0.18	±20
 * 5	12	13	± 0.022	± 0.022	±2.4
 * 6	15	15	± 0.0027	± 0.0055	±0.61
 * 7	17	18	±0.00068	±0.00068	±0.076
 * 8	20	20	±0.000086	±0.000172	±0.01911
 * 9	22	23	±0.000021	±0.000021	±0.00478
 * 10	25	25	±0.00000268	±0.00000536	±0.0005971
 * 11	27	28	±0.00000067	±0.00000067	±0.0001492
 * 12	30	30	±0.00000008	±0.00000017	±0.0000186
 */
@Getter
public enum GeohashEnum {

    ONE(1, 2500 * 1000),
    TWO(2, 630 * 1000),
    THREE(3, 78 * 1000),
    FOUR(4, 20 * 1000),
    FIVE(5, 2.4 * 1000),
    SIX(6, 0.61 * 1000),
    SEVEN(7, 0.076 * 1000),
    EIGHT(8, 0.01911 * 1000),
    NINE(9, 0.00478 * 1000),
    TEN(10, 0.0005971 * 1000),
    ELEVEN(11, 0.0001492 * 1000),
    TWELVE(12, 0.0000186 * 1000);

    /**
     * geohash长度
     */
    private int length;

    /**
     * 单位 米
     */
    private double scale;

    GeohashEnum(int length, double scale) {
        this.length = length;
        this.scale = scale;
    }

}
