package com.ms.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ms.entity.Mobile;

public class MobileCustomRepositoryImpl implements MobileCustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Mobile> findMobileByProperties(String search, List<String> brands, Long priceLow, Long priceHigh,
			List<String> launchedDate, List<String> screen, String display, Integer rearCamera, Integer frontCamera,
			Integer ram, Integer inbuiltMemory, Integer battery, String os, String cpu,Boolean upcoming, Pageable page) {
		final Query query = new Query().with(page);
		final List<Criteria> criteria = new ArrayList<>();

		// search
		if (search != null && !search.isEmpty()) {
			criteria.add(Criteria.where("title").regex(search));
		}

		// brands
		if (brands != null && brands.size() >= 1) {
			criteria.add(Criteria.where("brand").in(brands));
		}
		// price
		if (priceLow != null && priceHigh == null) {
			criteria.add(Criteria.where("price").gt(priceLow));
		}
		if (priceLow == null && priceHigh != null) {
			criteria.add(Criteria.where("price").lt(priceHigh));
		}
		if (priceLow != null && priceHigh != null) {
			criteria.add(Criteria.where("price").gte(priceLow).lte(priceHigh));
		}

		// launchedDates

		// screenSize
//		  4 inch Below
//		  4 inch - 5 inch
//		  5 inch - 6 inch
//		  6 inch Above
		if (screen != null && screen.size() >= 1) {
			for (String sc : screen) {
				if (sc.equalsIgnoreCase("4 inch Below")) {
					criteria.add(Criteria.where("screenSize").lte(4));
				} else if (sc.equalsIgnoreCase("4 inch - 5 inch")) {
					criteria.add(Criteria.where("screenSize").gte(4).lte(5));
				} else if (sc.equalsIgnoreCase("5 inch - 6 inch")) {
					criteria.add(Criteria.where("screenSize").gte(5).lte(6));
				} else if (sc.equalsIgnoreCase("6 inch Above")) {
					criteria.add(Criteria.where("screenSize").gte(6));
				}
			}

		}

		// display
		// Amoled , IPS
		if (display != null && !display.isEmpty()) {
			criteria.add(Criteria.where("display.type").regex(display));
		}

		// rearCameras
//		greater than
		if (rearCamera != null) {
			criteria.add(Criteria.where("rearCamera").gte(rearCamera));
		}

		// frontCameras
		if (frontCamera != null) {
			criteria.add(Criteria.where("frontCamera").gte(frontCamera));
		}

		// ram
		//gte ram 2,4,6,8
		if (ram != null) {
			criteria.add(Criteria.where("ram").gte(ram));
		}

		// inbuiltMemorys
		if (inbuiltMemory != null) {
			criteria.add(Criteria.where("internalMemory").gte(inbuiltMemory));
		}

		// battery
		if (battery != null) {
			criteria.add(Criteria.where("batterySize").gte(battery));
		}

		// os -- Android , iOS
		if (os != null && !os.isEmpty()) {
			criteria.add(Criteria.where("technical.os").regex(os));
		}

		// cpu man

		if (cpu != null && !cpu.isEmpty()) {
			criteria.add(Criteria.where("technical.chipset").regex(cpu));
		}
		
		if (upcoming != null) {
			criteria.add(Criteria.where("upcoming").is(upcoming));
		}

	

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()])));
		return mongoTemplate.find(query, Mobile.class);
//		
		
		
		
	}

}
