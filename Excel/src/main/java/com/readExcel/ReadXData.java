package com.readExcel;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadXData {
      public void getData(XSSFSheet sheet,int n,PrintWriter out){
    	  Iterator<Row> rowIterator = sheet.iterator();
  		Iterator<Row> rowIterator1 = sheet.iterator();
  		List <String> obj = new ArrayList<>();
  		while(rowIterator1.hasNext())
  		{
  			Row row1 = rowIterator1.next();
  			Iterator<Cell> cellIterator1 = row1.iterator();
  			while(cellIterator1.hasNext())
  			{ 
  				Cell cell = cellIterator1.next();
  				if(cell.getCellType() == 1)
  				{
  					obj.add(cell.getStringCellValue());
  				}
  			}
  				
  		}
  		for (int i =1; i< obj.size();i++)
  		{
  			if(obj.get(i).length()>obj.get(0).length())
  			{
  				obj.set(0, obj.get(i));
  			}
  				
  		}
  		while(rowIterator.hasNext() && n>=0)
  		{
  			Row row = rowIterator.next();
  			Iterator<Cell> cellIterator =row.iterator();
  			while(cellIterator.hasNext())
  			{ 
  				Cell cell = cellIterator.next();
  				switch(cell.getCellType())
  				{
  				case 0:
  					if(DateUtil.isCellDateFormatted(cell)){
  						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  					    String s = sdf.format (cell.getDateCellValue());
  					    out.print(s);
  					}
  					
  					else 
  						out.print(cell.getNumericCellValue());
  					for(int i =0;i<(obj.get(0).length()-3);i++)
  						out.print(" ");
  					break;
  				case 1:
  					out.print(cell.getStringCellValue() );
  					for(int i =0;i<(obj.get(0).length()-cell.getStringCellValue().length());i++)
  						out.print(" ");
  					break;
  				case Cell.CELL_TYPE_BOOLEAN:
  					out.print(cell.getBooleanCellValue());
  					if(cell.getBooleanCellValue()){
  					for(int i =0;i<8;i++)
  						out.print(" ");}
  					else{
  						for(int i =0;i<7;i++)
  							out.print(" ");
  					}
  					break;
  				}
  			}
  			out.println();
  			n--;
  		}
  	
      }
}
