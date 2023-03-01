package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 设备重启
 * @Author: bearx
 * @Date: 2023/02/23
 */
public class DevRebootFun extends IotFunction {

	public DevRebootFun() {
		this.auth = true;
		this.suffix = "/device/rebootDev";
	}

}
