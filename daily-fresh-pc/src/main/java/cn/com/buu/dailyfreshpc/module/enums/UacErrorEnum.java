package cn.com.buu.dailyfreshpc.module.enums;

public enum UacErrorEnum {
    UAC_NULL_PARAM(6001, "缺少请求参数"),

    UAC_MOBILE_ILLEGAL(6002, "手机格式非法"),

    UAC_MAIL_ILLEGAL(6003, "邮箱格式非法"),

    UAC_USER_NOT_EXIST(6004, "用户不存在"),
    ;

    private int code;
    private String msg;

    public String msg() {
        return msg;
    }

    public int code() {
        return code;
    }

    UacErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static UacErrorEnum getEnum(int code) {
        for (UacErrorEnum ele : UacErrorEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }

}
