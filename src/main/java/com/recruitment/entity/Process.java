package com.recruitment.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="process")
public class Process implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String step;
	private String process_content;
	private Timestamp create_date;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Jobs jobs;

	@Override
	public String toString() {
		return "Process [id=" + id + ", step=" + step + ", process_content=" + process_content + ", create_date="
				+ create_date + ", jobs=" + jobs + "]";
	}
}
