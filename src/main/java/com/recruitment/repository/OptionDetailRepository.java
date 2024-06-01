package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitment.entity.OptionDetail;

public interface OptionDetailRepository extends JpaRepository<OptionDetail, Integer>{
	@Query(value="select * from option_detail where code_option_id = 1", nativeQuery = true)
	List<OptionDetail> technologiesUsing();
	
	@Query(value="SELECT od.* \r\n"
			+ "FROM option_detail as od \r\n"
			+ "JOIN code_option as cd \r\n"
			+ "ON od.code_option_id = cd.id\r\n"
			+ "WHERE od.code_option_id = 3\r\n"
			+ "and cd.id = 3\r\n"
			+ "and cd.option_type = 'LEVEL'", nativeQuery = true)
	List<OptionDetail> levels();
	
	@Query(value="SELECT od.* \r\n"
			+ "FROM option_detail as od \r\n"
			+ "JOIN code_option as cd \r\n"
			+ "ON od.code_option_id = cd.id\r\n"
			+ "WHERE od.code_option_id = 4\r\n"
			+ "and cd.id = 4\r\n"
			+ "and cd.option_type = 'CONTRACT_TYPE'", nativeQuery = true)
	List<OptionDetail> contract_types();
	
	@Query(value="SELECT od.* \r\n"
			+ "FROM option_detail as od \r\n"
			+ "JOIN code_option as cd \r\n"
			+ "ON od.code_option_id = cd.id\r\n"
			+ "WHERE od.code_option_id = 5\r\n"
			+ "and cd.id = 5\r\n"
			+ "and cd.option_type = 'WORKING_FORM'", nativeQuery = true)
	List<OptionDetail> working_forms();
	
	@Query(value="SELECT\r\n"
			+ "	op.id,\r\n"
			+ "	op.option_name,\r\n"
			+ "	(SELECT a.full_name FROM accounts AS a WHERE a.is_del = 'false' AND a.id = CAST(op.create_by AS INTEGER)) as create_by,\r\n"
			+ "	op.create_date\r\n,"
			+ "	op.code_option_id\r\n,"
			+ "	op.status\r\n"
			+ "FROM option_detail AS op\r\n"
			+ "WHERE op.status = 'false'\r\n"
			+ "AND op.code_option_id = ?1", nativeQuery = true)
	List<OptionDetail> optionDetailByCodeOptionId(Integer id);
	
	@Query(value="SELECT EXISTS \r\n"
			+ "(\r\n"
			+ "	SELECT * \r\n"
			+ "	FROM option_detail AS o \r\n"
			+ "	WHERE o.code_option_id = ?1\r\n"
			+ "	AND o.option_name LIKE ?2\r\n"
			+ ")", nativeQuery = true)
	boolean existsByOptionName(Integer codeOpID,String optionName);
}
