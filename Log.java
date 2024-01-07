import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Log extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Check</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                String name=request.getParameter("name");
                String pwd=request.getParameter("pwd");
                                                
                String driver="oracle.jdbc.driver.OracleDriver";
                String connurl="jdbc:oracle:thin:@localhost:1521:xe";
                String dbuname="cse";
                String dbpwd="cse";
                
                String sqltxt="select * from userdetails where name='"+name+"' and pwd='"+pwd+"'";
                
                Class.forName(driver);
                
                Connection con = DriverManager.getConnection(connurl,dbuname,dbpwd); 
                Statement stmt=con.createStatement();
                ResultSet rs;
                
                rs=stmt.executeQuery(sqltxt);
           
                
                if( !(rs.next()) )
            out.println("Incorrect username and password");

                else
{
           out.println("Welcome   "+name);
RequestDispatcher rd=request.getRequestDispatcher("catcse.html");
rd.include(request,response);
}


                
            }
            catch(Exception e)
            {
                out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
    }

   
}
