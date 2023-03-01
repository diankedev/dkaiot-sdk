package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 设备配置
 * @Author: bearx
 * @Date: 2023/02/24
 */
public class DevConfigFun extends IotFunction {

	public DevConfigFun() {
		this.auth = true;
		this.suffix = "/device/configDev";
	}

}
