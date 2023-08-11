package com.pdfgenerate.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdfgenerate.service.FarmsDataService;
import com.pdfgenerate.service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
//	private PdfService pdfService;
	private FarmsDataService farmsDataService;

	@GetMapping("/generatepdf")
	public ResponseEntity<InputStreamResource> createPdf() {
//		ByteArrayInputStream createPdf = pdfService.createPdf();
		ByteArrayInputStream createPdf = farmsDataService.createPdf();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ContentData", "inline;file=testpdf.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(createPdf));

	}

}
