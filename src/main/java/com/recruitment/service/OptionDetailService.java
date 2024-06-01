package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.OptionDetail;

public interface OptionDetailService {
	List<OptionDetail> findAll();
	
	OptionDetail findById(Integer id);
	
	OptionDetail create (OptionDetail optionDetail);
	
	OptionDetail update (OptionDetail optionDetail);
	
	void delete (Integer id);
	
	List<OptionDetail> technologiesUsing ();
	
	List<OptionDetail> levels ();
	
	List<OptionDetail> contract_types ();
	
	List<OptionDetail> working_forms ();
	
	List<OptionDetail> optionDetailByCodeOptionId(Integer id);
	
	boolean existsByOptionName(Integer codeOpID,String optionName);
}
