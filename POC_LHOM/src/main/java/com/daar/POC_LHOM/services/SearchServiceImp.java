package com.daar.POC_LHOM.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
	public List<CV>  getCvAll() {
		return repository.getCvAll();
	}

	@Override
	public List<CV> getCvFirstName(String firstName) {
		return repository.getCvFirstName(firstName);
	}

	@Override
	public List<CV> getCvFamilyName(String familyName) {
		return repository.getCvFamilyName(familyName);
	}

	@Override
	public List<CV> getCvByAge(String age) {
		return repository.getCvByAge(age);
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
		File parsedFile = new File( file.getOriginalFilename());
		try {
			FileOutputStream fos = new FileOutputStream( parsedFile );
			fos.write( file.getBytes() );
			fos.close();
			String text = "";
			String fileExtension = parsedFile.getPath().split("\\.")[1];
			if(fileExtension.equals("pdf")) text = Utils.readPDFFile(parsedFile);
			else if(fileExtension.equals("docx")) text = Utils.readDocxFile(parsedFile);
			else if (fileExtension.equals("doc")) text = Utils.readDocFile(parsedFile);

			cv.setContent(text);
			cv.setFamilyName(familyName);
			cv.setFirstName(firstName);
			cv.setEmail(email);
			cv.setPhoneNumber(phoneNumber);
			cv.setAge(Utils.extractAge(text));
			cv.setContentWords(Utils.extractWords(text));
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Error In Save CV from File" + e.getMessage());
		}
		repository.save(cv);
	}

	@Override
	public List<CV> getCvByTag(String tag) {
		if(tag.equals("asp.net".toLowerCase(Locale.ENGLISH))) tag = "aspdotnet";
		else if(tag.equals("c#".toLowerCase(Locale.ENGLISH))) tag = "csharp";
		else if(tag.equals("c++".toLowerCase(Locale.ENGLISH)))  tag = "cpp";
		return repository.getCvByTag(tag);
	}

}
