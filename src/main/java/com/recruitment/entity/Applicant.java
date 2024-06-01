package com.recruitment.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="applicants")
public class Applicant implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String positions;
	private String email;
	private int phone;
	private String address;
	private String img;
	private String sumary;
	private int app_view;
	private Timestamp create_date;
	private Timestamp update_date;
	
	@OneToOne() //fetch = FetchType.LAZY
	@JoinColumn(name="account_id")
	private Account account;
}
