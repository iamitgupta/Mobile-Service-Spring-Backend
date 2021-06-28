package com.ms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ms.entity.Display;
import com.ms.entity.Mobile;
import com.ms.repository.MobileRepository;

@Service
public class MobileService {

	@Autowired
	private MobileRepository repository;

	public Mobile saveMobile(Mobile mobile) {
		return repository.save(mobile);
	}

	public Mobile getMobile(Long id) {

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

		Pageable paging = PageRequest.of(page, size, getSorting(sort));

		// display
		if (display != null) {
			display = display.toUpperCase();
		}

		return repository.findMobileByProperties(searchString(search), brands, priceLow, priceHigh, launchedDate,
				screenSize, display, rearCamera, frontCamera, ram, inbuiltMemory, battery, os, getCPUPattern(cpu),upcoming, paging);
	}

	private Sort getSorting(String sort) {
		Sort sortReq = Sort.by(Sort.Direction.DESC, "releseDate");

		// asc
		if (sort.contains("ASC")) {

			if (sort.contains("date")) {
				sortReq = Sort.by(Sort.Direction.ASC, "releseDate");
			}
			if (sort.contains("specScore")) {
				sortReq = Sort.by(Sort.Direction.ASC, "specScore");
			}
			if (sort.contains("price")) {
				sortReq = Sort.by(Sort.Direction.ASC, "price");
			}
		}
		// desc
		else {
			if (sort.contains("date")) {
				sortReq = Sort.by(Sort.Direction.DESC, "releseDate");
			}
			if (sort.contains("specScore")) {
				sortReq = Sort.by(Sort.Direction.DESC, "specScore");
			}
			if (sort.contains("price")) {
				sortReq = Sort.by(Sort.Direction.DESC, "price");
			}
			if (sort.contains("popularity")) {
				sortReq = Sort.by(Sort.Direction.DESC, "popularity");
			}
		}

		return sortReq;
	}

	private String searchString(String str) {
		if (str != null && !str.isEmpty()) {
			String words[] = str.split("\\s");
			String capitalizeWord = "";
			for (String w : words) {
				String first = w.substring(0, 1);
				String afterfirst = w.substring(1);
				capitalizeWord += first.toUpperCase() + afterfirst + " ";
			}
			return capitalizeWord.trim();
		}
		return str;

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

	public static String getCPUPattern(List<String> cpus) {
		String pattern = "";
		if (cpus != null && cpus.size() >= 1) {
			for(String str : cpus) {
				pattern = pattern+str+"|";
			}
			
			//remove last or operator
			pattern = pattern.substring(0, pattern.lastIndexOf("|"));
			
		}
		return pattern;

	}

}
