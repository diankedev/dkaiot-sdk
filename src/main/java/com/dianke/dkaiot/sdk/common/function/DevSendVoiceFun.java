package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 下发语音给设备
 * @Author: bearx
 * @Date: 2023/02/24
 */
public class DevSendVoiceFun extends IotFunction {

	public DevSendVoiceFun() {
		this.auth = true;
		this.suffix = "/device/sendVoice";
	}

}
