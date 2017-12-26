package demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.poi.ss.usermodel.Row;

/**
 * Servlet implementation class ReadServlet
 */
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("t1");
		PrintWriter out = response.getWriter();
		FileInputStream f = new FileInputStream(new File(str));
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String sname = sheet.getSheetName();
		String name="";
		for(int i=0;i<sname.length();i++){
			if(sname.charAt(i)!=' ')
			  name += sname.charAt(i);
		}
		Iterator<Row> rowIterator = sheet.iterator();
		Iterator<Row>rowIterator1 = sheet.iterator();
		try {
			demo.model.Dao obj = new demo.model.Dao();
			obj.createTable(rowIterator, name);
			obj.insertData(rowIterator1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		out.print("saved successfully");
		
		workbook.close();

	}

	

}
