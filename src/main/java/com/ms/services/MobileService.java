package com.ms.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ms.dto.MobileComparison;
import com.ms.entity.Display;
import com.ms.entity.Mobile;
import com.ms.repository.MobileRepository;
import com.ms.util.MobileUtil;

@Service
public class MobileService {

	@Autowired
	private MobileRepository repository;
	
	@Autowired
	private MobileUtil mobileUtil;

	public Mobile saveMobile(Mobile mobile) {
		return repository.save(mobile);
	}

	public Mobile getMobile(Long id) {
		
		if(id==null) {
			return null;
		}

		Optional<Mobile> mobile = repository.findById(id);

		if (mobile.isPresent()) {
			Mobile dbMobile = mobile.get();
			//update popularity by 1++
			dbMobile.setPopularity(dbMobile.getPopularity()+1);
			updateMobile(id,dbMobile);
			
			return dbMobile;
		}
		return null;
	}

	public Boolean deleteMobile(Long id) {

		if (getMobile(id) != null) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	public List<Mobile> getAllMobiles() {
		return repository.findAll();
	}
	

	public Mobile updateMobile(Long id, Mobile mobile) {
		Optional<Mobile> mobiles = repository.findById(id);

		if (mobiles.isPresent()) {
			Mobile dbMobile = mobiles.get();
			
			//update property
//			get all the property from 
			dbMobile.setPopularity(mobile.getPopularity());
			
			
			
			
			repository.save(dbMobile);
			
			return dbMobile;
		}
		return null;

	}

	public List<Mobile> saveAllMobiles(List<Mobile> mobileList) {
		return repository.saveAll(mobileList);
	}

	public void deleteAllMobile() {
		repository.deleteAll();

	}

	

	public List<Mobile> findMobileByProperties(String search, List<String> brands, Long priceLow, Long priceHigh,
			List<String> launchedDate, List<String> screenSize, String display, Integer rearCamera, Integer frontCamera,
			Integer ram, Integer inbuiltMemory, Integer battery, String os, List<String> cpu,
			Boolean upcoming,
			Integer page,
			Integer size, String sort) {

		Pageable paging = PageRequest.of(page, size, mobileUtil.getSorting(sort));

		// display
		if (display != null) {
			display = display.toUpperCase();
		}

		return repository.findMobileByProperties( mobileUtil.searchString(search), brands, priceLow, priceHigh, launchedDate,
				screenSize, display, rearCamera, frontCamera, ram, inbuiltMemory, battery, os,  mobileUtil.getCPUPattern(cpu),upcoming, paging);
	}

	

	public List<String> findByTitleContainingIgnoreCase(String title) {

		List<String> titleList = new ArrayList<String>();

		Pageable paging = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "releseDate"));
		Page<Mobile> mobiles = repository.findByTitleContainingIgnoreCase(title, paging);

		for (Mobile mobile : mobiles) {
			titleList.add(mobile.getTitle());
		}

		return titleList;

	}

	
	//mobile comaprison
	
	public List<MobileComparison> getComparison(Long mobileOne, Long mobileTwo, Long mobileThree){
		
		List<MobileComparison> listMobile = new ArrayList<>();
		
		if(mobileOne!=null) {
			
		}
		
		Mobile mobile1 = getMobile(mobileOne);
		Mobile mobile2 = getMobile(mobileTwo);
		Mobile mobile3 = getMobile(mobileThree);
		
		List<Long> rank = null;
		
		if(mobile1!=null && mobile2!=null && mobile3!=null) {
			rank =  mobileUtil.getRanking(Arrays.asList(mobile1.getSpecScore(),
					mobile2.getSpecScore(),mobile3.getSpecScore()
					));
			listMobile.add(new MobileComparison(rank.get(0),mobile1));
			listMobile.add(new MobileComparison(rank.get(1),mobile2));
			listMobile.add(new MobileComparison(rank.get(2),mobile3));
			
			return listMobile;
			
		}else if(mobile1!=null && mobile2!=null) {
			rank =  mobileUtil.getRanking(Arrays.asList(mobile1.getSpecScore(),
					mobile2.getSpecScore()
					));
			listMobile.add(new MobileComparison(rank.get(0),mobile1));
			listMobile.add(new MobileComparison(rank.get(1),mobile2));
			
			return listMobile;
		}
	
		return null;
	}
	
	

}
