package com.daar.POC_LHOM.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

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
		System.out.println(text);
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
		catch (Exception exep)
		{
			log.error("Error In read Doc" + exep.getMessage());
			exep.printStackTrace();
		}
		System.out.println(text);
		return text;
	}

	public static HashSet<String> fileToHashSet(File file) throws FileNotFoundException {
		HashSet<String> res= new HashSet<>();

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			res.add(line.toLowerCase(Locale.ENGLISH));
		}

		return res;
	}
}
