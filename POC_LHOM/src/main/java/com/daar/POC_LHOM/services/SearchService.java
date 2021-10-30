package com.daar.POC_LHOM.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daar.POC_LHOM.document.CV;
import com.daar.POC_LHOM.repository.CVRepository;

//Business rules layer
@Service
public class SearchService {

	@Autowired
	private final CVRepository repository;

	@Autowired
	public SearchService(CVRepository repository) {
		this.repository = repository;
	}

	public void save(final CV cv) {
		repository.save(cv);
	}

	// Chercher les CV de x à y
	public List<CV> get_CV_from_to(int from, int to) {

		Iterable<CV> iterable = repository.findAll();
		Iterator<CV> iterator = iterable.iterator();
		int i = from;
		List<CV> ret = new ArrayList<>();

		while (iterator.hasNext()) {
			CV next = iterator.next();
			if (i < to) {
				ret.add(next);
			}
			i++;
		}
		return ret;
	}


	public List<CV> get_CV_tag(String tag) { 
		return repository.get_CV_tag(tag); 
		}

	public List<CV>  get_CV_all() {
		return repository.get_CV_all(); 
	}

	
	public List<CV> get_CV_prenom(String prenom) { 
		return repository.get_CV_prenom(prenom); 
		}

	public List<CV> get_CV_nom(String nom) { 
		return repository.get_CV_nom(nom); 
		}

	public  List<CV> get_CV_contain_words(String words) {
		return repository.get_CV_contain_words(words); 
	}

	public void delete_CV(String id) {
		boolean b = repository.existsById(id);

		if (b) {
			repository.deleteById(id);
		}
		
	}

	
}
