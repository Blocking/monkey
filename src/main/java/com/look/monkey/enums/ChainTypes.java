package com.look.monkey.enums;

/**
 * Created by happy on 2017/5/18.
 */
public enum ChainTypes {
    wholeCountry("跨省院线"),
    provinces("省内院线"),
    unknown("");
    
    private String value;
    
    private ChainTypes(final String value) {
        this.value = value;
    }

    public static ChainTypes getCodeType(final String value) {
        for (final ChainTypes type : ChainTypes.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return ChainTypes.unknown;
    }

    public String getValue() {
        return this.value;
    }
}
