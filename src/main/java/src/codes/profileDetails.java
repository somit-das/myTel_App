package src.codes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/profileDetails")
public class profileDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        ServletContext sc=getServletContext();
        
          Object oo=(Object)sc.getAttribute("profileName");
	      String pName=(String)oo;
	      Object oo2=(Object)sc.getAttribute("profileMobileNo");
	      String pMobileNo=(String)oo2;
	      Object oo22=(Object)sc.getAttribute("profileMailid");
	      String pMailid=(String)oo22;
	      Object oo3=(Object)sc.getAttribute("profileAddress");
	      String pAddress=(String)oo3;
	      Object oo4=(Object)sc.getAttribute("profilePicture");
	      String pPicturePath=(String)oo4;
	
	    pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Profile Details</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");
		pw.println("<style>.stars{margin-right:5px;font-size:20px;border:1px solid #10ac84;padding:0 7px;color:white;background-color:#10ac84;}.icons{font-size:30px;color:black;}.icons:hover{color:lightgrey;}</style>");
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);background-size:cover;'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		
		pw.println("<div style='box-shadow:0 0 10px lightgrey;width:75%;height:65%; margin-left:9%;padding:1.5% 8%;background-image: linear-gradient(to right,#7158e2,#18dcff);'><h4 style='color:white;text-align:center;font-family:Times New Roman, Times, serif;font-weight: bold;'><span class='bi bi-person-circle'></span> MY MYTEL PROFILE <span class='bi bi-person-circle'></span></h4> <br><div style='width:100%;border-radius:6px;box-shadow: 1px 1px 1px lightgrey;background-color: white;padding:14px;'>");
		pw.println("<div class='row'><div class='col-7'><img src='other/ProfilePictures/"+pPicturePath+"' class='img-thumbnail' style='height:400px;width:500%;'></div>");
		pw.println("<div class='col-5' style='font-family:Times New Roman, Times, serif;'><br><h6>HELLO EVERYBODY, I AM</h6>");
		pw.println("<h4 style='font-weight:bold'>"+pName+"</h4>");
		pw.println("<h6 style='font-weight:bold;color:rgb(105, 105, 105);'>A SUCCESS MYTEL USER</h6><span style='color:grey;font-size:15px;'>Hello, As far as I have used this MYTEL application is a very user-friendly website to enjoying all services. Happy to recommended.</span><br><br>");
		pw.println("<div class='row'><div class='col-1'></div><div class='col-1'><span class='bi bi-telephone' style='color:blue'></span></div><div class='col-9' style='font-weight:bold'>+91 "+pMobileNo+"</div></div>");
        pw.println("<div class='row'><div class='col-1'></div><div class='col-1'><span class='bi bi-envelope' style='color:blue'></span></div><div class='col-9' style='font-weight:bold'>"+pMailid+"</div></div>");
		pw.println("<div class='row'><div class='col-1'></div><div class='col-1'><span class='bi bi-house' style='color:blue'></span></div><div class='col-9' style='font-weight:bold'>"+pAddress+"</div></div><br>");
        pw.println("<div class='d-flex mx-4'><div><a href='https://www.facebook.com/mytelmyanmar'><span class='bi bi-facebook' style='color: grey;font-size:28px;margin-right:12px;'></span></a></div><div><a href='https://twitter.com/'><span class='bi bi-twitter' style='color:grey;font-size:28px;margin-right:12px;'></span></a></div> <div><a href='https://youtube.com/'><span class='bi bi-youtube' style='color:grey;font-size:28px;margin-right:12px;'></span></a></div><div><a href='https://www.instagram.com/mytelmyanmar'><span class='bi bi-instagram' style='color: grey;font-size:28px;margin-right:12px;'></span></a></div></div></div></div></div></div>");
		pw.println("<div style='box-shadow:0 0 15px lightgrey;width:75%;height:7%;margin-left:9%;padding:1.5% 8%;background-color:white;'></div> ");
        
		pw.println("<br>");
		req.getRequestDispatcher("profileTemplate.html").include(req, rs);
	    pw.println("<br><br>");
	req.getRequestDispatcher("footer.html").include(req, rs);
	pw.println("<script>function backk(){window.location.href='Mainpage.html';}</script>");
    pw.println("</body>");
	pw.println("</html>"); 	
	
	}
}
