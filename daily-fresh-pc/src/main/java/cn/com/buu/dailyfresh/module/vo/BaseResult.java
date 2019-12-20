package cn.com.buu.dailyfresh.module.vo;

import lombok.Data;

/**
 * 定义统一返回
 *
 * @author buu
 */
@Data
public class BaseResult {

    private static final int RESULT_OK = 200;
    private static final int RESULT_FAILED = 9999;
    private static final String SUCCESSFUL = "操作成功";
    private static final String FAILED = "操作失败";

    private int code;
    private Object data;
    private String msg;

    private BaseResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static BaseResult ok() {
        return createBaseResult(RESULT_OK, null, SUCCESSFUL);
    }

    public static BaseResult failed() {
        return createBaseResult(RESULT_FAILED, null, FAILED);
    }

    public static BaseResult ok(int code, String msg) {
        return createBaseResult(code, null, msg);
    }

    public static BaseResult ok(int code, Object data, String msg) {
        return createBaseResult(code, data, msg);
    }

    public static BaseResult ok(Object data) {
        return createBaseResult(RESULT_OK, data, SUCCESSFUL);
    }


    private static BaseResult createBaseResult(int code, Object data, String msg) {
        return new BaseResult(code, data, msg);
    }

}
