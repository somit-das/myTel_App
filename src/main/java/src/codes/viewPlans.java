package src.codes;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/viewPlans")

public class viewPlans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        Connection con;
        Statement st;
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel View Plans</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");	
		pw.println("<style>div ul{list-style-type: none;color:white;} div ul li::before{content:'*';font-size:20px;color:orange;font-weight:bold;display:inline-block;width:0.7em;margin-left:-15%;}</style>");
	
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
	    String mob=req.getParameter("phno");
		String typee=req.getParameter("type");
		String operator=req.getParameter("slct");
		ServletContext sc=getServletContext() ;
		sc.setAttribute("mobno1", mob);
		if(typee==null) {
			typee="Prepaid";
		}
		try {
			con=DB.getCon();
			st=con.createStatement();
		    PreparedStatement ps=con.prepareStatement("select MOBNO,TYPEE from mrecharge where MOBNO=? and TYPEE!=? ");
            ps.setString(1, mob);
            ps.setString(2, typee);
            ResultSet res=ps.executeQuery();
            PreparedStatement ps2=con.prepareStatement("select MOBNO from mrecharge where MOBNO=? ");
            ps2.setString(1, mob);
            ResultSet res2=ps2.executeQuery();
            PreparedStatement ps3=con.prepareStatement("select MOBNO,OPERATOR from mrecharge where MOBNO=? and OPERATOR!= ? ");
            ps3.setString(1, mob);
            ps3.setString(2, operator);
            ResultSet res3=ps3.executeQuery();
            if(res.next()){
            pw.println("<h5 style='font-family: Times New Roman, Times, serif;color:red;font-weight:bold;margin-left:16%;'>You have "+res.getString(2)+" Number So, You Cannot See The "+typee+" Plans Here...</h5>");	   
            req.getRequestDispatcher("mRechargeForm.html").include(req, rs);
            pw.println("<br><br>");
		    }
            else {
            	if(res2.next()) {
                 }
            	else {
                st.executeUpdate("insert into mrecharge values('"+mob+"','"+typee+"','"+operator+"') ");
            	}
            	if(typee=="Prepaid"){
            if(res3.next()) {
            	 pw.println("<h5 style='font-family: Times New Roman, Times, serif;color:red;font-weight:bold;margin-left:16%;'>You have "+res3.getString(2)+" Operator So, You Cannot See The "+operator+" Plans Here...</h5>");	    
            	 req.getRequestDispatcher("mRechargeForm.html").include(req, rs);
                 pw.println("<br><br>");
            }
            else {
            	if(operator.equals("Jio")) {
                	req.getRequestDispatcher("JioPrepaidPlans.html").include(req, rs);
                	pw.println("<br><br>");
    			    }
    		        else if(operator.equals("Airtel")) {
    		    	req.getRequestDispatcher("AirtelPrepaidPlans.html").include(req, rs);
    	    		pw.println("<br><br>");
    		  		 }
    		    else if(operator.equals("VI")){
    		    req.getRequestDispatcher("VIPrepaidPlans.html").include(req, rs);
    	    	pw.println("<br><br>");
    		    }	
    		    else if(operator.equals("BSNL")){
    		    req.getRequestDispatcher("BSNLPrepaidPlans.html").include(req, rs);
    	    	pw.println("<br><br>"); 
    		    }
            }
            }
           else {
         if(res3.next()) {
        	 pw.println("<h5 style='font-family: Times New Roman, Times, serif;color:red;font-weight:bold;margin-left:16%;'>You have "+res3.getString(2)+" Operator So, You Cannot See The "+operator+" Plans Here...</h5>");	    
        	 req.getRequestDispatcher("mRechargeForm.html").include(req, rs);
             pw.println("<br><br>");
         }
         else {
        	 if(operator.equals("Jio")) {
                 req.getRequestDispatcher("JioPostpaidPlans.html").include(req, rs);
                 pw.println("<br><br>");
                 }
                 else if(operator.equals("Airtel")) {
                 req.getRequestDispatcher("AirtelPostpaidPlans.html").include(req, rs);
                 pw.println("<br><br>");
                 }
       	    else if(operator.equals("VI")){
               req.getRequestDispatcher("VIPostpaidPlans.html").include(req, rs);
       	    pw.println("<br><br>");
       	     }	
               else if(operator.equals("BSNL")){
       	    req.getRequestDispatcher("BSNLPostpaidPlans.html").include(req, rs);
       		pw.println("<br><br>"); 
         }
         }
           }
           }     		 
		 con.close();
		 st.close();   
		} 	
	    catch(Exception e) {
	    System.out.println(e);
		   }  
	    req.getRequestDispatcher("template1.html").include(req, rs);
	    pw.println("<br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='mobileRecharge';}</script>");
		pw.println("</body>");
		pw.println("</html>"); 		
		pw.close();
	}
}
