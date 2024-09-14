package src.codes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/rechargePayment")

public class rechargePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
      String msg="";
      String validity="";
      String datapack="";
      String str=req.getParameter("javib");
     
      if(str.equals("jio1")) {
  		msg="179";
  		validity="28 Days";
  		datapack="2GB/Pack";
  	}else if(str.equals("jio2")) {
  		msg="209";
  		validity="28 Days";
  		datapack="1GB/Day";
  	}else if(str.equals("jio3")) {
  		msg="239";
  		validity="28 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("jio4")) {
  		msg="399";
  		validity="56 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("jio5")) {
  		msg="666";
  		validity="84 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("jio6")) {
  		msg="399";
  		validity="Till Bill Cycle";
  		datapack="75GB/Month";
  	}else if(str.equals("jio7")) {
  		msg="599";
  		validity="Till Bill Cycle";
  		datapack="100GB/Month";
  	}else if(str.equals("jio8")) {
  		msg="799";
  		validity="Till Bill Cycle";
  		datapack="150GB/Month";
  	}else if(str.equals("jio9")) {
  		msg="999";
  		validity="Till Bill Cycle";
  		datapack="200GB/Month";
  	}else if(str.equals("jio10")) {
  		msg="1499";
  		validity="Till Bill Cycle";
  		datapack="300GB/Month";
  	}else if(str.equals("airtel1")) {
  		msg="179";
  		validity="28 Days";
  		datapack="2GB/Pack";
  	}else if(str.equals("airtel2")) {
  		msg="265";
  		validity="28 Days";
  		datapack="1GB/Day";
  	}else if(str.equals("airtel3")) {
  		msg="299";
  		validity="28 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("airtel4")) {
  		msg="549";
  		validity="56 Days";
  		datapack="2GB/Day";
  	}else if(str.equals("airtel5")) {
  		msg="666";
  		validity="84 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("airtel6")) {
  		msg="399";
  		validity="Till Bill Cycle";
  		datapack="40GB/Month";
  	}else if(str.equals("airtel7")) {
  		msg="499";
  		validity="Till Bill Cycle";
  		datapack="75GB/Month";
  	}else if(str.equals("airtel8")) {
  		msg="649";
  		validity="Till Bill Cycle";
  		datapack="100GB/Month";
  	}else if(str.equals("airtel9")) {
  		msg="799";
  		validity="Till Bill Cycle";
  		datapack="100GB/Month";
  	}else if(str.equals("airtel10")) {
  		msg="1499";
  		validity="Till Bill Cycle";
  		datapack="200GB/Month";
  	}else if(str.equals("vi1")) {
  		msg="179";
  		validity="28 Days";
  		datapack="2GB/Pack";
  	}else if(str.equals("vi2")) {
  		msg="269";
  		validity="28 Days";
  		datapack="1GB/Day";
  	}else if(str.equals("vi3")) {
  		msg="299";
  		validity="28 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("vi4")) {
  		msg="479";
  		validity="56 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("vi5")) {
  		msg="719";
  		validity="84 Days";
  		datapack="1.5GB/Day";
  	}else if(str.equals("vi6")) {
  		msg="401";
  		validity="Till Bill Cycle";
  		datapack="50GB/Month";
  	}else if(str.equals("vi7")) {
  		msg="699";
  		validity="Till Bill Cycle";
  		datapack="80GB/Month";
  	}else if(str.equals("vi8")) {
  		msg="701";
  		validity="Till Bill Cycle";
  		datapack="Unlimited Data";
  	}else if(str.equals("vi9")) {
  		msg="1101";
  		validity="Till Bill Cycle";
  		datapack="Unlimited Data";
  	}else if(str.equals("vi10")) {
  		msg="1149";
  		validity="Till Bill Cycle";
  		datapack="300GB/Month";
  	}else if(str.equals("bsnl1")) {
  		msg="184";
  		validity="28 Days";
  		datapack="1GB/Day";
  	}else if(str.equals("bsnl2")) {
  		msg="199";
  		validity="30 Days";
  		datapack="2GB/Day";
  	}else if(str.equals("bsnl3")) {
  		msg="249";
  		validity="45 Days";
  		datapack="Unlimited Data";
  	}else if(str.equals("bsnl4")) {
  		msg="298";
  		validity="52 Days";
  		datapack="Unlimited Data";
  	}else if(str.equals("bsnl5")) {
  		msg="1515";
  		validity="365 Days";
  		datapack="Unlimited Data";
  	}else if(str.equals("bsnl6")) {
  		msg="399";
  		validity="Till Bill Cycle";
  		datapack="70GB/Month";
  	}else if(str.equals("bsnl7")) {
  		msg="525";
  		validity="Till Bill Cycle";
  		datapack="85GB/Month";
  	}else if(str.equals("bsnl8")) {
  		msg="798";
  		validity="Till Bill Cycle";
  		datapack="50GB/Month";
  	}else if(str.equals("bsnl9")) {
  		msg="999";
  		validity="Till Bill Cycle";
  		datapack="75GB/Month";
  	}else if(str.equals("bsnl10")) {
  		msg="1525";
  		validity="Till Bill Cycle";
  		datapack="Unlimited Data";
  	}
      ServletContext sc=getServletContext();
      sc.setAttribute("payment1", msg);
      sc.setAttribute("validity1", validity);
      sc.setAttribute("datapack1", datapack);
      
        pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Recharge Payment</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<link rel='stylesheet' href='other/pay1.css'/>");
		pw.println("<script src='other/fun.js'></script>");	
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
	    pw.println("<h2 class='heading2'>Enter Payment Details</h2>");
	    pw.println("<form action='rechargeSuccess' method='post'><div id='divv'><div class='my-4'><div class='row m-3'> <div class='col-9 m-2'><h4 class='form-label'>Debit/Credit Card Number</h4><div id='errorMsg1'></div><input type='text' id='txt1' class='form-control' placeholder='Enter Card Number' onkeyup='fun1()' required></div><div class='col-2 m-2'> <h4 class='form-label'>CVV</h4><div id='errorMsg2' style='margin-left:-23px;'></div><input type='text' class='form-control' id='txt2' placeholder='123' onkeyup='fun2()' required></div></div>");
	    pw.println("<div class='d-flex mx-5'><div class='row'><h4 class='form-label'>Expiry Date</h4><div class='col-3'><select name='months' id='months' class='form-select'><option value='Jan' selected>Jan</option> <option value='Feb'>Feb</option> <option value='Mar'>Mar</option><option value='Apr'>Apr</option><option value='May'>May</option><option value='Jun'>Jun</option><option value='Jul'>Jul</option><option value='Aug'>Aug</option><option value='Sep'>Sep</option><option value='Oct'>Oct</option> <option value='Nov'>Nov</option><option value='Dec'>Dec</option> </select></div>");
	    pw.println("<div class='col-3'><select name='years' id='years' class='form-select'> <option value='2000' selected>2000</option><option value='2001'>2001</option><option value='2002'>2002</option><option value='2003'>2003</option><option value='2004'>2004</option> <option value='2005\">2005</option><option value='2006'>2006</option><option value='2007'>2007</option><option value='2008'>2008</option><option value='2009'>2009</option><option value='2010'>2010</option><option value='2011'>2011</option><option value='2012'>2012</option><option value='2013'>2013</option><option value='2014'>2014</option><option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option><option value='2019'>2019</option><option value='2020'>2020</option><option value='2021'>2021</option><option value='2022'>2022</option><option value='2023'>2023</option><option value='2024'>2024</option> <option value='2025'>2025</option> <option value='2026'>2026</option><option value='2027'>2027</option> <option value='2028'>2028</option> <option value='2029'>2029</option><option value='2030'>2030</option></select></div>");
	    pw.println(" <div class='pp col-5 mx-3'> <img src='other/images/visa2.png'><img src='other/images/paypal2.jpg'><img src='other/images/mastercard2.png'></div> </div></div> <pre>  </pre> </div></div><br>");
		
	    if(str.equals("jio1") || str.equals("jio2") ||str.equals("jio3") || str.equals("jio4") || str.equals("jio5") || str.equals("airtel1") ||str.equals("airtel2") ||str.equals("airtel3") ||str.equals("airtel4") || str.equals("airtel5") || str.equals("bsnl1") ||str.equals("bsnl2") ||str.equals("bsnl3") ||str.equals("bsnl4") ||str.equals("bsnl5") ||str.equals("vi1") ||str.equals("vi2") ||str.equals("vi3") ||str.equals("vi4") ||str.equals("vi5")) {
	    pw.println("<button class='buttonn w-25'>Pay "+msg+"</button>");
	    }
	    else  if(str.equals("jio6") || str.equals("jio7") ||str.equals("jio8") || str.equals("jio9") || str.equals("jio10") || str.equals("airtel6") ||str.equals("airtel7") ||str.equals("airtel8") ||str.equals("airtel9") || str.equals("airtel10") || str.equals("bsnl6") ||str.equals("bsnl7") ||str.equals("bsnl8") ||str.equals("bsnl9") ||str.equals("bsnl10") ||str.equals("vi6") ||str.equals("vi7") ||str.equals("vi8") ||str.equals("vi9") ||str.equals("vi10")) {
	    	 pw.println("<button class='buttonn w-25'>Continue With "+msg+"</button></form>");	
	    }
		pw.println("<br><br>");
			
	    req.getRequestDispatcher("payCard.html").include(req, rs);
	    pw.println("<br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='mobileRecharge';}");
      	pw.println("function fun1(){ var num=document.getElementById('txt1').value;if (isNaN(num)){document.getElementById('errorMsg1').innerHTML='Card Number Doesnot Contain Letters'.italics().fontcolor('red');}else if(num.length==12){document.getElementById('errorMsg1').innerHTML='';}else{document.getElementById('errorMsg1').innerHTML='Invalid Card Number'.italics().fontcolor('red');}}function fun2(){var num=document.getElementById('txt2').value;if (isNaN(num)){document.getElementById('errorMsg2').innerHTML='CVV Doesnot Contain Letters'.italics().fontcolor('red');}else if(num.length==3){document.getElementById('errorMsg2').innerHTML='';}else{document.getElementById('errorMsg2').innerHTML='Invalid CVV'.italics().fontcolor('red');}}</script>");
		pw.println("</body>");
		pw.println("</html>"); 		
		pw.close();
	}
}

