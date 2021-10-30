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

	
	@Query("{\"bool\" : {  \"should\": [{\"match\": {  \"tags\": \"?0\"}  }]}  }")
	List<CV> get_CV_tag(String tag);
	
	
	@Query("{\"match_all\": {}}")	
	List<CV> get_CV_all();

	@Query("{ \"match\": { \"prenom\": \"?0\"}}")
	List<CV> get_CV_prenom(String prenom);

	@Query("{ \"match\": { \"nom\": \"?0\"}}")
	List<CV> get_CV_nom(String nom);


	@Query("{\"match_phrase\": {\"content\": \"?0\"}  }")
	List<CV> get_CV_contain_words(String words);



}