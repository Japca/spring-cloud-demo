package com.japca.ribbonclient.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@Entity
public class Record {

	@Id
	@GenericGenerator( name = "record_id_seq_generator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "record_id_seq"),
					@Parameter(name = "initial_value", value = "1"),
					@Parameter(name = "increment_size", value = "1")
			})
	@GeneratedValue(generator = "record_id_seq_generator")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id_seq")
//	@SequenceGenerator(allocationSize = 1, name = "record_id_seq", sequenceName = "record_id_seq")
	private Long id;

	private String name;

	private String detail;

	public Record() {
	}

	public Record(String name, String detail) {
		this.name = name;
		this.detail = detail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
