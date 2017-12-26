package demo.model;


import java.sql.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;


/**
 * Hello world!
 *
 */
public class Dao 
{
	 Connection con;
 	String url = "jdbc:mysql://localhost:3306/college";
 	String uname = "root";
 	String password = "Atif123#1";
 	 public Dao() throws ClassNotFoundException, SQLException {
 		 Class.forName("com.mysql.jdbc.Driver");
 		  con = DriverManager.getConnection(url, uname, password);
 	  }
     public void createTable( Iterator<Row> r , String name1) throws SQLException, ClassNotFoundException
    {
        Row row = r.next();
        Iterator<Cell> cellIterator = row.iterator();
        String column_name = cellIterator.next().getStringCellValue();
        List<String> name = new ArrayList<>();
		String sql="create table " + name1+"(" + column_name+ " varchar(30)" +")";
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		name.add(column_name);
		while (cellIterator.hasNext())
		{
			Cell cell = cellIterator.next(); 
			column_name = cell.getStringCellValue();
			sql = "alter table "+ name1+" add column " + column_name + " varchar(30)";
			st.executeUpdate(sql);
			name.add(column_name);
		} 
	    Row row1 = r.next();
	    Iterator<Cell> cellIterator1 = row1.iterator();
	    int i = 0;
	    while(cellIterator1.hasNext())
	    {
	    	Cell cell = cellIterator1.next();
	    	switch(cell.getCellType())
	    	{
	    	case 0:
	    		if(DateUtil.isCellDateFormatted(cell))
	    			sql = "alter table "+ name1+"  modify " + name.get(i) + " Date";
	    		else
	    			sql = "alter table "+ name1+"  modify " + name.get(i) + " DOUBLE";
	    		st.executeUpdate(sql);
	    		break;
	    	case Cell.CELL_TYPE_BOOLEAN:	
	    		sql = "alter table "+ name1+"  modify " + name.get(i) + " boolean";
	    		st.executeUpdate(sql);
	    		break; 	
	    	}
	    	i++;
	    }
    }	 
   public void insertData(Iterator<Row>r,String name) throws SQLException
	{
		Row row=r.next();
		String s = "";
		Iterator<Cell> cell1 = row.iterator();
		while(cell1.hasNext())
		{
			cell1.next();
			s+="?,";
		}
		String Sql="";
		for(int i=0;i<s.length()-1;i++)
			Sql+=s.charAt(i);
		String sql = "insert into "+ name+ " values("+Sql+")";
		PreparedStatement st = con.prepareStatement(sql);
		while(r.hasNext())
		{
			int count=1;
			Row row1 = r.next();
			Iterator<Cell> cellIterator = row1.iterator();
			while(cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				switch(cell.getCellType())
				{
				case 0:
					if(DateUtil.isCellDateFormatted(cell)){
						st.setDate(count,new java.sql.Date(cell.getDateCellValue().getTime()));
					}
					else
						st.setDouble(count,cell.getNumericCellValue());
					count++;
					break;
				case 1:
					st.setString(count,cell.getStringCellValue() );
					count++;
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					st.setBoolean(count, cell.getBooleanCellValue());
					count++;
					break;
				}
			}
			st.executeUpdate();
		}
	}
}  