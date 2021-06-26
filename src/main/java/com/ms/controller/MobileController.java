package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Mobile;
import com.ms.services.MobileService;

@RestController("/api/ms")
@CrossOrigin
public class MobileController {

	@Autowired
	private MobileService service;

	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok("Mobile Service running");
	}

	// save mobile
	@PostMapping("/savemobile")
	public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mobile) {
		try {

			return new ResponseEntity<>(service.saveMobile(mobile), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// save all mobile
	@PostMapping("/saveallmobile")
	public ResponseEntity<List<Mobile>> saveAllMobile(@RequestBody List<Mobile> mobileList) {
		try {
			return new ResponseEntity<>(service.saveAllMobiles(mobileList), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// get one mobile by id
	@GetMapping("/getmobile/{id}")
	public ResponseEntity<Mobile> getMobile(@PathVariable Long id) {
		Mobile mobile = service.getMobile(id);

		if (mobile != null) {
			return new ResponseEntity<>(mobile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// get all mobiles
	@GetMapping("/getallmobiles")
	public ResponseEntity<List<Mobile>> getAllMobiles() {
		try {
			List<Mobile> mobileList = service.getAllMobiles();
			if (mobileList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(mobileList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// update mobile
	@PutMapping("/updatemobile/{id}")
	public ResponseEntity<Mobile> updateMobile(@PathVariable("id") Long id, @RequestBody Mobile mobile) {

		Mobile dbMobile = service.updateMobile(id, mobile);

		if (dbMobile != null) {
			return new ResponseEntity<>(dbMobile, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletemobile/{id}")
	public ResponseEntity<HttpStatus> deleteMobile(@PathVariable("id") Long id) {
		try {
			service.deleteMobile(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteallmobiles")
	public ResponseEntity<HttpStatus> deleteAllMobile() {
		try {
			service.deleteAllMobile();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/mobileservice")
	public ResponseEntity<Object> mobileService(
			// search
			@RequestParam(required = false) String search,

			// Filter

			// list of brands
			@RequestParam(required = false) List<String> brand,
			@RequestParam(required = false) Long priceLow,
			@RequestParam(required = false) Long priceHigh,

			@RequestParam(required = false) List<String> launchedDate,

			// display type- amoled , ips
			@RequestParam(required = false) String display,

			// screen size
//			  4 inch & Below
//			  4 inch - 5 inch
//			  5 inch - 6 inch
//			  6 inch & Above
			@RequestParam(required = false) List<String> screenSize,

			@RequestParam(required = false) Integer rearCamera,
			
			@RequestParam(required = false) Integer frontCamera,
			@RequestParam(required = false) Integer ram,
			@RequestParam(required = false) Integer inbuiltMemory,
			@RequestParam(required = false) Integer battery,

			// Android or iOS
			@RequestParam(required = false) String os,
			
			
			//cpu manf.
//			Apple
//			HiSilicon
//			MediaTek
//			Others
//			Qualcomm
//			Samsung
			@RequestParam(required = false) List<String> cpu,
			
			//upcoming
			//true false
			@RequestParam(required = false) Boolean upcoming,

			// paging--done
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size,

			// sorting--done
			@RequestParam(defaultValue = "dateDESC") String sort

	) {
		System.out.println("search: "+search);
		System.out.println("Brands: "+brand);
		
		List<Mobile> mobileList = service.findMobileByProperties(search, brand, priceLow, priceHigh, launchedDate,
				screenSize, display, rearCamera, frontCamera, ram, inbuiltMemory, battery, os, cpu, upcoming, page, size, sort);
		return new ResponseEntity<>(mobileList, HttpStatus.OK);
//
//		try {
//			List<Mobile> mobileList = service.findMobileByProperties(search, brand, priceLow, priceHigh, launchedDate,
//					screenSize, display, rearCamera, frontCamera, ram, inbuiltMemory, battery, os, cpu, page, size, sort);
//			if(mobileList.size()>1)
//				return new ResponseEntity<>(mobileList, HttpStatus.OK);
//			return new ResponseEntity<>(mobileList, HttpStatus.NO_CONTENT);
//			
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	@GetMapping("/suggestion")
	public ResponseEntity<List<String>> getSuggestion(@RequestParam String title) {
		try {
			
			List<String> suggestions = service.findByTitleContainingIgnoreCase(title);
			if(suggestions!=null && suggestions.size()>=1) {
				return new ResponseEntity<>(service.findByTitleContainingIgnoreCase(title), HttpStatus.OK);
			}

			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/test")
	public String test() {
		
		return "Samsung Galaxy M12  6GB RAM   128GB";

	}

}
