package com.japca.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jakub Krhovják on 5/10/18.
 */

@Document
@Data
public class Record {

	public Record(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Id
	private String id;

	@Indexed
	private String name;

	@Indexed
	private int age;


}
