package src.codes;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/contactDetails")

public class contactDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw=rs.getWriter();
        Connection con;
        Statement st;
        String name=req.getParameter("nmm");
        String mail=req.getParameter("mail");
        String subject=req.getParameter("sub");
        String message=req.getParameter("msg");
      
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Mytel Contact Details</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css'>");
		pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		pw.println("<link rel='icon' href='other/images/mm.jpg'>");
		pw.println("<link rel='stylesheet' href='other/style.css'/>");
		pw.println("<script src='other/fun.js'></script>");	
		pw.println("<style>.inp{border:none;outline:none;border-bottom:2px solid lightgrey;background-color:none;background:none;}#smsg{padding:7px;background-color:rgb(245, 28, 144);border-radius:4px;color:white;border:1px solid rgb(245, 28, 144);}#smsg:hover{background-color:rgb(223, 11, 124);border:1px solid rgb(223, 11, 124);} ::placeholder {color:lightgrey !important;}#icn{padding:8px;border:1px solid lightgrey;border-radius: 50%;}.icoo{font-size:55px;}.con2{color:orange;}</style>");
	
		pw.println("</head>");
		pw.println("<body id='body-pd' style='background-image:url(other/images/bg1.webp);background-size:auto;'>");
		req.getRequestDispatcher("navbar.html").include(req, rs);
		
		pw.println("<br><div style='margin-left:16%;height:4px;background-image:linear-gradient(to right,red,green,orange,blue,deeppink,yellow);width:61%'></div>");
	    pw.println("<button style='float:right;margin-top:-2%;margin-right:1.9%;' class='btn btn-outline-primary' onclick='backk()'><span class='bi bi-arrow-left-square'></span> Back</button>");
		pw.println("<br>");
		try {
			con=DB.getCon();
		    st=con.createStatement();
		    if(name!=null && mail!=null && subject!=null && message!=null) {
		    st.executeUpdate("insert into Message values('"+name+"','"+mail+"','"+subject+"','"+message+"')");
		    pw.println("<h4 style='color:rgb(34, 173, 43);text-align:center;font-weight:bold;font-family:Times New Roman,Times,serif;'>Message Sent...</h4>");
		    }
		    
		    con.close();
		    st.close();
		}
		catch(Exception ee) {
			System.out.println(ee);
		}
		
		req.getRequestDispatcher("contactTemplate.html").include(req, rs);
		
		pw.println("<br><br><br>");
		req.getRequestDispatcher("contactTemplate2.html").include(req, rs);
	   
	    pw.println("<br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		pw.println("<script>function backk(){window.location.href='Mainpage.html';}</script>");
		pw.println("</body>");
		pw.println("</html>"); 		
		pw.close();
	}
}
