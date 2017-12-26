package com.convertToCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class ExcelToCsv
 */
public class ExcelToCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("t3");
		String destination = request.getParameter("t4");
		FileInputStream f = new FileInputStream(new File(source));
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheetAt(0);
		PrintWriter out = response.getWriter();
		Csv obj = new Csv(destination);
		obj.convertToCsv(sheet);
		obj.getCsvFile(out);
		
		workbook.close();
	}
 
}
