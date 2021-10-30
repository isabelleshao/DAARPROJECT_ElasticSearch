package com.daar.POC_LHOM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public CVcontroller(SearchService service) {
		this.service = service;
	}

	@PostMapping
	public void save(@RequestBody final CV cv) {

		service.save(cv);
	}

	
	@DeleteMapping("/{id}")
	public void delete_CV(@PathVariable final String id) {
		service.delete_CV(id);

	}
	
	// curl -sS 'http://127.0.0.1:8080/api/v1/lhom?from=0&to=30&order=asc'

	@GetMapping(params = { "from", "to" })
	public ResponseEntity<List<CV>> get_CV_from_to(@RequestParam("from") String from, @RequestParam("to") String to) {

		return ResponseEntity.ok(service.get_CV_from_to(Integer.parseInt(from), Integer.parseInt(to)));

	}

	// curl http://127.0.0.1:8080/api/v1/lhom?tag=ocaml
	@GetMapping(params = { "tag" })
	public ResponseEntity<List<CV>> get_CV_tag(@RequestParam("tag") String tag) {

		return ResponseEntity.ok(service.get_CV_tag(tag));
	}

	@GetMapping
	public ResponseEntity<List<CV>> get_CV_all() {
		return ResponseEntity.ok(service.get_CV_all());
	}

	// curl http://127.0.0.1:8080/api/v1/lhom?tag=ocaml
	@GetMapping(params = { "prenom" })
	public ResponseEntity<List<CV>> get_CV_prenom(@RequestParam("prenom") String prenom) {
		System.out.println("CVcontroller.get_CV_prenom() = " + prenom);
		return ResponseEntity.ok(service.get_CV_prenom(prenom));
	}

	// curl http://127.0.0.1:8080/api/v1/lhom?nom=isaaaa
	@GetMapping(params = { "nom" })
	public ResponseEntity<List<CV>> get_CV_nom(@RequestParam("nom") String nom) {
		System.out.println("CVcontroller.get_CV_nom() = " + nom);
		return ResponseEntity.ok(service.get_CV_nom(nom));
	}
	
	// curl -sS 'http://127.0.0.1:8080/api/v1/lhom?contain=lorem'
	@GetMapping(params = { "contain" })
	public ResponseEntity<List<CV>> get_CV_contain_words(@RequestParam("contain") String words) {
		System.out.println("CVcontroller.get_CV_contain_words() = " + words);
		return ResponseEntity.ok(service.get_CV_contain_words(words));
	}


    //Creation du CV à partir d'un formulaire
    //CV/file
    @PostMapping("/file")
    public void send_pdf(@RequestPart("file") MultipartFile file,
                                        @RequestPart("nom") String nom,
                                        @RequestPart("prenom") String prenom,
                                        @RequestPart("email") String email,
                                        @RequestPart("tel") String tel)
            throws IOException {

        // La conversion d'un multipartfile en file. Mettre dans une methode dans le parsingPDF
        File convFile = new File( file.getOriginalFilename());
        
        
        
        
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        
        
        String text = "";

        CV cv = new CV(); 

        if(convFile.getPath().split("\\.")[1].equals("pdf")) {
        	 text =Utils.parsePDFFile(convFile);
 
        }

           cv.setContent(text); 
           cv.setNom(nom);
           cv.setPrenom(prenom); 
           cv.setEmail(email);
           cv.setTel(tel); 
        
           
           System.out.println(text);
           service.save(cv); 
        
        

        // ResponseEntity.created(URI.create("/api/v1/lhom")).body(service.save(cv));
    }


	
	

}
