package com.dianke.dkaiot.sdk.handle;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.dianke.dkaiot.sdk.client.DkIotClient;
import com.dianke.dkaiot.sdk.common.IotResponse;
import com.dianke.dkaiot.sdk.common.dto.DkClient;
import com.dianke.dkaiot.sdk.common.function.ClientInit;
import com.dianke.dkaiot.sdk.common.function.IotFunction;
import com.dianke.dkaiot.sdk.http.IotTokenResponse;
import com.dianke.dkaiot.sdk.utils.HttpClientUtils;
import io.micrometer.core.instrument.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 维护Token活性
 * @Author: bearx
 * @Date: 2023/02/22
 */
public class TokenHandleSingle {

	private static final Log log = LogFactory.get(DkIotClient.class);

	private String client;

	private String secret;

	private IotTokenResponse iotToken;

	private ScheduledExecutorService REFRESH_TOKEN_SCHEDULED;

	/**
	 * 每分钟检查Token健康状态 1分钟后启动
	 */
	private TokenHandleSingle() {
		this.REFRESH_TOKEN_SCHEDULED = Executors
				.newSingleThreadScheduledExecutor(new NamedThreadFactory("DkIot-Token-Check"));
		this.REFRESH_TOKEN_SCHEDULED.scheduleWithFixedDelay(() -> {
			try {
				TokenHandleSingle.this.refreshTokenAndKeepAlive();
			}
			catch (Throwable var2) {
				TokenHandleSingle.log.error(
						"Unexpected error occur at 【DKAIOT】 token refresh, cause: " + var2.getMessage(),
						new Object[] { var2 });
			}

		}, 200L, 60L, TimeUnit.SECONDS);
	}

	public static synchronized TokenHandleSingle getInstance(String client, String secret) {
		TokenHandleSingle instance = SingletonHolder.INSTANCE;
		instance.setClient(client);
		instance.setSecret(secret);
		return instance;
	}

	private static class SingletonHolder {

		private static final TokenHandleSingle INSTANCE = new TokenHandleSingle();

		private SingletonHolder() {
		}

	}

	/**
	 * 刷新Token
	 */
	private IotTokenResponse refreshToken() {

		DkClient dkClient = new DkClient().setClientId(this.client).setClientSecret(this.secret);
		IotFunction function = new ClientInit().setParams(JSONUtil.parseObj(dkClient));
		IotResponse iotResponse;
		try {
			iotResponse = HttpClientUtils.doAction(function, null);
		}
		catch (DkException e) {
			log.error("【DK-IOT-Token-Refresh】: {}", e.getErrMsg());
			return this.iotToken;
		}
		log.info("【DK-IOT】 token refresh successful.");
		String data = iotResponse.getData();
		IotTokenResponse iotTokenResponse = JSONUtil.toBean(data, IotTokenResponse.class);
		return iotTokenResponse;

	}

	/**
	 * 检查活性
	 */
	private void refreshTokenAndKeepAlive() {

		Long currentTime = System.currentTimeMillis() / 1000;
		if (this.iotToken.getExpires_in() - currentTime <= 10 * 60) {
			this.iotToken = this.refreshToken();
			log.warn("当前Token:{}, 失效于：{}", this.iotToken.getAccess_token(), this.iotToken.getExpires_in());

		}
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public IotTokenResponse getIotToken() {
		return iotToken;
	}

	public void setIotToken(IotTokenResponse iotToken) {
		this.iotToken = iotToken;
	}

}
