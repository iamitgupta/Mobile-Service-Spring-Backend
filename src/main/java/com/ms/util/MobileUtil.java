package com.ms.util;

public class MobileUtil {
//	@Autowired
//	private static MobileRepository repository;
	private static Long mobileId = 2000l;

	public static Long getMobileId() {
		return mobileId ++;

	}

}
