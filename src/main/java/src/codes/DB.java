package src.codes;

import java.sql.*;
public class DB {
public static Connection getCon(){
	Connection con = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Jilucse2002");
	}catch(Exception ex){System.out.println(ex);}
	return con;
}
}
