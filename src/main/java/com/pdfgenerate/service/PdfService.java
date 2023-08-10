package com.pdfgenerate.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	public ByteArrayInputStream createPdf() {
		String title = "Welcome";
		String content = "Testing PDF";

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, byteArrayOutputStream);

			document.open();

			Paragraph paraTitle = new Paragraph(title);
			paraTitle.setAlignment(Element.ALIGN_CENTER);
			document.add(paraTitle);

			Paragraph paraContent = new Paragraph(content);
			document.add(paraContent);

			// Create a simple chart using JFreeChart
			JFreeChart chart = createChart();

			// Convert the chart to an image (PNG) and insert into the PDF
			byte[] chartImageBytes = createChartImageBytes(chart);
			Image chartImage = Image.getInstance(chartImageBytes);
			chartImage.setAlignment(Element.ALIGN_CENTER);
			document.add(chartImage);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}

		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}

	private JFreeChart createChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(10, "Series 1", "Category 1");
		dataset.addValue(20, "Series 1", "Category 2");
		dataset.addValue(30, "Series 1", "Category 3");

		JFreeChart chart = ChartFactory.createBarChart("Sample Chart", "Category", "Value", dataset,
				PlotOrientation.VERTICAL, false, false, false);

		return chart;
	}

	private byte[] createChartImageBytes(JFreeChart chart) throws IOException {
		ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
		ChartUtils.writeChartAsPNG(chartOutputStream, chart, 500, 300);
		return chartOutputStream.toByteArray();
	}

}
