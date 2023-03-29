package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 更换绑定
 * @Author: bear
 * @Date: 2022/09/05
 */
public class ChangeBind {

	private String deviceId;
	private String phone;

	public String getDeviceId() {
		return deviceId;
	}

	public ChangeBind setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public ChangeBind setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
