package com.dianke.dkaiot.sdk.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 设备配置
 * @Author: bear
 * @Date: 2022/09/05
 */
public class DevConfig {

	private String deviceId;

	private Integer installation;

	private Float height;

	private Integer scene;

	private CheckArea checkArea;

	/**
	 * 屏蔽子区域
	 */
	private List<SubArea> subArea = new ArrayList<>();

	public String getDeviceId() {
		return deviceId;
	}

	public DevConfig setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public Integer getInstallation() {
		return installation;
	}

	public DevConfig setInstallation(Integer installation) {
		this.installation = installation;
		return this;
	}

	public Float getHeight() {
		return height;
	}

	public DevConfig setHeight(Float height) {
		this.height = height;
		return this;
	}

	public Integer getScene() {
		return scene;
	}

	public DevConfig setScene(Integer scene) {
		this.scene = scene;
		return this;
	}

	public CheckArea getCheckArea() {
		return checkArea;
	}

	public DevConfig setCheckArea(CheckArea checkArea) {
		this.checkArea = checkArea;
		return this;
	}

	public List<SubArea> getSubArea() {
		return subArea;
	}

	public DevConfig setSubArea(List<SubArea> subArea) {
		this.subArea = subArea;
		return this;
	}

}
