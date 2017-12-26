package com.readExcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class ReadXExcel
 */
public class ReadXExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadXExcel() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file = request.getParameter("t5");
		int n =Integer.parseInt(request.getParameter("t6"));
		FileInputStream f = new FileInputStream(new File(file));
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheetAt(0);
		PrintWriter out =response.getWriter();
		ReadXData obj = new ReadXData();
		obj.getData(sheet, n ,out);
		workbook.close();
	}

}
