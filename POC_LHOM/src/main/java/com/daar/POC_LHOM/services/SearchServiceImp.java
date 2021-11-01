package com.daar.POC_LHOM.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.daar.POC_LHOM.helper.ParseCV;
import com.daar.POC_LHOM.helper.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daar.POC_LHOM.model.CV;
import com.daar.POC_LHOM.repository.CVRepository;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class SearchServiceImp implements SearchService{

	@Autowired
	private CVRepository repository;

	@Override
	public void save(final CV cv) {
		repository.save(cv);
	}

	@Override
	public List<CV> getCvFromTo(int from, int to) {
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


	@Override
	public List<CV> getCvTag(String tag) {
		return repository.getCvTag(tag);
		}

	@Override
	public List<CV>  getCvAll() {
		return repository.getCvAll();
	}

	@Override
	public List<CV> getCvFirstName(String firstName) {

		return repository.getCvFirstName(firstName);
	}

	@Override
	public List<CV> getCvFamilyName(String familyName) {
		System.out.println(familyName);
		return repository.getCvFamilyName(familyName);
	}

	@Override
	public  List<CV> searchCVByKeyWord(String word) {
		return repository.searchCVByKeyWord(word);
	}

	@Override
	public void deleteCv(String id) {
		boolean b = repository.existsById(id);
		if (b) {
			repository.deleteById(id);
		}
	}

	public void saveCVFromFile(MultipartFile file, String familyName, String firstName, String email, String phoneNumber)  {
		CV cv = new CV();
		File convFile = new File( file.getOriginalFilename());
		try {
			FileOutputStream fos = new FileOutputStream( convFile );
			fos.write( file.getBytes() );
			fos.close();
			String text = "";
			String fileExtension = convFile.getPath().split("\\.")[1];
			if(fileExtension.equals("pdf")) text = Utils.readPDFFile(convFile);
			else if(fileExtension.equals("docx")) text = Utils.readDocxFile(convFile);
			else if (fileExtension.equals("doc")) text = Utils.readDocFile(convFile);

			cv.setContent(text);
			cv.setFamilyName(familyName);
			cv.setFirstName(firstName);
			cv.setEmail(email);
			cv.setPhoneNumber(phoneNumber);
			cv.setAge(ParseCV.extractAge(text));
			cv.setContentWords(ParseCV.extractWords(text));
			cv.setSkills(ParseCV.extractSkills(text, cv.getContentWords()));

		} catch (IOException e) {
			e.printStackTrace();
			log.error("Error In Save CV from File" + e.getMessage());
		}
		repository.save(cv);
	}
}
