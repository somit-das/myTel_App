package src.codes;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/newUser")

  public class newUser extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse rs) throws ServletException,IOException{
		Connection con;
	    Statement st;
	    ServletContext sc=getServletContext();
	    PrintWriter pw=rs.getWriter();
		rs.setContentType("text/html");
		String name=req.getParameter("nm");
		String mno=req.getParameter("mobno");
		String email=req.getParameter("mail");
		String pwd=req.getParameter("password");
		String add=req.getParameter("address");
		String picture=req.getParameter("profile");

		try {
			con=DB.getCon();
		    st=con.createStatement();
			PreparedStatement ps=con.prepareStatement("select Name,MobNo from mytel where Name=? and MobNo=?");
	        ps.setString(1,name);
	        ps.setString(2,mno); 
	        ResultSet res=ps.executeQuery();
	        
	        PreparedStatement ps2=con.prepareStatement("select MobNo from mytel where MobNo=?");
	        ps2.setString(1,mno); 
	        ResultSet res2=ps2.executeQuery();
	        
	        if(res.next()) {
	        	req.getRequestDispatcher("newuser.html").include(req, rs);
	        	pw.println("<h4 style='border: 1px solid grey; color:red;box-shadow:rgb(246, 44, 44); black;border-radius:6px;background-color:rgba(0,0,0,0.6);padding:10px 25px;margin-top:-465px;margin-left:-590px;font-weight:bold;font-family: Times New Roman, Times, serif;'>This Username:"+name+" & MobileNo:"+mno+"<br>Already Exists.Please Try Another!!</h4>");
	        	con.close();
				st.close();
	           }
	        else if(res2.next()){
	        	req.getRequestDispatcher("newuser.html").include(req, rs);
	        	pw.println("<h4 style='border: 1px solid grey;color:red;box-shadow:15px 15px 15px black;border-radius:6px;background-color:rgba(0,0,0,0.6);padding:10px 25px;margin-top:-465px;margin-left:-660px;font-weight:bold;font-family: Times New Roman, Times, serif;'>This MobileNo:"+mno+" Already Exists.<br>Please Try With Another Number!!</h4>");	
	        	con.close();
				st.close();
	        }
	        else {
			st.executeUpdate("insert into mytel values('"+name+"','"+mno+"','"+email+"','"+pwd+"','"+picture+"','"+add+"')");
			req.getRequestDispatcher("newuser.html").include(req, rs);
			pw.println("<h4 style='border: 1px solid grey;color:white;box-shadow:15px 15px 15px black;border-radius:6px;background-color:rgba(0,0,0,0.6);padding:10px 12px;margin-top:-458px;margin-left:-695px;font-weight:bold;font-family: Times New Roman, Times, serif;'>Congrats:"+name+",<br> Your Mytel Account is Created Successfully <span class='bi bi-check-circle-fill'></span></h4>");
			con.close();
			st.close();
	        }
		}
		catch(Exception ee) {
		pw.println("<p>"+ee+"</p>");
		}
		pw.close();
		}
}