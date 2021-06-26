package com.ms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ms.entity.Mobile;


public interface MobileCustomRepository {
	
	public List<Mobile> findMobileByProperties(String search,List<String> brands, Long priceLow, Long priceHigh,
			List<String> launchedDate, List<String> screen, String display, Integer rearCamera,
			Integer frontCamera, Integer ram, Integer inbuiltMemory, Integer battery,
			String os,String cpu,Boolean upcoming, Pageable page);

}
