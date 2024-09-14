package src.codes;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Prepaid_Postpaid")
public class Prepaid_Postpaid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
 
        String mobno=req.getParameter("preno");
        ServletContext sc=getServletContext();
        sc.setAttribute("conversionNo", mobno);
        
        Connection con=DB.getCon();
        
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Conversion Prepaid to Postpaid</title>");
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
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		try {
			 PreparedStatement ps=con.prepareStatement("select MOBNO,Typee from mrecharge where MOBNO=?");
		        ps.setString(1, mobno);
		        ResultSet res=ps.executeQuery();
		        if(res.next()) {
		        	if(res.getString(2).equals("Prepaid")) {
		        		req.getRequestDispatcher("ConversionImageBanner.html").include(req, rs);
		        		pw.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
		        		req.getRequestDispatcher("SimDelivery.html").include(req, rs);
		        		pw.println("<br><br><br>");
		        	}
		        	else {
		        		req.getRequestDispatcher("Conversion1.html").include(req, rs);
		        		pw.println("<div class='row text-center mx-1'><div class='col-6'><h4 style='color:red;font-family: Times New Roman, Times, serif;'>Your No:"+mobno+" is not a Prepaid No So, You Cannot Convert it to Postpaid <span class='bi bi-x-circle'></span></h4></div><div class='col-6'></div></div>");
		        		req.getRequestDispatcher("Conversion2.html").include(req, rs);
		        		pw.println("<br><div class='row w-100 h-25'><div class='col-6'><img src='other/images/pretopost.jpg' class='rounded-2 m-2 img-thumbnail'></div><div class='col-6'><img src='other/images/postpre.jpg' class='rounded-2 m-2 img-thumbnail'></div></div><br>");
		        		pw.println("<br>");
		        	}
		        }
		        else {
		        	req.getRequestDispatcher("Conversion1.html").include(req, rs);
	        		pw.println("<div class='row text-center mx-1'><div class='col-6'><h4 style='color:red;font-family: Times New Roman, Times, serif;'>Sorry, You do not have any Prepaid No for Conversion <span class='bi bi-x-circle'></span></h4></div><div class='col-6'></div></div>");
	        		req.getRequestDispatcher("Conversion2.html").include(req, rs);
	        		pw.println("<br><div class='row w-100 h-25'><div class='col-6'><img src='other/images/pretopost.jpg' class='rounded-2 m-2 img-thumbnail'></div><div class='col-6'><img src='other/images/postpre.jpg' class='rounded-2 m-2 img-thumbnail'></div></div><br>");
	        		pw.println("<br>");
		        }
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
	    req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='Sim_Conversion';} function mobileVal(){var num=document.getElementById('txt').value; if (isNaN(num)){ document.getElementById('eMsg').innerHTML='Mobile No Doesnot Contain Letters'.italics().fontcolor('red'); }else if(num.length==10){ document.getElementById('eMsg').innerHTML='';} else{document.getElementById('eMsg').innerHTML='Enter A Valid Mobile Number'.italics().fontcolor('red');}}");
		pw.println("function mobileVal2(){var num2=document.getElementById('txt2').value; if (isNaN(num2)){ document.getElementById('eMsg2').innerHTML='Mobile No Doesnot Contain Letters'.italics().fontcolor('red'); }else if(num2.length==10){ document.getElementById('eMsg2').innerHTML='';} else{document.getElementById('eMsg2').innerHTML='Enter A Valid Mobile Number'.italics().fontcolor('red');}}</script>");

    pw.println("</body>");
	pw.println("</html>"); 	
	}
}