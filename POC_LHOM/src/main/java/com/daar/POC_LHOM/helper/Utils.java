package com.daar.POC_LHOM.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class Utils {
	


	public static String parsePDFFile(File fileName) {
		String text  ="";
		
		try {
			PDDocument doc = PDDocument.load(fileName);
			 text = new PDFTextStripper().getText(doc);
			;
			System.out.println("Text in PDF\n---------------------------------");
			System.out.println(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public  static String readDocxFile(String fileName) {
		String txt = "";
		try {
			File file = new File(fileName);

			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();

			System.out.println("Total no of paragraph " + paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
				txt+=para.getText();
			}
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	public static void readDocFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			HWPFDocument doc = new HWPFDocument(fis);

			WordExtractor we = new WordExtractor(doc);

			String[] paragraphs = we.getParagraphText();

			System.out.println("Total no of paragraph " + paragraphs.length);
			for (String para : paragraphs) {
				System.out.println(para.toString());
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
public static Set<String> extractSkills(String s) {
	Set<String> language  = new HashSet<>();
	
	return language ; 
	 
}

}
