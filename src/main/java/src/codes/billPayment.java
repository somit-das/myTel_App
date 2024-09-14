package src.codes;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/billPayment")
public class billPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        Connection con=DB.getCon();
        String mobno=req.getParameter("mobileno");
        ServletContext sc=getServletContext();
        sc.setAttribute("Mobilenumber1", mobno);
	
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Bill Payment</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<link rel='stylesheet' href='other/pay1.css'/>");
		pw.println("<script src='other/fun.js'></script>");
		pw.println("<style>#bbttnn{background-image: linear-gradient(to right,#5155d8,#05bcb9);border:none;border-radius:25px;color:white;font-weight:bold;} #bbttnn:hover{background-image: linear-gradient(to right,#05bcb9,#5155d8);}</style>");
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		 try {
	    	   PreparedStatement ps=con.prepareStatement("select MOBNO,TYPEE from mrecharge where MOBNO=?");
	           ps.setString(1, mobno);
	           ResultSet res=ps.executeQuery();
	           
	           PreparedStatement ps2=con.prepareStatement("select Mobno,Plan_Amount from Pack_Details where Mobno=?");
	           ps2.setString(1, mobno);
	           ResultSet res2=ps2.executeQuery();
	           if(res.next()) {
	        	   if(!res.getString(2).equals("Postpaid")) {
	        		    req.getRequestDispatcher("BillForm1.html").include(req, rs);
	        			pw.println("<center><h4 style='font-family: Times New Roman, Times, serif;color:red;'>Your No:"+mobno+" is not a Postpaid No</h4></center>"); 
		        		req.getRequestDispatcher("BillForm2.html").include(req, rs);
	        		    pw.println("<br><br>");
	        			req.getRequestDispatcher("template1.html").include(req, rs);
	            	    pw.println("<br>");
	        	   }
	        	   else {
	        		   if(res2.next()) {
	        			   String payAmount=res2.getString(2);
	        			   if(!payAmount.equals("0")) {
	        			   sc.setAttribute("BillAmount", payAmount);
	        			   pw.println("<h2 class='heading2'>Enter Due Bill Payment Details</h2>");
	        			    pw.println("<form action='billSuccess' method='post'><div id='divv'><div class='my-4'><div class='row m-3'> <div class='col-9 m-2'><h4 class='form-label'>Debit/Credit Card Number</h4><div id='errorMsg1'></div><input type='text' id='txt1' class='form-control' placeholder='Enter Card Number' onkeyup='fun1()' required></div><div class='col-2 m-2'> <h4 class='form-label'>CVV</h4><div id='errorMsg2' style='margin-left:-23px;'></div><input type='text' class='form-control' id='txt2' placeholder='123' onkeyup='fun2()' required></div></div>");
	        			    pw.println("<div class='d-flex mx-5'><div class='row'><h4 class='form-label'>Expiry Date</h4><div class='col-3'><select name='months' id='months' class='form-select'><option value='Jan' selected>Jan</option> <option value='Feb'>Feb</option> <option value='Mar'>Mar</option><option value='Apr'>Apr</option><option value='May'>May</option><option value='Jun'>Jun</option><option value='Jul'>Jul</option><option value='Aug'>Aug</option><option value='Sep'>Sep</option><option value='Oct'>Oct</option> <option value='Nov'>Nov</option><option value='Dec'>Dec</option> </select></div>");
	        			    pw.println("<div class='col-3'><select name='years' id='years' class='form-select'> <option value='2000' selected>2000</option><option value='2001'>2001</option><option value='2002'>2002</option><option value='2003'>2003</option><option value='2004'>2004</option> <option value='2005\">2005</option><option value='2006'>2006</option><option value='2007'>2007</option><option value='2008'>2008</option><option value='2009'>2009</option><option value='2010'>2010</option><option value='2011'>2011</option><option value='2012'>2012</option><option value='2013'>2013</option><option value='2014'>2014</option><option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option><option value='2019'>2019</option><option value='2020'>2020</option><option value='2021'>2021</option><option value='2022'>2022</option><option value='2023'>2023</option><option value='2024'>2024</option> <option value='2025'>2025</option> <option value='2026'>2026</option><option value='2027'>2027</option> <option value='2028'>2028</option> <option value='2029'>2029</option><option value='2030'>2030</option></select></div>");
	        			    pw.println(" <div class='pp col-5 mx-3'> <img src='other/images/visa2.png'><img src='other/images/paypal2.jpg'><img src='other/images/mastercard2.png'></div> </div></div> <pre>  </pre> </div></div><br>");
	        			    pw.println("<button class='buttonn w-25'>Pay "+payAmount+"</button><form><br><br><br>");  
	        			   req.getRequestDispatcher("payCard.html").include(req, rs);
	        			   pw.println("<br>");
	        			   }
	        			   else {
	        				   req.getRequestDispatcher("BillForm1.html").include(req, rs);
		        			   pw.println("<center><h4 style='color:red;font-family: Times New Roman, Times, serif;'>Your Bill has been already Paid So,<br>There is no any Due Bill in your Number:"+mobno+"</h4></center>");  
		        			   req.getRequestDispatcher("BillForm2.html").include(req, rs);
		        			   pw.println("<br><br>");
			        		   req.getRequestDispatcher("template1.html").include(req, rs);
			            	   pw.println("<br>");
	        			   }
	        		   }
	        		   else {
	        			   req.getRequestDispatcher("BillForm1.html").include(req, rs);
	        			   pw.println("<center><h4 style='color:red;font-family: Times New Roman, Times, serif;'>There is no any Due Bill in your Number:"+mobno+"</h4></center>");  
	        			   req.getRequestDispatcher("BillForm2.html").include(req, rs);
	        			   pw.println("<br><br>");
		        		   req.getRequestDispatcher("template1.html").include(req, rs);
		            	   pw.println("<br>");
	        		   }
	        	   }
	           }
	           else {
	        	req.getRequestDispatcher("BillForm1.html").include(req, rs);
	        	pw.println("<center><h4 style='color:red;font-family: Times New Roman, Times, serif;'>There are no Such Postpaid Nos in Your Profile <span class='bi bi-x-circle'></span></h4></center>"); 
	       		req.getRequestDispatcher("BillForm2.html").include(req, rs);
	       	    pw.println("<br><br>");
	       		req.getRequestDispatcher("template1.html").include(req, rs);
	    	    pw.println("<br>");
	           } 
	       }
	       catch(Exception ee) {
	    	   ee.printStackTrace();
	       }
	pw.println("<br>");
	req.getRequestDispatcher("footer.html").include(req, rs);
	pw.println("<script>function backk(){window.location.href='payBill';} function mobileVal(){var num=document.getElementById('txt').value; if (isNaN(num)){ document.getElementById('eMsg').innerHTML='Mobile No Doesnot Contain Letters'.italics().fontcolor('red'); }else if(num.length==10){ document.getElementById('eMsg').innerHTML='';} else{document.getElementById('eMsg').innerHTML='Enter A Valid Mobile Number'.italics().fontcolor('red');}}");
	pw.println("function fun1(){ var num=document.getElementById('txt1').value;if (isNaN(num)){document.getElementById('errorMsg1').innerHTML='Card Number Doesnot Contain Letters'.italics().fontcolor('red');}else if(num.length==12){document.getElementById('errorMsg1').innerHTML='';}else{document.getElementById('errorMsg1').innerHTML='Invalid Card Number'.italics().fontcolor('red');}}function fun2(){var num=document.getElementById('txt2').value;if (isNaN(num)){document.getElementById('errorMsg2').innerHTML='CVV Doesnot Contain Letters'.italics().fontcolor('red');}else if(num.length==3){document.getElementById('errorMsg2').innerHTML='';}else{document.getElementById('errorMsg2').innerHTML='Invalid CVV'.italics().fontcolor('red');}}</script>");
	pw.println("</body>");
	pw.println("</html>"); 	
	}
}