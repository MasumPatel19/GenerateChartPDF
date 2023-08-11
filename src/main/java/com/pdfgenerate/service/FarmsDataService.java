package com.pdfgenerate.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import com.pdfgenerate.Entity.FarmsData;
import com.pdfgenerate.Repository.FarmsDataRepository;

@Service
public class FarmsDataService {

	@Autowired
	private FarmsDataRepository farmsDataRepository;

	public ByteArrayInputStream createPdf() {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, byteArrayOutputStream);

			document.open();

			List<FarmsData> dataList = farmsDataRepository.findAll();

			List<String> findByTableName = farmsDataRepository.findByTableName("farms_data");
			findByTableName.remove("id");
			findByTableName.remove("farms");
			System.out.println("column name : " + findByTableName);

			for (String nutrient : findByTableName) {
				JFreeChart chart = createChart(dataList, nutrient);

				// Convert the chart to an image(PNG) and insert into the PDF
				byte[] chartImageBytes = createChartImageBytes(chart);
				Image chartImage = Image.getInstance(chartImageBytes);
				chartImage.setAlignment(Element.ALIGN_CENTER);
				document.add(chartImage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}

		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}

	private JFreeChart createChart(List<FarmsData> dataList, String nutrient) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// data for the specific nutrient
		for (FarmsData item : dataList) {
			String farmName = item.getFarms();
			int nutrientValue = 0;

			if(nutrient.equals("Zinc")) {
				nutrientValue = item.getZinc();
			}
			else if (nutrient.equals("Magnesium")) {
				nutrientValue = item.getMagnesium();
			}
			else
			{
				nutrientValue = item.getCalcium();
			}

			dataset.addValue(nutrientValue, nutrient ,farmName);
		}

		JFreeChart chart = ChartFactory.createBarChart(nutrient + " Values by Farms", "Farms", nutrient + " Value",
				dataset, PlotOrientation.VERTICAL, false, false, false);

		return chart;
	}

	private byte[] createChartImageBytes(JFreeChart chart) throws IOException {
		ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
		ChartUtils.writeChartAsPNG(chartOutputStream, chart, 500, 300);
		return chartOutputStream.toByteArray();
	}

}
