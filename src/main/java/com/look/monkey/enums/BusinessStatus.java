package com.look.monkey.enums;

/**
 * 营业状态（营业,停业,注销）<br/>
 */
//接受平台相对应的状态1 测试 2 正常营业
public enum BusinessStatus {
    wait("未审核"), //未审核
    test("测试"), //测试
    open("营业"), //营业
    close("停业"), //停业
    cancel("注销"),//注销
    unknown("");

    private String value;

    BusinessStatus(final String value) {
        this.value = value;
    }

    public static BusinessStatus getCodeType(final String value) {
        for (final BusinessStatus type : BusinessStatus.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return BusinessStatus.unknown;
    }

    public String getValue() {
        return this.value;
    }

}
