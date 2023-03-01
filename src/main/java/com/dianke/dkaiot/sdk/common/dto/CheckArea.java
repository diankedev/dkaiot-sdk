package com.dianke.dkaiot.sdk.common.dto;

/**
 * @Description: 检测区域
 * @Author: bear
 * @Date: 2022/09/05
 */
public class CheckArea {

	/**
	 * 检测区域 xMin
	 */
	private Float xmin;

	/**
	 * 检测区域 xMax
	 */
	private Float xmax;

	/**
	 * 检测区域 yMin
	 */
	private Float ymin;

	/**
	 * 检测区域 yMax
	 */
	private Float ymax;

	private Float zmin;

	/**
	 * 检测区域 zMax
	 */
	private Float zmax;

	public Float getXmin() {
		return xmin;
	}

	public CheckArea setXmin(Float xmin) {
		this.xmin = xmin;
		return this;
	}

	public Float getXmax() {
		return xmax;
	}

	public CheckArea setXmax(Float xmax) {
		this.xmax = xmax;
		return this;
	}

	public Float getYmin() {
		return ymin;
	}

	public CheckArea setYmin(Float ymin) {
		this.ymin = ymin;
		return this;
	}

	public Float getYmax() {
		return ymax;
	}

	public CheckArea setYmax(Float ymax) {
		this.ymax = ymax;
		return this;
	}

	public Float getZmin() {
		return zmin;
	}

	public CheckArea setZmin(Float zmin) {
		this.zmin = zmin;
		return this;
	}

	public Float getZmax() {
		return zmax;
	}

	public CheckArea setZmax(Float zmax) {
		this.zmax = zmax;
		return this;
	}

}
