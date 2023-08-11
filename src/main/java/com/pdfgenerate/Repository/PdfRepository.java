package com.pdfgenerate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdfgenerate.Entity.milkdata;

@Repository
public interface PdfRepository extends JpaRepository<milkdata, Integer>{

}
