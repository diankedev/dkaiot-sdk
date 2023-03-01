package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 设备激活DTO
 * @Author: bearx
 * @Date: 2023/02/21
 */
public class DevActive {

	private String serialNo;

	private String phone;

	private String longitude;

	private String latitude;

	private Integer installation;

	private Float height;

	public String getSerialNo() {
		return serialNo;
	}

	public DevActive setSerialNo(String serialNo) {
		this.serialNo = serialNo;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public DevActive setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getLongitude() {
		return longitude;
	}

	public DevActive setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getLatitude() {
		return latitude;
	}

	public DevActive setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	public Integer getInstallation() {
		return installation;
	}

	public DevActive setInstallation(Integer installation) {
		this.installation = installation;
		return this;
	}

	public Float getHeight() {
		return height;
	}

	public DevActive setHeight(Float height) {
		this.height = height;
		return this;
	}



}
