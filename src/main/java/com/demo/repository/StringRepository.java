package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.SubString;

import java.util.*;

public interface StringRepository extends JpaRepository<SubString, Long> {

	Iterable<SubString> findByStrContaining(String str);

}
