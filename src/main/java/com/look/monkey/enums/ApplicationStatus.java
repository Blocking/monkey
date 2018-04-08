package com.look.monkey.enums;

/**
 * 申请状态  草稿-待初审-初审通过-初审未通过-待终审-终审通过-终审未通过-通过
 */
public enum ApplicationStatus {
	draft("草稿"), //草稿
	pendingTrial("待初审"), //待初审
    trialApproved("初审通过"),//初审通过
    trialRefused("初审不通过"), //初审不通过
    pendingFinal("待终审"), //待终审
    finalApproved("终审通过"),//终审通过
    finalRefused("终审未通过"), //终审未通过
    todoapprove("待审核"),  //待审核
    approve("审核通过"),       //审核通过
    approveRefuse("审核未通过"), //审核未通过
    unknown("");
    
    private String value;
    
    private ApplicationStatus(final String value) {
        this.value = value;
    }

    public static ApplicationStatus getCodeType(final String value) {
        for (final ApplicationStatus type : ApplicationStatus.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return ApplicationStatus.unknown;
    }

    public String getValue() {
        return this.value;
    }
    
}
