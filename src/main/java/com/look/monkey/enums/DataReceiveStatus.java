package com.look.monkey.enums;

/**
 * 上报方式（正常、晚报）
 *
 * @author
 */
public enum DataReceiveStatus {
    waitting, // 等待上报 white
    unreport, // 数据未上报 red
    nonbusiness, // 非营业日 yellow
    reported, // 正常上报 green
    overtime, // 票房晚报 blue
    corrected // 非正常上报 orange
}
