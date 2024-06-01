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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accounts", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"username"})
})
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private Timestamp create_date;
	private Boolean is_del;
	private String full_name;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account") //, cascade = CascadeType.ALL
	private Applicant applicant;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private Company company;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private Admin admin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private List<Authority> authorities;


	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", create_date="
				+ create_date + ", is_del=" + is_del + ", applicant=" + applicant + ", company=" + company
				+ ", authorities=" + authorities + "]";
	}
	
}
