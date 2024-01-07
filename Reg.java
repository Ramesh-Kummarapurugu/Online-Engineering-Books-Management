import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;
public class Reg extends HttpServlet
 {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                String name=request.getParameter("name");
                String mobno=request.getParameter("mobno");
                String email=request.getParameter("email");
                String pwd=request.getParameter("pwd");
                String cpwd=request.getParameter("cpwd");
                String gen=request.getParameter("gen");
                String sub="";
                String subjects[]=request.getParameterValues("subjects");
for(int i=0;i<subjects.length;i++)
{sub+=subjects[i]+" ";
}
                String branch=request.getParameter("branch");
                String address=request.getParameter("address");
                String studentid=request.getParameter("studentid");
                String driver="oracle.jdbc.driver.OracleDriver";
                String connurl="jdbc:oracle:thin:@localhost:1521:xe";
                String dbuname="cse";
                String dbpwd="cse";
	
                String sqltxt="insert into userdetails values('"+name+"','"+mobno+"','"+email+"','"+pwd+"','"+cpwd+"','"+gen+"','"+sub+"','"+branch+"','"+address+"','"+studentid+"')";
                Class.forName(driver);
	
                Connection con = DriverManager.getConnection(connurl,dbuname,dbpwd); 
                Statement stmt=con.createStatement();
                int i=stmt.executeUpdate(sqltxt);
                
             }
            catch(Exception e)
            {
                out.println(e);
            }
out.println("You are registered successfully");
            out.println("</body>");
            out.println("</html>");        
    }
}
