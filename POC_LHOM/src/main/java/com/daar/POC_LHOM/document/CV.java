package com.daar.POC_LHOM.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import com.daar.POC_LHOM.helper.Indices;

// model layer 
@Document(indexName = Indices.CV_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class CV {
	
	  @Id
	    @Field(type = FieldType.Keyword)
	    private String id;
	    @Field(type = FieldType.Text)
	    private String title;
	    @Field(type = FieldType.Text)
	    private String content;
	    @Field(type = FieldType.Text)
	    private String author;
	    
	   
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }


}
