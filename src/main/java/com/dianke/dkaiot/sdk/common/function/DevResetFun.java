package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 设备重置
 * @Author: bearx
 * @Date: 2023/02/23
 */
public class DevResetFun extends IotFunction {

	public DevResetFun() {
		this.auth = true;
		this.suffix = "/device/resetDev";
	}

}
