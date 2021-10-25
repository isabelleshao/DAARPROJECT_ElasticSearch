package com.daar.POC_LHOM.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.daar.POC_LHOM.repository.CVrepository;


public class SearchService {

	@Autowired
	private final CVrepository repository;

	@Autowired
	public SearchService(CVrepository repository) {
		this.repository = repository;
	}
}
