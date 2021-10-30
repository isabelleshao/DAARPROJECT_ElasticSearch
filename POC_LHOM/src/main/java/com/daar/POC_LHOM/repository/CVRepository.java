package com.daar.POC_LHOM.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.daar.POC_LHOM.document.CV;

//data access
@Repository
public interface CVRepository extends ElasticsearchRepository<CV, String> {

	void save(String cv);

	



}