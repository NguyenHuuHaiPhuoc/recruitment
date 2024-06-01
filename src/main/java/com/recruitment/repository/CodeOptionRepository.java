package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitment.entity.CodeOption;

public interface CodeOptionRepository extends JpaRepository<CodeOption, Integer>{
	
	@Query(value="SELECT\r\n"
			+ "	c.id,\r\n"
			+ "	c.option_type,\r\n"
			+ "	c.option_name,\r\n"
			+ "	(SELECT a.full_name FROM accounts AS a WHERE a.is_del = 'false' AND a.id = CAST(c.create_by AS INTEGER)) as create_by,\r\n"
			+ "	c.create_date,\r\n"
			+ "	c.status\r\n"
			+ "FROM code_option AS c\r\n"
			+ "WHERE c.status = 'false';", nativeQuery = true)
	List<CodeOption> findAllCodeOption();
	
	@Query(value="SELECT EXISTS \r\n"
			+ "(\r\n"
			+ "	SELECT * \r\n"
			+ "	FROM code_option AS c \r\n"
			+ "	WHERE c.status = 'false'\r\n"
			+ "	AND c.option_type LIKE ?1"
			+ ")", nativeQuery = true)
	boolean existsByOptionType(String optionType);
	
	boolean existsById(Integer id);
}
