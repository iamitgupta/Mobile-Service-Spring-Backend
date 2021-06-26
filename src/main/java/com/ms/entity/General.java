package com.ms.entity;

public class General {
	private String simType;
	private String dualSim;
	private String simSize;
	private String deviceType;
	private String releaseDate;

	public String getSimType() {
		return simType;
	}

	public void setSimType(String simType) {
		this.simType = simType;
	}

	public String getDualSim() {
		return dualSim;
	}

	public void setDualSim(String dualSim) {
		this.dualSim = dualSim;
	}

	public String getSimSize() {
		return simSize;
	}

	public void setSimSize(String simSize) {
		this.simSize = simSize;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "General [simType=" + simType + ", dualSim=" + dualSim + ", simSize=" + simSize + ", deviceType="
				+ deviceType + ", releaseDate=" + releaseDate + "]";
	}

}