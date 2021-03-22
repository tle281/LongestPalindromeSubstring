package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.SubString;
import com.demo.service.StringService;
import java.util.*;

@RestController
public class StringController {

	@Autowired
	private StringService service;

	@GetMapping("/substrings")
	public ResponseEntity<List<SubString>> get(@RequestParam(required = false) String str) {
		try {
			List<SubString> substrings = new ArrayList<SubString>();

			if (str == null)
				service.findAll().forEach(substrings::add);
			else
				service.findByStrContaining(str).forEach(substrings::add);

			if (substrings.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(substrings, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/substrings")
	public ResponseEntity<SubString> add(@RequestBody SubString string) {
		try {
			SubString _string = new SubString(string.getStr(), string.getPalSubStr());
			_string.setPalSubStr(service.getMaxPalindromicSubstrFromString(string.getStr()));
			return new ResponseEntity<>(service.save(_string), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
