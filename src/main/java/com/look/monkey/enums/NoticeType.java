package com.look.monkey.enums;

/**
 * 通知类别
 */
public enum NoticeType {
    //管理规定，情况通报，工作需要，其他
    manageRegulation("管理规定"),
    bulletin("情况通报"),
    jobDemand("工作需要"),
    other("其他");

    private String value;

    NoticeType(final String value) {
        this.value = value;
    }
}
