package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 语音下发
 * @Author: bearx
 * @Date: 2023/02/24
 */
public class SendVoice {

	private String deviceId;

	private String serialNo;

	private String voiceUrl;

	private String md5;

	private Long size;

	public String getDeviceId() {
		return deviceId;
	}

	public SendVoice setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public SendVoice setSerialNo(String serialNo) {
		this.serialNo = serialNo;
		return this;
	}

	public String getVoiceUrl() {
		return voiceUrl;
	}

	public SendVoice setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
		return this;
	}

	public String getMd5() {
		return md5;
	}

	public SendVoice setMd5(String md5) {
		this.md5 = md5;
		return this;
	}

	public Long getSize() {
		return size;
	}

	public SendVoice setSize(Long size) {
		this.size = size;
		return this;
	}

}
