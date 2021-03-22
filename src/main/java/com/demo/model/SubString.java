package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "palindromic_substr")
public class SubString {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "str")
	private String str;

	@Column(name = "palSubStr")
	private String palSubStr;

	public SubString() {

	}

	public SubString(String str, String palSubStr) {
		this.str = str;
		this.palSubStr = palSubStr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getPalSubStr() {
		return palSubStr;
	}

	public void setPalSubStr(String palSubStr) {
		this.palSubStr = palSubStr;
	}

}
