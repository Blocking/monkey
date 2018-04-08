package com.look.monkey.enums;
/**
 * 筹建证/许可证
 */
public enum Enclosure {
	//筹建证
	preparation("筹建证"),
	//许可证
	licence("许可证"),
	unknown("");
	
	private String value;
    
    private Enclosure(final String value) {
        this.value = value;
    }

    public static Enclosure getCodeType(final String value) {
        for (final Enclosure type : Enclosure.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return Enclosure.unknown;
    }

    public String getValue() {
        return this.value;
    }
}
