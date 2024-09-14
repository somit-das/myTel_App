package src.codes;

import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/billSuccess")
public class billSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        Connection con=DB.getCon();
        ServletContext sc=getServletContext();
        
        Object oo=(Object)sc.getAttribute("Mobilenumber1");
        String mobno=(String)oo;
        
        Object oo2=(Object)sc.getAttribute("BillAmount");
        String amount=(String)oo2;
        
        Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMMM-yyyy");
		String BillDate=simpleformat.format(cal.getTime());
	
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Bill Payment Success</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");
		pw.println("<style>#bbttnn{background-image: linear-gradient(to right,#5155d8,#05bcb9);border:none;border-radius:25px;color:white;font-weight:bold;} #bbttnn:hover{background-image: linear-gradient(to right,#05bcb9,#5155d8);}</style>");
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		pw.println("<div style='width:55%; margin-left:20%;padding:4% 8%;background-image: linear-gradient(to top right,#0097e6,#16b8b5)'>");
		
		try {
			 PreparedStatement ps=con.prepareStatement("select MOBNO,OPERATOR from mrecharge where MOBNO=?");
			   ps.setString(1, mobno);
	           ResultSet res=ps.executeQuery();
	           if(res.next()) {

		pw.println("<h4 class='text-center text-white' style='font-weight:bold;'>Bill Payment Successful</h4><h5 class='text-center text-white' style='font-weight:bold;'>for "+res.getString(2)+" Postpaid</h5></b><center><span class='bi bi-check-circle' style='font-weight:bold;color:green; background-color:white;border-radius:60% 60% 60% 50%;font-size:50px;'></span></center>");
		pw.println("<div class='p-5 w-100' style='border-left:2px solid white;font-family: Arial, Times, serif;background-color:white;border-radius:5px;margin-top:-9%;'>");
		pw.println("<div class='row'><div class='col-6'><p style='color:grey; display:inline;'>Txn Ref ID</p></div><div class='col-6'>"+(Math.round(Math.random()*1000000000))*439+"</div></div><hr style='color:rgb(191, 190, 190);'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Category</p></div><div class='col-5'>Postpaid</div></div><hr style='color:lightgrey;'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Mobile Number</p></div><div class='col-6'>"+mobno+"</div></div><hr style='color:lightgrey;'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Operator</p></div><div class='col-6'>"+res.getString(2)+"</div></div><hr style='color:lightgrey;'>");
      	
      	PreparedStatement ps2=con.prepareStatement("Update Pack_Details set Plan_Amount=0 where Mobno=?");
		ps2.setString(1, mobno);
        ps2.executeUpdate();
	           
	           }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Bill Status</p></div><div class='col-6 text-success'>Success</div></div><hr style='color:lightgrey;'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Transaction Date</p></div><div class='col-6'>"+BillDate+"</div></div><hr style='color:lightgrey;'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Transaction Time</p></div><div class='col-6'>"+java.time.LocalTime.now()+"</div></div><hr style='color:lightgrey;'>");
      	pw.println("<div style='margin-top:-2%;' class='row'><div class='col-6'><p style='color:grey; display:inline;'>Bill Amount</p></div><div class='col-6'>&#8377;"+amount+"</div></div>");
      	pw.println("<br></div><br><center><button class='btn btn-warning' onclick='backk()'>Make Another Bill Payment</button></center></div><br>");
		
		
		
	pw.println("<br><img src='other/images/billSuccess.png' class='img-thumbnail w-100 rounded-2'><br><br>");
	req.getRequestDispatcher("footer.html").include(req, rs);
	pw.println("<script>function backk(){window.location.href='payBill';}</script>");
    pw.println("</body>");
	pw.println("</html>"); 	
	}
}