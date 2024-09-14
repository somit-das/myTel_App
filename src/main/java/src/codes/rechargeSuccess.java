package src.codes;

import java.sql.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/rechargeSuccess")

public class rechargeSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
 
        ServletContext sc=getServletContext();
        Object oo=(Object)sc.getAttribute("mobno1");
        String mobno=(String)oo;
        
        Object oo2=(Object)sc.getAttribute("payment1");
        String payment=(String)oo2;
        
        Object oo3=(Object)sc.getAttribute("validity1");
        String validity=(String)oo3;
        
        Object oo4=(Object)sc.getAttribute("datapack1");
        String datapack=(String)oo4;
        
    	Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMMM-yyyy");
		String rechargeDate=simpleformat.format(cal.getTime());
	    
	       try {
	    	   Connection con=DB.getCon();   
	    	   
	    	   PreparedStatement ps=con.prepareStatement("select MOBNO from pack_details where MOBNO=?");
	           ps.setString(1, mobno);
	           ResultSet res=ps.executeQuery();
	           if(res.next()) {
	               
	               PreparedStatement ps2=con.prepareStatement("Update pack_details set plan_amount='"+payment+"',validity='"+validity+"',Data_Perday='"+datapack+"',Recharge_Date='"+rechargeDate+"' where mobno=?");
		           ps2.setString(1, mobno);
		           ps2.executeUpdate();
	           }
	           else {
	        	   PreparedStatement ps3=con.prepareStatement("insert into pack_details values('"+mobno+"','"+payment+"','"+validity+"','"+datapack+"','"+rechargeDate+"')");
	               ps3.executeUpdate();
	           }
	       }
	       catch(Exception ee){
	    	   ee.printStackTrace();  
	       }
        
            pw.println("<!DOCTYPE html>");
      		pw.println("<html>");
      		pw.println("<head>");
      		pw.println("<title>Mytel Recharge Success</title>");
      		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
      		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
      		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
      		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
      		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
      		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
      		pw.println("<link rel='stylesheet' href='other/style.css'/>");
      		pw.println("<script src='other/fun.js'></script>");	
      		pw.println("</head>");
      		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
      		req.getRequestDispatcher("navbar.html").include(req, rs);
      		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
      	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
      		pw.println("<br>");
      		pw.println("<div style='text-align:center; margin-left:-2%;'><pre><h6>Recharge         Summary         Payment         Done</h6>");
      		pw.println("<div style='color:green;font-size:14px;margin-top:-2%;'><span class='bi bi-check-circle'><span>------------------<span class='bi bi-check-circle'><span>-----------------<span class='bi bi-check-circle'><span>------------------<span class='bi bi-check-circle'><span></div></div>");
      		pw.println("<div style='display:flex;justify-content:center;margin-left:-5%;'><span class='bi bi-check-circle-fill text-success' style='font-size:45px;'></span></div>");
      		pw.println("<h3 style='font-family: Times New Roman, Times, serif;font-weight:bold;text-align:center;margin-left:-5%;color:rgb(24, 34, 143);'>Recharge Successful</h3></div>");
      		pw.println("<p style='font-family: Times New Roman, Times, serif;color:grey;text-align:center;margin-left:-5%;'>We are processing the same and you will be notified via Email</p></div>");
          	
      		pw.println("<div style='margin-left:29%;background-color:white;box-shadow:0px 0px 2px rgb(228, 228, 228);border-radius:2px;width:38%;padding:2%;'>");
          	pw.println("<div class='row'><div class='col-6'><p style='color:grey; display:inline;'>Transaction ID</p></div><div class='col-1'></div><div class='col-5'>"+(Math.round(Math.random()*1000000000))*439+"</div></div><hr style='color:rgb(191, 190, 190);'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Subject</p></div><div class='col-1'></div><div class='col-5'>Mobile Recharge</div></div><hr style='color:lightgrey;'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Mobile No</p></div><div class='col-1'></div><div class='col-5'>"+mobno+"</div></div><hr style='color:lightgrey;'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Date</p></div><div class='col-1'></div><div class='col-5'>"+rechargeDate+"</div></div><hr style='color:lightgrey;'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Transaction Status</p></div><div class='col-1'></div><div class='col-5 text-success'>Success</div></div><hr style='color:lightgrey;'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Payment Amount</p></div><div class='col-1'></div><div class='col-5'>&#8377;"+payment+"</div></div><hr style='color:lightgrey;'>");
          	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Validity</p></div><div class='col-1'></div><div class='col-5'>"+validity+"</div></div>");
          	pw.println("</div><br>");
          	pw.println("<div style='display:flex;justify-content:center;margin-left:-5%;'><button class='btn btn-primary' onclick='recharge()'>Make Another Recharge</button></div>");
      		
      		
        pw.println("<br><br><br><img src='other/images/rsuccess.webp' class='img-fluid w-100 rounded-2'><br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='mobileRecharge';}function recharge(){window.location.href='mobileRecharge';}</script>");
        pw.println("</body>");
		pw.println("</html>"); 		
		pw.close();
	}
}

