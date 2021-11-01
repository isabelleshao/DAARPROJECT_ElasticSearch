package com.daar.POC_LHOM.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import com.daar.POC_LHOM.helper.Indices;

// model layer 
@Document(indexName = Indices.CV_INDEX)
@Setting(settingPath = "static/es-settings.json")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CV {

	@Id
	@Field(type = FieldType.Keyword)
	private String id;
	
	@Field(type = FieldType.Text)
	private String familyName;
	
	@Field(type = FieldType.Text)
	private String firstName;

	@Field(type = FieldType.Text)
	private String email;
	
	@Field(type = FieldType.Text)
	private String phoneNumber;
	
	@Field(type = FieldType.Text)
	private String content;

	@Getter @Setter
	private String age;

	@Getter @Setter
	private List<String> skills;

	@Getter @Setter
	private List<String> contentWords;
}
