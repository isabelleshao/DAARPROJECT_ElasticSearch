package com.daar.POC_LHOM.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.daar.POC_LHOM.model.CV;

@Repository
public interface CVRepository extends ElasticsearchRepository<CV, String> {

	void save(String cv);

	@Query("{\"bool\" : {  \"should\": [{\"match\": {  \"contentWords\": \"?0\"}  }]}  }")
	List<CV> getCvByTag(String tag);

	@Query("{\"match_all\": {}}")	
	List<CV> getCvAll();

	@Query("{ \"match\": { \"firstName\" : \"?0\"}}")
	List<CV> getCvFirstName(String firstName);

	@Query("{ \"match\": { \"familyName\": \"?0\"}}")
	List<CV> getCvFamilyName(String familyName);

	@Query("{ \"match\": { \"age\": \"?0\"}}")
	List<CV> getCvByAge(String age);

	/*@Query("{\"match_phrase\": {\"content\": \"?0\"}  }")
	List<CV> searchCVByKeyWord(String word);
	 */
}