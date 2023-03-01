package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 查询设备基础信息
 * @Author: bearx
 * @Date: 2023/02/24
 */
public class QueryDev {

	private String serialNo;

	private Integer current;

	private Integer size;

	public String getSerialNo() {
		return serialNo;
	}

	public QueryDev setSerialNo(String serialNo) {
		this.serialNo = serialNo;
		return this;
	}

	public Integer getCurrent() {
		return current;
	}

	public QueryDev setCurrent(Integer current) {
		this.current = current;
		return this;
	}

	public Integer getSize() {
		return size;
	}

	public QueryDev setSize(Integer size) {
		this.size = size;
		return this;
	}

}
