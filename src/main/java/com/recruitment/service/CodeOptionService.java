package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.CodeOption;

public interface CodeOptionService {
	List<CodeOption> findAllCodeOption();
	
	CodeOption findById(Integer id);
	
	CodeOption create (CodeOption codeOption);
	
	CodeOption update (CodeOption codeOption);
	
	void delete (Integer id);
	
	boolean existsByOptionType(String optionType);
}
