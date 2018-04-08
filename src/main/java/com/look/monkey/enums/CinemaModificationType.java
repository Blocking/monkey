package com.look.monkey.enums;

/**
 * 变更类型
 */
public enum CinemaModificationType {
    application("注册申请"),//注册申请
    basicInfo("基础信息变更"), //基础信息变更
    cinemaIn("影院转入"), //影院转入
    cinemaOut("影院转出"), //影院转出
	 unknown("");
	private String value;
	
    private CinemaModificationType(final String value) {
        this.value = value;
    }

    public static CinemaModificationType getCodeType(final String value) {
        for (final CinemaModificationType type : CinemaModificationType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return CinemaModificationType.unknown;
    }

    public String getValue() {
        return this.value;
    }
    
    
}
	