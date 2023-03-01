package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 点可客户端信息
 * @Author: bearx
 * @Date: 2023/02/21
 */
public class DkClient {

	private String clientId;

	private String clientSecret;

	public String getClientId() {
		return clientId;
	}

	public DkClient setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public DkClient setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}

}
