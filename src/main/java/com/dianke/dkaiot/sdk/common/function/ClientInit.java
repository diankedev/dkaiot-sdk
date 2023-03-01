package com.dianke.dkaiot.sdk.common.function;

import cn.hutool.json.JSONObject;

/**
 * @Description: 客户端init
 * @Author: bearx
 * @Date: 2023/02/21
 */
public class ClientInit extends IotFunction {

	private JSONObject params = null;

	public ClientInit() {
		this.auth = false;
		this.suffix = "/sys/login";
	}

	@Override
	public JSONObject getParams() {
		return params;
	}

	@Override
	public ClientInit setParams(JSONObject params) {
		this.params = params;
		return this;
	}

}
