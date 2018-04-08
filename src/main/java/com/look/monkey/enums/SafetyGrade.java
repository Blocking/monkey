package com.look.monkey.enums;

/**
 * Created by PH on 2018/3/12.
 */

/**
 * 安全等级
 */
public enum SafetyGrade {

    one_level("一级"),
    two_level("二级"),
    three_level("三级"),
    four_level("四级"),
    UNKNOWN("未知");

    private String value;

    private SafetyGrade(final String value) {
        this.value = value;
    }

    public static SafetyGrade getSafetyGrade(final String value) {
        for (final SafetyGrade type : SafetyGrade.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return SafetyGrade.UNKNOWN;
    }

    public String getValue() {
        return this.value;
    }
}
