package com.dianke.dkaiot.sdk.common.function;

/**
 * @Description: 查询设备信息
 * @Author: bearx
 * @Date: 2023/02/24
 */
public class DevQueryFun extends IotFunction {

	public DevQueryFun() {
		this.auth = true;
		this.suffix = "/device/queryDev";
	}

}
