package com.testsite.it.tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

public class NewTest {
    public static final String HTML = "<h1>Title</h1>"
			+ "<p>Some text</p>";
	
	
    public static void main( String[] args ) throws FileNotFoundException, IOException  
    {
        FileOutputStream fos = new FileOutputStream("htmltopdf.pdf");
    	HtmlConverter.convertToPdf(HTML, fos);
        System.out.println( "DONE" );
    }
}