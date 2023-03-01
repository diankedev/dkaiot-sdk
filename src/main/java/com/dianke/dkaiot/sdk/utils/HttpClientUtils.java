package com.dianke.dkaiot.sdk.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.dianke.dkaiot.sdk.client.DkIotClient;
import com.dianke.dkaiot.sdk.common.CommConst;
import com.dianke.dkaiot.sdk.common.IotResponse;
import com.dianke.dkaiot.sdk.common.function.IotFunction;
import com.dianke.dkaiot.sdk.handle.DkException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: HTTP工具类-封装部分业务
 * @Author: bear
 * @Date: 2021/11/11
 */
public class HttpClientUtils {

	private static final Log log = LogFactory.get(DkIotClient.class);

	public final static String GET = "GET";

	public final static String POST = "POST";

	public final static String PUT = "PUT";

	/**
	 * 统一动作
	 */
	public static IotResponse doAction(IotFunction function, String token) throws DkException {

		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");
		if (function.isAuth()) {
			headers.put(CommConst.Authorization, "Bearer " + token);
		}

		// server
		String url = new StringBuilder().append(CommConst.SERVER_PREFIX).append(function.getSuffix()).toString();

		String re = send(POST, url, headers, function.getParams());
		IotResponse iotResponse = JSONUtil.toBean(re, IotResponse.class);
		Integer code = iotResponse.getCode();

		// 异常结果处理
		if (CommConst.RE_111 == code) {
			throw new DkException(CommConst.RE_WARN, iotResponse.getMsg());

		}
		else if (CommConst.RE_222 == code) {
			throw new DkException(CommConst.UNAUTHORIZED, "接口未授权");

		}
		else if (CommConst.RE_1 == code) {

			String fallMsg = iotResponse.getMsg();

			String msg = iotResponse.getMsg();
			if (msg.length() >= 3) {
				String sta = msg.substring(0, 3);
				if ("503".equals(sta)) {
					fallMsg = "【DK_IOT】server exception";
					throw new DkException(CommConst.RE_FAIL_SERVER, fallMsg);
				}
				else if ("token expire".equals(msg)) {
					log.warn("【DK-IOT】 client exception, token expire");
					throw new DkException(CommConst.RE_FAIL, "token expire");
				}
			}

			throw new DkException(CommConst.RE_FAIL, fallMsg);

		}
		else {
			// TODO
		}

		return iotResponse;

	}

	public static String send(String method, String url, Map<String, String> headers, JSONObject json) {
		String result;
		HttpPost post = null;
		HttpPut put = null;
		StringEntity strEntity = null;
		if (json != null) {
			strEntity = new StringEntity(json.toString(), StandardCharsets.UTF_8);
		}
		if (method.equals(POST)) {
			post = new HttpPost(url);
			if (headers != null) {
				for (String key : headers.keySet()) {
					post.setHeader(key, headers.get(key));
				}
			}
			post.setEntity(strEntity);
		}
		else if (method.equals(PUT)) {
			put = new HttpPut(url);
			if (headers != null) {
				for (String key : headers.keySet()) {
					put.setHeader(key, headers.get(key));
				}
			}
			put.setEntity(strEntity);
		}
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpResponse response = null;
			if (method.equals(POST)) {
				response = httpClient.execute(post);
			}
			else if (method.equals(PUT)) {
				response = httpClient.execute(put);
			}
			InputStream in = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
			StringBuilder str = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				str.append(line + '\n');
			}
			br.close();
			in.close();
			result = str.toString();
			return result;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
