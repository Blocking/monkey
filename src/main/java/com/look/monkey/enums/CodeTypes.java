package com.look.monkey.enums;

/**
 * 影院、院线编码类型
 *
 * @create 2017-05-24 17:12
 */
public enum CodeTypes {
    cinemaChain(10),
    cinema(10),
    unknown(-1);
    private int value;

    private CodeTypes(final int value) {
        this.value = value;
    }

    public static CodeTypes getCodeType(final int value) {
        for (final CodeTypes type : CodeTypes.values()) {
            if (type.getValue()==value) {
                return type;
            }
        }
        return CodeTypes.unknown;
    }

    public int getValue() {
        return this.value;
    }
}
