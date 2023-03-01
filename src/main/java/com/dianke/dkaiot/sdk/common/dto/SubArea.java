package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 子区域
 * @Author: bear
 * @Date: 2022/09/05
 */
public class SubArea {

	private Float subXmin;

	private Float subXmax;

	private Float subYmin;

	private Float subYmax;

	public Float getSubXmin() {
		return subXmin;
	}

	public SubArea setSubXmin(Float subXmin) {
		this.subXmin = subXmin;
		return this;
	}

	public Float getSubXmax() {
		return subXmax;
	}

	public SubArea setSubXmax(Float subXmax) {
		this.subXmax = subXmax;
		return this;
	}

	public Float getSubYmin() {
		return subYmin;
	}

	public SubArea setSubYmin(Float subYmin) {
		this.subYmin = subYmin;
		return this;
	}

	public Float getSubYmax() {
		return subYmax;
	}

	public SubArea setSubYmax(Float subYmax) {
		this.subYmax = subYmax;
		return this;
	}

}
