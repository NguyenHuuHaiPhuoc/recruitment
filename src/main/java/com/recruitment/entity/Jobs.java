package com.recruitment.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobs")
public class Jobs implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String position;
	private String level;
	private String tech_use;
	private String year_exp;
	private String salary;
	private Integer member;
	private Timestamp expiration_date;
	private String contract_type;
	private String working_form;
	private String job_desc;
	private String require;
	private String welfare;
	private String time_work;
	private String address_work;
	private Timestamp create_date;
	private String create_by;
	private Boolean status;
	private String is_confirmed;
	private String confirm_by;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobs")
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<JobInteract> jopInteract;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobs")
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Process> process;

}
