package com.dianke.dkaiot.sdk.client;

import com.dianke.dkaiot.sdk.common.dto.DevActive;
import com.dianke.dkaiot.sdk.common.dto.DevConfig;
import com.dianke.dkaiot.sdk.common.dto.QueryDev;
import com.dianke.dkaiot.sdk.common.dto.SendVoice;
import com.dianke.dkaiot.sdk.handle.DkException;

/**
 * @Description: IOT客户端
 * @Author: bearx
 * @Date: 2023/02/21
 */
public interface IotClient {

	String active(DevActive active) throws DkException;

	void reset(String deviceId) throws DkException;

	void reboot(String deviceId) throws DkException;

	void sendVoice(SendVoice sendVoice) throws DkException;

	String queryDev(QueryDev queryDev) throws DkException;

	void config(DevConfig devConfig) throws DkException;

}
