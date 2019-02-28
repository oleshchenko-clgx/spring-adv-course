package beans.view;

import beans.models.Ticket;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PDFPageView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document doc, PdfWriter writer,
                                    HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Ticket> data = (List<Ticket>) model.get("tickets");

        Table table = new Table(3);
        table.addCell("Name");
        table.addCell("Seats");
        table.addCell("Price");

        for (Ticket ticket: data) {
            table.addCell(ticket.getEvent().getName());
            table.addCell(ticket.getSeats());
            table.addCell(String.valueOf(ticket.getPrice()));
        }

        doc.add(table);
    }
}
