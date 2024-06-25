package edu.icet;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceReportGenerator {
    public void generateInvoiceReport(String jasperFilePath, List<InvoiceItem> items, Map<String, Object> parameters) {
        try {
            JasperReport report = JasperCompileManager.compileReport(jasperFilePath);
            // Load the compiled Jasper report


            // Create a data source from the list of invoice items
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, "InvoiceReport.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}