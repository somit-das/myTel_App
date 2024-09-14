package src.codes;



import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/loginPage")

public class loginPage extends HttpServlet {
	 Statement st;
	   Connection con;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
	   rs.setContentType("text/html");
	   PrintWriter pw=rs.getWriter();
	   ServletContext sc=getServletContext();
	   String uname=req.getParameter("nm");
	   String pass =req.getParameter("password");
 
	  try
	   {
		con=DB.getCon();   
        if(uname.endsWith("@gmail.com")) {
        	PreparedStatement ps=con.prepareStatement("select MailID,Mobno,Password from mytel where MailID=? and Password=?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet res=ps.executeQuery();
            if(res.next()) {
    	       	req.getRequestDispatcher("Mainpage.html").include(req, rs);
    	    }
    	    else {
    	    	req.getRequestDispatcher("index.html").include(req, rs);
    	    	pw.println("<h5 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:490px;margin-top:-137px;'>Invalid Username & Password</h5>");
    	    }
        }
        else {
        	PreparedStatement ps=con.prepareStatement("select MailID,Mobno,Password from mytel where Mobno=? and Password=?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet res=ps.executeQuery();
            if(res.next()) {
    	       	req.getRequestDispatcher("Mainpage.html").include(req, rs);
    	    }
    	    else {
    	    	req.getRequestDispatcher("index.html").include(req, rs);
    	    	pw.println("<h5 style='color:rgb(255, 65, 65);z-index:1;px;font-weight:bold;font-family: Times New Roman, Times, serif;margin-left:490px;margin-top:-137px;'>Invalid Username & Password</h5>");
    	    }	
        }
        
        if(uname.endsWith("@gmail.com")) {
        PreparedStatement ps2=con.prepareStatement("select NAME,MOBNO,MAILID,PROFILE_PICTURE,ADDRESS from mytel where MailID=?");
        ps2.setString(1, uname);
        ResultSet res2=ps2.executeQuery();
        res2.next();
        String pname=res2.getString(1);
        sc.setAttribute("profileName", pname);
        String pmobno=res2.getString(2);
        sc.setAttribute("profileMobileNo", pmobno);
        String pmailid=res2.getString(3);
        sc.setAttribute("profileMailid", pmailid);
        String ppp=res2.getString(4);
        sc.setAttribute("profilePicture", ppp);
        String paddress=res2.getString(5);
        sc.setAttribute("profileAddress", paddress);
        }
        else {
        	 PreparedStatement ps2=con.prepareStatement("select NAME,MOBNO,MAILID,PROFILE_PICTURE,ADDRESS from mytel where Mobno=?");
             ps2.setString(1, uname);
             ResultSet res2=ps2.executeQuery();	
             res2.next();
             String pname=res2.getString(1);
             sc.setAttribute("profileName", pname);
             String pmobno=res2.getString(2);
             sc.setAttribute("profileMobileNo", pmobno);
             String pmailid=res2.getString(3);
             sc.setAttribute("profileMailid", pmailid);
             String ppp=res2.getString(4);
             sc.setAttribute("profilePicture", ppp);
             String paddress=res2.getString(5);
             sc.setAttribute("profileAddress", paddress);
        }
	    con.close();
	    }
	   catch(SQLException e) {
		  e.printStackTrace();
		  pw.close();
	   }

}}
