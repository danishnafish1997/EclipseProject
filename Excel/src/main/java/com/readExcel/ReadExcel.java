package com.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("t2");
		FileInputStream f = new FileInputStream(new File(str));
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheetAt(0);
		PrintWriter out = response.getWriter();
		Read obj = new Read();
		obj.readExcel(sheet, out);
		workbook.close();
	}

}
