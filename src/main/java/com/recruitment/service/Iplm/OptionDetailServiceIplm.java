package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.OptionDetail;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.repository.OptionDetailRepository;
import com.recruitment.service.OptionDetailService;

@Service
public class OptionDetailServiceIplm implements OptionDetailService{
	@Autowired
	OptionDetailRepository detailRepository;
	
	@Override
	public List<OptionDetail> findAll() {
		// TODO Auto-generated method stub
		return detailRepository.findAll();
	}

	@Override
	public OptionDetail findById(Integer id) {
		// TODO Auto-generated method stub
		return detailRepository.findById(id).get();
	}

	@Override
	public OptionDetail create(OptionDetail optionDetail) {
		// TODO Auto-generated method stub
		return detailRepository.save(optionDetail);
	}

	@Override
	public OptionDetail update(OptionDetail optionDetail) {
		
		OptionDetail newOPDetail = detailRepository.save(optionDetail);
		if(newOPDetail == null)
			throw new AppException(ErrorCode.UPDATE_FAIL);
		
		return newOPDetail;
	}

	@Override
	public void delete(Integer id) {
		detailRepository.deleteById(id);
	}

	@Override
	public List<OptionDetail> technologiesUsing() {
		return detailRepository.technologiesUsing();
	}

	@Override
	public List<OptionDetail> levels() {
		return detailRepository.levels();
	}

	@Override
	public List<OptionDetail> contract_types() {
		// TODO Auto-generated method stub
		return detailRepository.contract_types();
	}

	@Override
	public List<OptionDetail> working_forms() {
		// TODO Auto-generated method stub
		return detailRepository.working_forms();
	}

	@Override
	public List<OptionDetail> optionDetailByCodeOptionId(Integer id) {
		return detailRepository.optionDetailByCodeOptionId(id);
	}

	@Override
	public boolean existsByOptionName(Integer codeOpID, String optionName) {
		return detailRepository.existsByOptionName(codeOpID, optionName);
	}

}
