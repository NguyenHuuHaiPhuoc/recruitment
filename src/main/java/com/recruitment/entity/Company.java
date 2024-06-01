package com.recruitment.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
@Table(name="companies")
public class Company implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String tax_code;
	private String image;
	private String business_type;
	private String skill;
	private String headquarter;
	private Date establishment_date;
	private String sumary;
	private String web_url;
	private String email;
	private String phone;
	private Timestamp create_date;
	
	@OneToOne()
	@JoinColumn(name="account_id")
	private Account account;
}
