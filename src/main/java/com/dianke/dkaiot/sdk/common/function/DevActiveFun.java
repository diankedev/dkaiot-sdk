package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 设备激活
 * @Author: bearx
 * @Date: 2023/02/22
 */
public class DevActiveFun extends IotFunction {

	public DevActiveFun() {
		this.auth = true;
		this.suffix = "/device/active";
	}

}
