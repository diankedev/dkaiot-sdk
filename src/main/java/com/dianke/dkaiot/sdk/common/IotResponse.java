package com.dianke.dkaiot.sdk.common;

/**
 * @Description: SDK -> DKIOT 响应
 * @Author: bearx
 * @Date: 2023/02/22
 */
public class IotResponse {

	private int code;

	private String msg;

	private String data;

	public IotResponse() {
	}

	public IotResponse(int code, String msg, String data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public IotResponse setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public IotResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public String getData() {
		return data;
	}

	public IotResponse setData(String data) {
		this.data = data;
		return this;
	}

}
