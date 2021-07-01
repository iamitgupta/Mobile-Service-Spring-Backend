package com.ms.dto;

import com.ms.entity.Mobile;

public class MobileComparison {
	
	private Long rank;
	private Mobile mobile;
	
		
	
	public MobileComparison() {
		super();
	}
	public MobileComparison(Long rank, Mobile mobile) {
		super();
		this.rank = rank;
		this.mobile = mobile;
	}
	
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	
	
	

}
