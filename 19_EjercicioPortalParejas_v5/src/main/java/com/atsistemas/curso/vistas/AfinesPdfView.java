package com.atsistemas.curso.vistas;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.atsistemas.curso.entidades.Persona;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class AfinesPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Persona> afines = (List<Persona>) model.get("afines");
			
			Table table = new Table(4);
			
			table.addCell("Nombre");
			table.addCell("Edad");
			table.addCell("Altura");
			table.addCell("Genero");
			
			for (Persona afin : afines) {
				table.addCell(afin.getNombre());
				table.addCell(String.valueOf(afin.getEdad()));
				table.addCell(String.valueOf(afin.getAltura()));
				table.addCell(afin.getGenero());
			}
			
			document.add(table);
	}

}
