package com.dianke.dkaiot.sdk.client;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.dianke.dkaiot.sdk.common.CommConst;
import com.dianke.dkaiot.sdk.common.IotResponse;
import com.dianke.dkaiot.sdk.common.dto.*;
import com.dianke.dkaiot.sdk.common.function.*;
import com.dianke.dkaiot.sdk.handle.DkException;
import com.dianke.dkaiot.sdk.handle.TokenHandleSingle;
import com.dianke.dkaiot.sdk.http.IotTokenResponse;
import com.dianke.dkaiot.sdk.utils.HttpClientUtils;

/**
 * @Description: IOT客户端
 * @Author: bearx
 * @Date: 2023/02/21
 */
public class DkIotClient implements IotClient {

	private static final Log log = LogFactory.get(DkIotClient.class);

	private TokenHandleSingle tokenHandleSingle;

	public DkIotClient() {
	}

	public DkIotClient(String clientId, String clientSecret) {
		String s = this.initClient(new DkClient().setClientId(clientId).setClientSecret(clientSecret));
		IotTokenResponse iotTokenResponse = JSONUtil.toBean(s, IotTokenResponse.class);
		if (iotTokenResponse == null || iotTokenResponse.getAccess_token() == null || iotTokenResponse.getExpires_in() == null) {
			log.error("************** 【DK-IOT-SDK】 init failed. ");

			try {
				throw new DkException(CommConst.RE_FAIL_SERVER, "【DK-IOT-SDK】 init failed. ");
			} catch (DkException e) {
				log.error(e);
			}
			return;
		}
		else {
			log.info("************** 【DK-IOT-SDK】 init successful. ");
		}
//		log.warn("【Token保活机制将于一分钟后启动】");
		this.tokenHandleSingle = TokenHandleSingle.getInstance(clientId, clientSecret);
		this.tokenHandleSingle.setIotToken(iotTokenResponse);

	}

	private String initClient(DkClient client) {
		IotFunction function = new ClientInit().setParams(JSONUtil.parseObj(client));
		String resp = dealRequest(function, null);
		return resp;
	}

	/**
	 * 设备激活
	 */
	@Override
	public String active(DevActive active) throws DkException {
		IotFunction function = new DevActiveFun().setParams(JSONUtil.parseObj(active));
		String resp = dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
		return resp;
	}

	@Override
	public void reset(String deviceId) throws DkException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("deviceId", deviceId);
		IotFunction function = new DevResetFun().setParams(jsonObject);
		dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
	}

	@Override
	public void reboot(String deviceId) throws DkException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("deviceId", deviceId);
		IotFunction function = new DevRebootFun().setParams(jsonObject);
		dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
	}

	@Override
	public void sendVoice(SendVoice sendVoice) throws DkException {
		IotFunction function = new DevSendVoiceFun().setParams(JSONUtil.parseObj(sendVoice));
		dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
	}

	@Override
	public String queryDev(QueryDev queryDev) throws DkException {
		IotFunction function = new DevQueryFun().setParams(JSONUtil.parseObj(queryDev));
		String resp = dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
		return resp;
	}

	@Override
	public void config(DevConfig devConfig) throws DkException {
		IotFunction function = new DevConfigFun().setParams(JSONUtil.parseObj(devConfig));
		dealRequest(function, this.tokenHandleSingle.getIotToken().getAccess_token());
	}

	/**
	 * 公共请求处理
	 */
	private String dealRequest(IotFunction function, String token) {

		IotResponse iotResponse;
		try {
			iotResponse = HttpClientUtils.doAction(function, token);
		}
		catch (DkException e) {

			if (CommConst.RE_FAIL_SERVER.equals(e.getErrCode())) {
				log.error(e.getErrMsg());
				return null;
			}
			else {
				log.warn(e.getErrMsg());
				throw new DkException(e.getErrCode(), e.getErrMsg());
			}

		}

		return iotResponse.getData();

	}

}
