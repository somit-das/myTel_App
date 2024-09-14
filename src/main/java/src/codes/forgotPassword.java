package src.codes;



import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/forgotPassword")

public class forgotPassword extends HttpServlet {
	   Statement st;
	   Connection con;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
	   rs.setContentType("text/html");
	   PrintWriter pw=rs.getWriter();
	   ServletContext sc=getServletContext();
	   String uname=req.getParameter("nm");
	   String pass =req.getParameter("password");
	   String pass2 =req.getParameter("password2");
	  try
	   {
		con=DB.getCon();   
        if(uname.endsWith("@gmail.com")) {
        	if(pass.equals(pass2)) {
        	PreparedStatement ps=con.prepareStatement("update mytel set password=? where mailID=?");
            ps.setString(1, pass);
            ps.setString(2, uname);
            ResultSet res=ps.executeQuery();
            if(res.next()) {
            	req.getRequestDispatcher("forgotPassword.html").include(req, rs);
            	pw.println("<h6 style='color:lightgreen;z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:550px;margin-top:-185px;'>Your Password has been Reset Successfully</h6>");
            }
    	    else {
    	    	req.getRequestDispatcher("forgotPassword.html").include(req, rs);
    	    	pw.println("<h6 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:530px;margin-top:-185px;'>There is no such MailId exists in Your Profile</h6>");
    	    	 }
        }
        	else {
        		req.getRequestDispatcher("forgotPassword.html").include(req, rs);
            	pw.println("<h6 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:570px;margin-top:-185px;'>Password & Confirm password doesnot match</h6>");
        	}
        }
        
        else {
        	if(pass.equals(pass2)) {
        	PreparedStatement ps=con.prepareStatement("update mytel set password=? where mobno=?");
            ps.setString(1, pass);
            ps.setString(2, uname);
            ResultSet res=ps.executeQuery();
            if(res.next()) {
            	req.getRequestDispatcher("forgotPassword.html").include(req, rs);
            	pw.println("<h6 style='color:lightgreen;z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:550px;margin-top:-185px;'>Your Password has been Reset Successfully</h6>");
                   }
    	    else {
    	    	req.getRequestDispatcher("forgotPassword.html").include(req, rs);
    	    	pw.println("<h6 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:530px;margin-top:-185px;'>There is no such PhNo exists in Your Profile</h6>");
    	    }
        }
        	else {
        		req.getRequestDispatcher("forgotPassword.html").include(req, rs);
            	pw.println("<h6 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:560px;margin-top:-185px;'>Password & Confirm password doesnot match</h6>");
            
        	}
        }
	    con.close();
	    }	 	
	   catch(SQLException e) {
		  e.printStackTrace();
		  pw.close();
	   }

}}
