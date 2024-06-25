package edu.icet.controller.user;

import edu.icet.InvoiceItem;
import edu.icet.InvoiceReportGenerator;
import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDashboardViewController {
    public void GenarateOnAction(ActionEvent actionEvent) throws JRException {
        // Sample data
        List<InvoiceItem> items = List.of(
                new InvoiceItem("Item 1", 2, 50.0),
                new InvoiceItem("Item 2", 1, 30.0)
        );

        // Calculate total price for each item
        for (InvoiceItem item : items) {
            item.setTotalPrice(item.getQuantity() * item.getUnitPrice());
        }

        // Parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("InvoiceNumber", "INV-12345");
        parameters.put("CustomerName", "John Doe");
        parameters.put("InvoiceDate", "2024-06-11");

        // Path to the compiled Jasper file
        String jasperFilePath = "D:\\Clothify-Store\\src\\main\\resources\\reports\\InvoiceReport.jrxml";



        // Generate the report
        new InvoiceReportGenerator().generateInvoiceReport(jasperFilePath, items, parameters);
    }
}
