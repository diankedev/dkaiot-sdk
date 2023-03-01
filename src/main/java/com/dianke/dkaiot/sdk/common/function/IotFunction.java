package com.dianke.dkaiot.sdk.common.function;

import cn.hutool.json.JSONObject;

/**
 * @Description: 功能接口
 * @Author: bearx
 * @Date: 2023/02/21
 */
public class IotFunction {

	public boolean auth = false;

	public String suffix = null;

	private JSONObject params = null;

	public boolean isAuth() {
		return auth;
	}

	public IotFunction setAuth(boolean auth) {
		this.auth = auth;
		return this;
	}

	public String getSuffix() {
		return suffix;
	}

	public IotFunction setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

	public JSONObject getParams() {
		return params;
	}

	public IotFunction setParams(JSONObject params) {
		this.params = params;
		return this;
	}

}
