package com.wyu160802.dto;

/**
 * @author 黄明潘
 * @date 2019/7/26-20:32
 */
public class BaseResult {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL= 500;
    public int status;
    public String message;

    public BaseResult(){

    }

    public BaseResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static BaseResult success() {
        return getBaseResult(STATUS_SUCCESS, "成功");
    }

    public static BaseResult success(String message) {
        return getBaseResult(STATUS_SUCCESS, message);
    }

    public static BaseResult fail() {
        return getBaseResult(STATUS_FAIL, "失败");
    }

    public static BaseResult fail(String message) {
        return getBaseResult(STATUS_FAIL, message);
    }

    public static BaseResult fail(int status, String message) {
        return getBaseResult(status, message);
    }

    private static BaseResult getBaseResult(int status,String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
