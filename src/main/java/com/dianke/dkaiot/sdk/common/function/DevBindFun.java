package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 更换设备绑定人
 * @Author: bearx
 * @Date: 2023/02/22
 */
public class DevBindFun extends IotFunction {

	public DevBindFun() {
		this.auth = true;
		this.suffix = "/device/changeBind";
	}

}
