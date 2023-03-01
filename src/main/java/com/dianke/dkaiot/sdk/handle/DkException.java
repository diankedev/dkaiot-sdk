package com.dianke.dkaiot.sdk.handle;

/**
 * @Description: 自定义异常
 * @Author: bearx
 * @Date: 2023/02/16
 */
public class DkException extends RuntimeException {

	/**
	 * 错误码 SUCCESS、FALL、WARN
	 */
	private String errCode;

	/**
	 * 错误信息
	 */
	private String errMsg;

	public DkException(String errCode, String errMsg) {
		super(errCode);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
