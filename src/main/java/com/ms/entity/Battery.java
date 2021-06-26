package com.ms.entity;

public class Battery {
	private String type;
	private String size;
	private String fastCharging;
	private String reverseCharging;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFastCharging() {
		return fastCharging;
	}
	public void setFastCharging(String fastCharging) {
		this.fastCharging = fastCharging;
	}
	public String getReverseCharging() {
		return reverseCharging;
	}
	public void setReverseCharging(String reverseCharging) {
		this.reverseCharging = reverseCharging;
	}
	@Override
	public String toString() {
		return "Battery [type=" + type + ", size=" + size + ", fastCharging=" + fastCharging + ", reverseCharging="
				+ reverseCharging + "]";
	}
	
	
}