package src.codes;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ConversionSuccess")
public class ConversionSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        
        Connection con=DB.getCon();
        
        String fname=req.getParameter("fnm");
        String lname=req.getParameter("lnm");
        String city=req.getParameter("city");
        String zipcode=req.getParameter("zip");
        String add=req.getParameter("address");
        
        ServletContext sc=getServletContext();
        Object oo=(Object)sc.getAttribute("conversionNo");
        String mobno=(String)oo;

        
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Sim Conversion Success</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");
		pw.println(" <style> #btn1{color:white;background-image:linear-gradient(to bottom right,rgb(47, 144, 209),rgb(198, 3, 159));} #btn1:hover{color:white;background-image:linear-gradient(to bottom right,#12CBC4,#1289A7);} #btn2{color:white;background-image:linear-gradient(to bottom right,#1289A7,#12CBC4);} #btn2:hover{color:white;background-image:linear-gradient(to bottom right,rgb(47, 144, 209),rgb(198, 3, 159));}  #button1{font-weight:bold;background-color:white;padding:8px;width:50%;border:1px solid black;border-radius:45px;} #button1:hover{color:white;background-image:linear-gradient(to bottom right,#00a8ff,#1d22bf);} #button2{float:right;color:white;background-image:linear-gradient(to right,#1d22bf,#00a8ff);padding:7px;width:33%;border:1px solid #1d22bf;border-radius:45px;} #button2:hover{color:white;padding:7px;width:33%;border:1px solid black;border-radius:45px;background-image:linear-gradient(to bottom right,#00a8ff,#1d22bf);}@media screen and (max-width: 600px){.cimg{width:99%;height:310px;}</style>");
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);background-size:cover;'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		   
        try {
        	Statement st=con.createStatement();
			 PreparedStatement ps=con.prepareStatement("select MOBNO from SimDelivery_Address  where MOBNO=?");
		        ps.setString(1, mobno);
		        ResultSet res=ps.executeQuery();
		        
		        if(res.next()) {
		        	PreparedStatement ps2=con.prepareStatement("Update SimDelivery_Address set first_name='"+fname+"',last_name='"+lname+"',Address='"+add+"',city='"+city+"',zipcode='"+zipcode+"' where Mobno=?");
		    		ps2.setString(1, mobno);
		            ps2.executeUpdate();
		        }
		        else {
		        	st.executeUpdate("insert into SimDelivery_Address values('"+fname+"','"+lname+"','"+mobno+"','"+add+"','"+city+"','"+zipcode+"')");
		        }
		        PreparedStatement ps3=con.prepareStatement("select * from SimDelivery_Address where mobno=?");
		        ps3.setString(1, mobno);
		        ResultSet res3=ps3.executeQuery(); 

			    	PreparedStatement ps4=con.prepareStatement("Select Mobno,Typee from mrecharge where mobno=?");
		    		ps4.setString(1, mobno);
		            ResultSet res4=ps4.executeQuery();
		            
		            PreparedStatement ps6=con.prepareStatement("Select Mobno,Typee from mrecharge where mobno=?");
		    		ps6.setString(1, mobno);
		            ResultSet res6=ps6.executeQuery();
		            if(res6.next()) {
		            	String tt=res6.getString(2);
		            	sc.setAttribute("ttype", tt);
		            }
		            
		            if(res4.next()) {
		            	String type=res4.getString(2);
		            	if(type.equals("Prepaid")) {
		            		st.executeUpdate("Update mrecharge set typee='Postpaid' where Mobno='"+mobno+"' ");
		            		st.executeUpdate("Delete from Pack_details where Mobno='"+mobno+"'");
		            			st.executeUpdate("insert into Conversion_Numbers values('"+mobno+"','Conversion Happens')");
		            	}
		            	else {
		            	st.executeUpdate("Update mrecharge set typee='Prepaid' where Mobno='"+mobno+"'");
		            	st.executeUpdate("Delete from Pack_details where Mobno='"+mobno+"'");
	            			st.executeUpdate("insert into Conversion_Numbers values('"+mobno+"','Conversion Happens')");
		            	}
		            }
		            
		            PreparedStatement ps5=con.prepareStatement("Select Mobno,Typee from mrecharge where mobno=?");
		    		ps5.setString(1, mobno);
		            ResultSet res5=ps5.executeQuery();
		            if(res3.next()) {
		pw.println("<center><div style='margin-left:-5%;font-family: Times New Roman, Times, serif;width:65%;'><h1 style='text-shadow:0 0 5px black;font-weight:bold'>Sim Conversion Done!</h1><span class='bi bi-check-circle-fill' style='font-size:300%;color:rgb(3, 154, 3);border:5px dotted green;padding:4px;border-radius:50%;'></span>");
		if(res5.next()) {
		pw.println("<h3 style='font-weight:bold;color:deeppink'>Congrats "+fname+" "+lname+"!!! Your Number:"+mobno+" Conversion from "+sc.getAttribute("ttype")+" to "+res5.getString(2)+" is Completed.Your New SIM Will be Delivered To Your Registered Address("+res3.getString(4)+","+res3.getString(5)+", ZIP:"+res3.getString(6)+") Within 2/3 Working Days...</h3>");
		}
		pw.println("<h2 style='font-weight:bold;'>Thank You!!! </h2><br><button class='btn btn-primary' style='font-weight:bold;' onclick='backk()'>Go to Conversion Page</button></div></center><br><br><br>");
		}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	    req.getRequestDispatcher("template2.html").include(req, rs);
	    pw.println("<br><br>");
	    req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='Sim_Conversion';}</script>");
		
    pw.println("</body>");
	pw.println("</html>"); 	
	}
}