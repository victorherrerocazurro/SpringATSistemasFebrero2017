package com.atsistemas.curso.vistas;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class AfinesPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<String> afines = (List<String>) model.get("listadoAfines");
			
			Table table = new Table(1);
			
			table.addCell("Afines");
			
			for (String afin : afines) {
				table.addCell(afin);
			}
			
			document.add(table);
	}

}
