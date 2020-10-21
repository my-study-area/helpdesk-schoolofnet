package com.schoolofnet.helpdesk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;


import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.schoolofnet.helpdesk.models.Ticket;

public class TicketReportPdf {
	public static ByteArrayInputStream generate(List<Ticket> tickets) {
		Document doc = new Document();
		OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100);
			table.setWidths(new int[]{1,2,3});
			
			//THEADER
			PdfPCell headerCell;
			
			headerCell = new PdfPCell(new Phrase("ID"));
			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(headerCell);
			
			headerCell = new PdfPCell(new Phrase("Name"));
			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(headerCell);
			
			headerCell = new PdfPCell(new Phrase("Description"));
			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(headerCell);
			
			//TBODY
			PdfPCell bodyCell;
			for (Ticket ticket : tickets) {
				bodyCell = new PdfPCell(new Phrase(ticket.getId().toString()));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Phrase(ticket.getName()));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Phrase(ticket.getDescription()));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(bodyCell);
			}
			
			
			PdfWriter.getInstance(doc, byteArrayOutputStream);
			doc.open();
			Paragraph title = new Paragraph("Tickets by days");
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(25);
			doc.add(title);
			doc.add(table);
			doc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(((ByteArrayOutputStream) byteArrayOutputStream).toByteArray());
	}
}
