package com.daar.POC_LHOM.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daar.POC_LHOM.document.CV;
import com.daar.POC_LHOM.helper.Utils;
import com.daar.POC_LHOM.services.SearchService;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

// rest Api layer
@RestController
@RequestMapping("/api/v1/lhom")
public class CVcontroller {
	
	@Autowired
	private final SearchService service;

	@Autowired
	public CVcontroller (SearchService service) {
		this.service = service;
	}
	
	@PostMapping
	public void save(@RequestBody final CV cv) {
	
		service.save(cv);
	}

	
	

}
