package com.recruitment.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="code_option")
public class CodeOption implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String optionType;
	private String optionName;
	private String createBy;
	private Timestamp createDate;
	private boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "codeOption", fetch = FetchType.EAGER)
	private List<OptionDetail> optionDetail;
}
