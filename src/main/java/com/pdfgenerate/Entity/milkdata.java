package com.pdfgenerate.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "milkdata")
public class milkdata {

	@Id
	private int id;

//	@Column(name="milkitem")
	private String milkitem;
	private String dairyprod;
	private String geo;
	private int TIME_PERIOD;
	private double OBS_VALUE;
	private String OBS_FLAG;

	public milkdata(int id, String milkitem, String dairyprod, String geo, int tIME_PERIOD, double oBS_VALUE,
			String oBS_FLAG) {
		super();
		this.id = id;
		this.milkitem = milkitem;
		this.dairyprod = dairyprod;
		this.geo = geo;
		TIME_PERIOD = tIME_PERIOD;
		OBS_VALUE = oBS_VALUE;
		OBS_FLAG = oBS_FLAG;
	}

	public milkdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMilkitem() {
		return milkitem;
	}

	public void setMilkitem(String milkitem) {
		this.milkitem = milkitem;
	}

	public String getDairyprod() {
		return dairyprod;
	}

	public void setDairyprod(String dairyprod) {
		this.dairyprod = dairyprod;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public int getTIME_PERIOD() {
		return TIME_PERIOD;
	}

	public void setTIME_PERIOD(int tIME_PERIOD) {
		TIME_PERIOD = tIME_PERIOD;
	}

	public double getOBS_VALUE() {
		return OBS_VALUE;
	}

	public void setOBS_VALUE(double oBS_VALUE) {
		OBS_VALUE = oBS_VALUE;
	}

	public String getOBS_FLAG() {
		return OBS_FLAG;
	}

	public void setOBS_FLAG(String oBS_FLAG) {
		OBS_FLAG = oBS_FLAG;
	}

	@Override
	public String toString() {
		return "milkdata [id=" + id + ", milkitem=" + milkitem + ", dairyprod=" + dairyprod + ", geo=" + geo
				+ ", TIME_PERIOD=" + TIME_PERIOD + ", OBS_VALUE=" + OBS_VALUE + ", OBS_FLAG=" + OBS_FLAG + "]";
	}

}
