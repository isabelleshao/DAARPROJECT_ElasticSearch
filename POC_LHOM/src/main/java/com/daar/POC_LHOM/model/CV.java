package com.daar.POC_LHOM.model;

import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import com.daar.POC_LHOM.helper.Indices;

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

	private String age;

	private List<String> contentWords;
}
