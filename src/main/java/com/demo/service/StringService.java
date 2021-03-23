package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.SubString;
import com.demo.repository.StringRepository;

@Service
@Transactional
public class StringService {

	@Autowired
	private StringRepository repo;
	
	/*
	 * method to find the longest palindromic substring from input string _s_ 
	 */ 
	public String getMaxPalindromicSubstrFromString(String _s_) { 
		
		if (_s_.length() == 0) {
			throw new IllegalArgumentException("Invalid arg: expected input string to have size 1 <= size <= 1000, got size 0");
		}
		// keep track of the beginning and ending indexes of the current longest substring
		int[] currentLongestString = new int[] { 0, 1 };

		for (int i = 1; i < _s_.length(); i++) {
			// get the longest odd palindromic substring found at index i
			int[] odd = getLongestPalindromicSubstring(_s_, i - 1, i + 1);
			// get the longest even palindromic substring found at index i  
			int[] even = getLongestPalindromicSubstring(_s_, i - 1, i);
			// find the longer substring between the odd and even palindromic substrings found at i 
			int[] longerSubstring = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			//assign new currentLongestString if the substring just found in previous step is longer than the one we have 
			currentLongestString = currentLongestString[1] - currentLongestString[0] > longerSubstring[1]
					- longerSubstring[0] ? currentLongestString : longerSubstring;
		}

		return _s_.substring(currentLongestString[0], currentLongestString[1]);
	}

	/* 
	 * method to return the smallest beginning and largest ending indexes that form a palindromic substring 
	 * from a certain input string at a certain index
	 */
	private static int[] getLongestPalindromicSubstring(String _s_, int leftIndex, int rightIndex) {
		while (leftIndex >= 0 && rightIndex < _s_.length()) {
			if (_s_.charAt(leftIndex) != _s_.charAt(rightIndex))
				break;
			leftIndex--;
			rightIndex++;
		}
		return new int[] { leftIndex + 1, rightIndex };
	}

	
	/* 
	 * method to save both the input string and its longest palindromic substring to db
	 */
	public SubString save(SubString string) {
		return repo.save(string);

	}

	/* 
	 * method to retrieve all input strings and their respective longest palindromic 
	 * substrings from the db
	 */
	public Iterable<SubString> findAll() {
		return repo.findAll();
	}

	
	/* 
	 * method to retrieve only input string and its respective longest palindromic 
	 * substring if full string saved in the db matches input
	 */
	public Iterable<SubString> findByStrContaining(String str) {
		return repo.findByStrContaining(str);
	}

}
