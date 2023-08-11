package com.pdfgenerate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdfgenerate.Entity.FarmsData;

@Repository
public interface FarmsDataRepository extends JpaRepository<FarmsData, Long>{

//	@Query(value = "SHOW COLUMNS FROM farmdata.farms_data;", nativeQuery = true)
	@Query(value = "SELECT COLUMN_NAME\r\n"
			+ "FROM INFORMATION_SCHEMA.COLUMNS\r\n"
			+ "WHERE TABLE_NAME = 'farms_data';", nativeQuery = true)
    List<String> findByTableName(String columnName);
	
}
