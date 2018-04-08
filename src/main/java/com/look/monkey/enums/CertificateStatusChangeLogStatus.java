package com.look.monkey.enums;

/**
 * Usbkey状态 ：启用、停用、注销、记录已关闭
 *
 * @author
 */
public enum CertificateStatusChangeLogStatus {
    active("启用"),
    deactive("停用"),
    destroyed("注销")
//    ,
//    recordInvalid("记录已关闭")
    ;

    private String title;

    CertificateStatusChangeLogStatus(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
