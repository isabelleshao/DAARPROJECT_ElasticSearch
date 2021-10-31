package com.daar.POC_LHOM.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

@Slf4j
public class Utils {
	public static String parsePDFFile(File fileName) {
		log.info("Parse Pdf is Starting");
		String text  ="";
		try {
			PDDocument doc = PDDocument.load(fileName);
			text = new PDFTextStripper().getText(doc);
		} catch (IOException e) {
			log.error("Error In Parsing Pdf" + e.getMessage());
			e.printStackTrace();
		}
		return text;
	}

	public  static String parseDocxFile(File fileName) {
		log.info("Parse Docx is Starting");
		String txt = "";
		try {
			FileInputStream fis = new FileInputStream(fileName.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphs = document.getParagraphs();
			for (XWPFParagraph para : paragraphs) {
				txt+=para.getText();
			}
			fis.close();
		} catch (Exception e) {
			log.error("Error In Parsing Docx" + e.getMessage());
			e.printStackTrace();
		}
		return txt;
	}

	public static String readDocFile(String fileName) {
		log.info("Parse Doc is Starting");
		String txt = "";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			HWPFDocument doc = new HWPFDocument(fis);
			WordExtractor we = new WordExtractor(doc);
			String[] paragraphs = we.getParagraphText();
			System.out.println("Total no of paragraph " + paragraphs.length);
			for (String para : paragraphs) {
				txt+=para;
			}
			fis.close();
		} catch (Exception e) {
			log.error("Error In Parsing Doc" + e.getMessage());
			e.printStackTrace();
		}
		return txt;
	}
}
