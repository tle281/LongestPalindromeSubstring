package com.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.service.StringService;

@SpringBootTest
class Q1SpringbootApplicationTests {

	private StringService s;
	
	@BeforeEach
	public void setup() {
		System.out.println("SetUp Method");
		s = new StringService();
	}
	
	@Test
	public void test1() {
		System.out.println("Running test case 1"); 
		String result = s.getMaxPalindromicSubstrFromString("ababc");
		assertNotNull(result);
		assertThat(result).isIn("aba", "bab");
	}
	
	@Test
	public void test2() {
		System.out.println("Running test case 2");
		String result = s.getMaxPalindromicSubstrFromString("h");
		assertNotNull(result);
		assertEquals("h", result);
	}
	
	@Test
	public void test3() {
		System.out.println("Running test case 3");
		String result = s.getMaxPalindromicSubstrFromString("ha");
		assertNotNull(result);
		assertThat(result).isIn("a", "h");
	}
	
	@Test
	public void test4() {
		System.out.println("Running test case 4");
		String result = s.getMaxPalindromicSubstrFromString("baac");
		assertNotNull(result);
		assertEquals("aa", result);
	}
	
	@Test
	public void test5() {
		System.out.println("Running test case 5");
		String result = s.getMaxPalindromicSubstrFromString("aa");
		assertNotNull(result);
		assertEquals("aa", result);
	}
	
	@Test
	public void test6() {
		System.out.println("Running test case 6");
		String result = s.getMaxPalindromicSubstrFromString("aaa");
		assertNotNull(result);
		assertEquals("aaa", result);
	}
	
	@Test
	public void test7() {
		System.out.println("Running test case 7");
		String result = s.getMaxPalindromicSubstrFromString("aab");
		assertNotNull(result);
		assertEquals("aa", result);
	}
	
	@Test
	public void test8() {
		System.out.println("Running test case 8");
		String result = s.getMaxPalindromicSubstrFromString("baa");
		assertNotNull(result);
		assertEquals("aa", result);
	}
	
	@Test
	public void test9() {
		System.out.println("Running test case 9");
		String result = s.getMaxPalindromicSubstrFromString("aca");
		assertNotNull(result);
		assertEquals("aca", result);
	}
	
	@Test
	public void test10() {
		System.out.println("Running test case 10");
		String result = s.getMaxPalindromicSubstrFromString("aaaa");
		assertNotNull(result);
		assertEquals("aaaa", result);
	}
	
	@Test
	public void test11() {
		System.out.println("Running test case 11");
		String result = s.getMaxPalindromicSubstrFromString("adac");
		assertNotNull(result);
		assertEquals("ada", result);
	}
	
	@Test
	public void test12() {
		System.out.println("Running test case 12");
		String result = s.getMaxPalindromicSubstrFromString("cbab");
		assertNotNull(result);
		assertEquals("bab", result);
	}
	
	@Test
	public void test13() {
		System.out.println("Running test case 13");
		String result = s.getMaxPalindromicSubstrFromString("aaaaa");
		assertNotNull(result);
		assertEquals("aaaaa", result);
	}
	
	@Test
	public void test14() {
		System.out.println("Running test case 14");
		String result = s.getMaxPalindromicSubstrFromString("abcbe");
		assertNotNull(result);
		assertEquals("bcb", result);
	}
	
	@Test
	public void test15() {
		System.out.println("Running test case 15");
		String result = s.getMaxPalindromicSubstrFromString("eabcb");
		assertNotNull(result);
		assertEquals("bcb", result);
	}
	
	@Test
	public void test16() {
		System.out.println("Running test case 16");
		String result = s.getMaxPalindromicSubstrFromString("aacabdkacaa");
		assertNotNull(result);
		assertEquals("aca", result);
	}
	
	@Test
	public void test17() {
		System.out.println("Running test case 17");
		String result = s.getMaxPalindromicSubstrFromString("xaabacxcabaaxcabaax");
		assertNotNull(result);
		assertEquals("xaabacxcabaax", result);
	}
	
	@Test
	public void test18() {
		System.out.println("Running test case 18");
		String result = s.getMaxPalindromicSubstrFromString("abbcccbbbcaaccbababcbcabca");
		assertNotNull(result);
		assertThat(result).isIn("bbcccbb", "cbababc");
	}
	
	
	@Test
	public void test19_EmptyString() {
		System.out.println("Running test case 19");
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
		    s.getMaxPalindromicSubstrFromString("");
		  });
		assertEquals("Invalid arg: expected input string to have size 1 <= size <= 1000, got size 0", ex.getMessage());
	}
	
	
	@AfterEach
	public void teardown() {
		System.out.println("TearDown Method");
		s = null;
	}
	

}
