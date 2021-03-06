package com.noxus.draven.pdf.controller;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("pdf")
public class PDFController {


    @RequestMapping(value = "/location", method = {RequestMethod.GET})
    public void location(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        //Creating PDF document object
        PDDocument document = new PDDocument();
        //Saving the document
        document.save("my_doc.pdf");
        System.out.println("PDF created");
        //Closing the document
        document.close();
    }

    @RequestMapping(value = "/page", method = {RequestMethod.GET})
    public void page(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //Creating PDF document object
        PDDocument document = new PDDocument();
        for (int i = 0; i < 10; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();
            //Adding the blank page to the document
            document.addPage(blankPage);
        }
        //Saving the document
        document.save("my_doc.pdf");
        System.out.println("PDF created");
        //Closing the document
        document.close();
    }

    @RequestMapping(value = "/create", method = {RequestMethod.GET})
    public void create(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //Loading an existing document
        File file = new File("/Users/draven/Documents/documents/java/document/draven-spring/sample.pdf");
        PDDocument document = PDDocument.load(file);
        System.out.println("PDF loaded");
        //Adding a blank page to the document
        document.addPage(new PDPage());
        //Saving the document
        document.save("sample1.pdf");
        //Closing the document
        document.close();
    }

    @RequestMapping(value = "/createA4", method = {RequestMethod.GET})
    public void createA4(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        // Create a new document with an empty page.
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        // Adobe Acrobat uses Helvetica as a default font and
        // stores that under the name '/Helv' in the resources dictionary
        PDFont font = PDType1Font.HELVETICA;
        PDResources resources = new PDResources();
        resources.put(COSName.getPDFName("Helv"), font);

        // Add a new AcroForm and add that to the document
        PDAcroForm acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);

        // Add and set the resources and default appearance at the form level
        acroForm.setDefaultResources(resources);

        // Acrobat sets the font size on the form level to be
        // auto sized as default. This is done by setting the font size to '0'
        String defaultAppearanceString = "/Helv 0 Tf 0 g";
        acroForm.setDefaultAppearance(defaultAppearanceString);

        // Add a form field to the form.
        PDTextField textBox = new PDTextField(acroForm);
        textBox.setPartialName("SampleField");
        // Acrobat sets the font size to 12 as default
        // This is done by setting the font size to '12' on the
        // field level.
        // The text color is set to blue in this example.
        // To use black, replace "0 0 1 rg" with "0 0 0 rg" or "0 g".
        defaultAppearanceString = "/Helv 12 Tf 0 0 1 rg";
        textBox.setDefaultAppearance(defaultAppearanceString);

        // add the field to the acroform
        acroForm.getFields().add(textBox);

        // Specify the annotation associated with the field
        PDAnnotationWidget widget = textBox.getWidgets().get(0);
        PDRectangle rect = new PDRectangle(50, 750, 200, 50);
        widget.setRectangle(rect);
        widget.setPage(page);

        // set green border and yellow background
        // if you prefer defaults, just delete this code block
        PDAppearanceCharacteristicsDictionary fieldAppearance
                = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
        fieldAppearance.setBorderColour(new PDColor(new float[]{0, 1, 0}, PDDeviceRGB.INSTANCE));
        fieldAppearance.setBackground(new PDColor(new float[]{1, 1, 0}, PDDeviceRGB.INSTANCE));
        widget.setAppearanceCharacteristics(fieldAppearance);

        // make sure the annotation is visible on screen and paper
        widget.setPrinted(true);

        // Add the annotation to the page
        page.getAnnotations().add(widget);

        // set the field value
        textBox.setValue("Sample field");

        document.save("SimpleForm.pdf");
        document.close();
    }
}

