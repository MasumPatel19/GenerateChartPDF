package com.pdfgenerate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdfgenerate.Entity.FarmsData;

@Repository
public interface FarmsDataRepository extends JpaRepository<FarmsData, Long>{

}
