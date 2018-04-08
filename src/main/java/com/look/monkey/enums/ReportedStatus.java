package com.look.monkey.enums;

public enum ReportedStatus {
	  success("成功"), //成功
	    fail("失败"), //失败
	unknown("未知");

	private String value;

	private ReportedStatus(final String value) {
		this.value = value;
	}

	public static ReportedStatus getCodeType(final String value) {
		for (final ReportedStatus type : ReportedStatus.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return ReportedStatus.unknown;
	}

	public String getValue() {
		return this.value;
	}
}
