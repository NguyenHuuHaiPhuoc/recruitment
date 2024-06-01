package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.CodeOption;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.repository.CodeOptionRepository;
import com.recruitment.service.CodeOptionService;

@Service
public class CodeOptionServiceIplm implements CodeOptionService{
	@Autowired
	CodeOptionRepository codeOptionRepository;
		
	@Override
	public List<CodeOption> findAllCodeOption() {
		// TODO Auto-generated method stub
		return codeOptionRepository.findAllCodeOption();
	}

	@Override
	public CodeOption findById(Integer id) {
		if (codeOptionRepository.existsById(id))
			throw new AppException(ErrorCode.OPJECT_NOT_FOUND);
		return codeOptionRepository.findById(id).get();
	}

	@Override
	public CodeOption create(CodeOption codeOption) {
		// TODO Auto-generated method stub
		return codeOptionRepository.save(codeOption);
	}

	@Override
	public CodeOption update(CodeOption codeOption) {
		// TODO Auto-generated method stub
		return codeOptionRepository.save(codeOption);
	}

	@Override
	public void delete(Integer id) {
		codeOptionRepository.deleteById(id);
	}

	@Override
	public boolean existsByOptionType(String optionType) {
		return codeOptionRepository.existsByOptionType(optionType);
	}

}
