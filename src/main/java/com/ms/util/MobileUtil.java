package com.ms.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort;

public class MobileUtil {
//	@Autowired
//	private static MobileRepository repository;
	private static Long mobileId = 2000l;

	public static Long getMobileId() {
		return mobileId++;

	}

	public Sort getSorting(String sort) {
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

	public String searchString(String str) {
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

	public static String getCPUPattern(List<String> cpus) {
		String pattern = "";
		if (cpus != null && cpus.size() >= 1) {
			for (String str : cpus) {
				pattern = pattern + str + "|";
			}

			// remove last or operator
			pattern = pattern.substring(0, pattern.lastIndexOf("|"));

		}
		return pattern;

	}

	public List<Long> getRanking(List<Long> list) {
		List<Long> sorted = new ArrayList<Long>(list);
		Collections.sort(sorted, Collections.reverseOrder());
		List<Long> rank = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < sorted.size(); j++) {
				if (list.get(i) == sorted.get(j)) {
					rank.add((long) (j + 1));
				}
			}
		}

		return rank;

	}

}
