package src.codes;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/activePlanDetails")
public class activePlanDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        String mobile=req.getParameter("mobnoo");
        
        Connection con=DB.getCon();
	
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Active Plans</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");
		pw.println("<style>#divv{border-radius:40px;} .rech{border-radius:20px;font-weight:bold;background-color:rgb(5,5,188);border:none;color:white;padding:8px;}.rech:hover{font-weight:bold;background-color:rgb(85, 85, 252);border:none;color:white;padding:8px;}</style> ");
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from pack_details where MOBNO=? ");
			ps.setString(1, mobile);
			ResultSet res = ps.executeQuery();
			PreparedStatement ps2 = con.prepareStatement("select MOBNO,typee from mrecharge where MOBNO=? ");
			ps2.setString(1, mobile);
			ResultSet res2 = ps2.executeQuery();
			if(res.next()) {
				String string=res.getString(4);
				String[] split=string.split("/");
				String value=split[0];
					if(res2.next()) {
					String type=res2.getString(2);
					if(type.equals("Postpaid")) {
				pw.println("<div class='d-flex justify-content-center' style='margin-left:-6%;'><div id='divv' class='shadow-lg w-50' style='padding:3% 5%;background-color:white;'><div class='d-flex justify-content-between'>");
				pw.println("<div class='d-flex justify-content-between'><h5 style='font-family: Times New Roman, Times, serif;'>Postpaid Mobile <span style='font-weight:bold;'>"+mobile+"</span></h5><br></div><div><button class='btn btn-close' onclick='backk()'></button></div></div><br>");
				pw.println("<div class='row'><div class='col-5' style='font-family: Times New Roman, Times, serif;'><span class='bi bi-arrow-down-up px-2 py-2' style='background-color:rgb(232, 232, 253);border-radius:50%;color:rgb(23, 23, 202);font-size:20px;'></span><h6 style='color:grey;font-family: Times New Roman, Times, serif;margin:4%;''>Data</h6>");
				pw.println("<h4 style='font-weight:bold;'>"+res.getString(4)+"</h4><span style='color:rgb(92, 91, 91);'>left of "+value+"</span><br><span style='color:grey;'>Renews till Bill Cycle</span>");
				pw.println("</div><div style='border-right:1.3px solid lightgrey;' class='col-2'></div><div class='col-1'></div><div class='col-4' style='font-family: Times New Roman, Times, serif;'><span class='bi bi-sim px-2 py-2' style='background-color:rgb(232, 232, 253);border-radius:50%;color:rgb(23, 23, 202);font-size:20px;'></span><h6 style='color:grey;font-family: Times New Roman, Times, serif;margin:4%;'>Plan</h6>");
			    pw.println("<h4 style='font-weight:bold;'>&#8377;"+res.getString(2)+"</h4><span style='color:rgb(92, 91, 91);'>Till Bill Cycle</span>");
			    pw.println("</div></div><br><div style='border-bottom:1.3px solid lightgrey;'></div><br><h6 style='color:grey;font-family: Times New Roman, Times, serif;'>Pay using Mobikwik UPI & get up to &#8377;50 cashback T&C applies</h6><br><div class='d-flex justify-content-center'><button class='rech w-50 rounded-5' style='font-family: Times New Roman, Times, serif;' onclick='Recharge()'>Recharge</button></div></div><br></div></div><br><br>");
					}
					else {
						pw.println("<div class='d-flex justify-content-center' style='margin-left:-6%;'><div id='divv' class='shadow-lg w-50' style='padding:3% 5%;background-color:white;'><div class='d-flex justify-content-between'>");
						pw.println("<div class='d-flex justify-content-between'><h5 style='font-family: Times New Roman, Times, serif;'>Prepaid Mobile <span style='font-weight:bold;'>"+mobile+"</span></h5><br></div><div><button class='btn btn-close' onclick='backk()'></button></div></div><br>");
						pw.println("<div class='row'><div class='col-5' style='font-family: Times New Roman, Times, serif;'><span class='bi bi-arrow-down-up px-2 py-2' style='background-color:rgb(232, 232, 253);border-radius:50%;color:rgb(23, 23, 202);font-size:20px;'></span><h6 style='color:grey;font-family: Times New Roman, Times, serif;margin:4%;''>Data</h6>");
						String amount=res.getString(2);
						
						String rechargeDt=res.getString(5);
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
					    java.util.Date dateBefore = sdf.parse(rechargeDt);
					    Calendar cal=Calendar.getInstance();
						SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMMM-yyyy");
						String rechargeDate=simpleformat.format(cal.getTime());
					    java.util.Date dateAfter = sdf.parse(rechargeDate);
					    long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
					    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
					    
					    
					    String time1 = "23:59:59"; 
					    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss"); 
					    java.util.Date currentDate = new java.util.Date();    
					    SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");    
					    String timeIn24Hours = formatter.format(currentDate);    
					    java.util.Date date1 = sdf2.parse(time1); 
					    java.util.Date date2 = sdf2.parse( timeIn24Hours); 
					    long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime()); 
					    long hours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;  
					    long minutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
					    
					    
					    String str=res.getString(3);
						String[] sp=str.split(" ");
						String val=sp[0];
						int totalDays=Integer.parseInt(val);
						
						int validityDay=(int)(totalDays-daysDiff);
						if(validityDay==0) {
							PreparedStatement ps3 = con.prepareStatement("delete from pack_details where MOBNO=? ");
							ps3.setString(1, mobile);
							ps3.executeUpdate();
						}
						if(amount.equals("179") | amount.equals("184")) {
							pw.println("<h4 style='font-weight:bold;'>"+res.getString(4)+"</h4><span style='color:rgb(92, 91, 91);'>left of "+value+"</span><br><span style='color:grey;'>Renews in "+validityDay+" days</span>");
							pw.println("</div><div style='border-right:1.3px solid lightgrey;' class='col-2'></div><div class='col-1'></div><div class='col-4' style='font-family: Times New Roman, Times, serif;'><span class='bi bi-sim px-2 py-2' style='background-color:rgb(232, 232, 253);border-radius:50%;color:rgb(23, 23, 202);font-size:20px;'></span><h6 style='color:grey;font-family: Times New Roman, Times, serif;margin:4%;'>Plan</h6>");
					    pw.println("<h4 style='font-weight:bold;'>&#8377;"+amount+"</h4><span style='color:rgb(92, 91, 91);'>"+validityDay+" days left</span>");
					}
					else {
						if(hours!=0) {
						pw.println("<h4 style='font-weight:bold;'>"+res.getString(4)+"</h4><span style='color:rgb(92, 91, 91);'>left of "+value+"</span><br><span style='color:grey;'>Renews in "+hours+" hours</span>");
					}
						else {
							pw.println("<h4 style='font-weight:bold;'>"+res.getString(4)+"</h4><span style='color:rgb(92, 91, 91);'>left of "+value+"</span><br><span style='color:grey;'>Renews in "+minutes+" minutes</span>");
						}
						pw.println("</div><div style='border-right:1.3px solid lightgrey;' class='col-2'></div><div class='col-1'></div><div class='col-4' style='font-family: Times New Roman, Times, serif;'><span class='bi bi-sim px-2 py-2' style='background-color:rgb(232, 232, 253);border-radius:50%;color:rgb(23, 23, 202);font-size:20px;'></span><h6 style='color:grey;font-family: Times New Roman, Times, serif;margin:4%;'>Plan</h6>");
					    pw.println("<h4 style='font-weight:bold;'>&#8377;"+amount+"</h4><span style='color:rgb(92, 91, 91);'>"+validityDay+" days left</span>");
					}
					    pw.println("</div></div><br><div style='border-bottom:1.3px solid lightgrey;'></div><br><h6 style='color:grey;font-family: Times New Roman, Times, serif;'>Pay using Mobikwik UPI & get up to &#8377;50 cashback T&C applies</h6><br><div class='d-flex justify-content-center'><button class='rech w-50 rounded-5' style='font-family: Times New Roman, Times, serif;' onclick='Recharge()'>Recharge</button></div></div><br></div></div><br><br>");
					}	
				req.getRequestDispatcher("template4.html").include(req, rs);	
			     }
			}
			else {
				if(res2.next()) {
					pw.println("<br><br><div><center><div class='p-2 w-50 rounded-3' style='margin-left:-6%;font-family:Times New Roman, Times, serif;background-color: rgb(5, 5, 188);color:white;'><h5 style='font-weight:bold;'>"+mobile+" | "+res2.getString(2)+" VoLTE</h5><h6>There are no Plans Available for this Service Right Now.</h6></div></center><br>");
				pw.println("<center><div class='shadow lg p-5 w-50 rounded-3' style='margin-left:-6%;font-family:Times New Roman, Times, serif;'><h5 style='font-weight:bold;'>You do not have any Active Plans Right Now!</h5><h6>Buy the best plan and enjoy best Services</h6><br><button class='rech w-50' onclick='Recharge()'>Recharge</button><br></div></center> </div><br><br><br><br><br>");
				req.getRequestDispatcher("template3.html").include(req, rs);
				}
				else {
					pw.println("<br><div><center><div class='p-2 w-50 rounded-3' style='margin-left:-6%;font-family:Times New Roman, Times, serif;background-color: rgb(5, 5, 188);color:white;'><h5 style='font-weight:bold;'> <span style='color:red;'>NA</span> | <span style='color:red;'>NA</span> VoLTE</h5><h6>There are no Plans Available for this Service Right Now.</h6></div></center><br>");
					pw.println("<center><div class='shadow lg p-5 w-50 rounded-3' style='margin-left:-6%;font-family:Times New Roman, Times, serif;'><h5 style='font-weight:bold;color:red;'>There are no such Phone Numbers in Your Profile</h5><br><h5 style='font-weight:bold;'>You do not have any Active Plans Right Now!</h5><h6>Buy the best plan and enjoy best Services</h6><br><button class='rech w-50' onclick='Recharge()'>Recharge</button><br></div></center> </div><br><br><br>");
					req.getRequestDispatcher("template3.html").include(req, rs);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	pw.println("<br><br>");
	req.getRequestDispatcher("footer.html").include(req, rs);
	pw.println("<script>function backk(){window.location.href='knowBalance';}function Recharge(){window.location.href='mobileRecharge';}</script>");
	    pw.println("</body>");
	pw.println("</html>"); 	
	
	}
}
