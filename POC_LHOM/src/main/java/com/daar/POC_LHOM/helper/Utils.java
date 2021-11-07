package com.daar.POC_LHOM.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

@Slf4j
public class Utils {

	public static String readPDFFile(File file) {
		log.info("Parse Pdf is Starting");
		String text  ="";
		try {
			PDDocument doc = PDDocument.load(file);
			text = new PDFTextStripper().getText(doc);
		} catch (IOException e) {
			log.error("Error In Parsing Pdf" + e.getMessage());
			e.printStackTrace();
		}
		return text;
	}

	public  static String readDocxFile(File file) {
		log.info("Parse Docx file is Starting");
		String text = "";
		try
		{
			FileInputStream fis = new FileInputStream(file);
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			text = extractor.getText();
		}
		catch (Exception exep)
		{
			log.error("Error In read Docx" + exep.getMessage());
			exep.printStackTrace();
		}
		return text;
	}

	public  static String readDocFile(File file) {
		log.info("Read Doc file is Starting");
		WordExtractor extractor = null;
		String text = "";
		try
		{
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			HWPFDocument document = new HWPFDocument(fis);
			extractor = new WordExtractor(document);
			String[] paragraphs = extractor.getParagraphText();
			for (String paragraph: paragraphs)
			{
				if (paragraph != null)
					text+=paragraph;
			}
		}
		catch (Exception e)
		{
			log.error("Error In read Doc" + e.getMessage());
			e.printStackTrace();
		}
		return text;
	}

	public static String extractAge(String content){
		Pattern regEx= Pattern.compile("([0-9]{2}) *ans");
		Matcher matcher = regEx.matcher(content);
		if(matcher.find())
			return matcher.group(1);
		return "";
	}

	public static List<String> extractWords(String content){
		ArrayList<String> words= new ArrayList<>();

		for(String word : content.split(" |/|-|\\(|\\)|,")){
			try{
				String newWord = word.toLowerCase(Locale.ENGLISH).replace("\n", "");
				if(!newWord.matches("| |:|\\|")) {
					if(newWord.equals("asp.net".toLowerCase(Locale.ENGLISH))) words.add("aspdotnet");
					else if(newWord.equals("c#".toLowerCase(Locale.ENGLISH))) words.add("csharp");
					else if(newWord.equals("c++".toLowerCase(Locale.ENGLISH))) words.add("cpp");
					else words.add(newWord);
				}
			}catch (IllegalArgumentException e){
				log.error("Error in extract Words : "+ e.getMessage());
			}
		}
		return words.stream().distinct().collect(Collectors.toList());
	}
}
