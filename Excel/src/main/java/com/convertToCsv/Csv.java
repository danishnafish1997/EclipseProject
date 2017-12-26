package com.convertToCsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Csv {
	private String destination;
	public Csv(String destination){
		this.destination = destination;
	}
  public void convertToCsv(XSSFSheet sheet) throws IOException{
		PrintWriter outFile = new PrintWriter(new FileWriter(destination));
		for(int i=0;i<=sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			for(int j=0; j< row.getLastCellNum();j++){
				Cell cell = row.getCell(j);
				switch(cell.getCellType())
				{
				case 0:
					if(j==row.getLastCellNum()-1){
						if(DateUtil.isCellDateFormatted(cell))
							outFile.print(cell.getDateCellValue());
						else
							outFile.print(cell.getNumericCellValue());
					}
					else{
					  if(DateUtil.isCellDateFormatted(cell))
						  outFile.print(cell.getDateCellValue()+",");
					  else
						  outFile.print(cell.getNumericCellValue()+",");}
					break;
				case 1:
					if(j==row.getLastCellNum()-1){
					outFile.print(cell.getStringCellValue());}
					else{
						outFile.print(cell.getStringCellValue()+",");
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					if(j==row.getLastCellNum()-1){
					outFile.print(cell.getBooleanCellValue());}
					else{
						outFile.print(cell.getBooleanCellValue()+",");
					}
					break;
				}
			}
			outFile.println();
		}
		outFile.close();
  }
  public void getCsvFile(PrintWriter out) throws IOException{
	  BufferedReader br = new BufferedReader(new FileReader(destination)); 
	  String line = br.readLine();
	  while(line!=null)
	  {
		  out.println(line);
		  line = br.readLine();
	  }
	  br.close();
	  
  }
}
