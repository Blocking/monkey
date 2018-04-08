package com.look.monkey.enums;

/**
 * 场地属性 影吧、咖啡厅、汽车4s店、KTV、酒店、宾馆、社区、企业内部、其他
 */
public enum CinemaPlaceType {
	celluloide("影吧"),coffeeHouse("咖啡厅"),car4SShop("汽车4s店"),KTV("KTV"),
	hotel("酒店"),guestHouse("宾馆"),community("社区"),internalEnterprise("企业内部"),other("其他"),unknown("");
	
	private String value;

    private CinemaPlaceType(final String value) {
        this.value = value;
    }

    public static CinemaPlaceType getCodeType(final String value) {
        for (final CinemaPlaceType type : CinemaPlaceType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return CinemaPlaceType.unknown;
    }

    public String getValue() {
        return this.value;
    }
}
