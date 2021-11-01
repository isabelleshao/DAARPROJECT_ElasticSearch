package com.daar.POC_LHOM.services;

import com.daar.POC_LHOM.model.CV;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SearchService {
    void save(final CV cv);
   // List<CV> getCvFromTo(int from, int to);
    List<CV> getCvByTag(String tag);
    List<CV> getCvAll();
    List<CV> getCvFirstName(String firstName);
    List<CV> getCvFamilyName(String familyName);
    List<CV> getCvByAge(String age);
  //  List<CV> searchCVByKeyWord(String word);
    void deleteCv(String id);
    void saveCVFromFile(MultipartFile file, String firstName, String familyName, String email, String phoneNumber);
}
