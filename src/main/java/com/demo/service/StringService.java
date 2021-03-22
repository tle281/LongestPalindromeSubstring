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

	public String getMaxPalindromicSubstrFromString(String _s_) {
		int[] currentLongestString = new int[] { 0, 1 };

		for (int i = 1; i < _s_.length(); i++) {
			int[] odd = getLongestPalindromicSubstring(_s_, i - 1, i + 1);
			int[] even = getLongestPalindromicSubstring(_s_, i - 1, i);
			int[] longerSubstring = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			currentLongestString = currentLongestString[1] - currentLongestString[0] > longerSubstring[1]
					- longerSubstring[0] ? currentLongestString : longerSubstring;
		}

		return _s_.substring(currentLongestString[0], currentLongestString[1]);
	}

	private static int[] getLongestPalindromicSubstring(String _s_, int leftIndex, int rightIndex) {
		while (leftIndex >= 0 && rightIndex < _s_.length()) {
			if (_s_.charAt(leftIndex) != _s_.charAt(rightIndex))
				break;
			leftIndex--;
			rightIndex++;
		}
		return new int[] { leftIndex + 1, rightIndex };
	}

	public SubString save(SubString string) {
		return repo.save(string);

	}

	public Iterable<SubString> findAll() {
		return repo.findAll();
	}

	public Iterable<SubString> findByStrContaining(String str) {
		return repo.findByStrContaining(str);
	}

}
