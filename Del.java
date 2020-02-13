import java.sql.*; 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
class Del extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String op=rq.getParameter("op");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="shop",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
PrintWriter p=rs.getWriter();
String q=("delete from stock where name=?");
PreparedStatement ps=c.prepareStatement(q);
ps.setString(1,op);
ps.execute();
p.print("<html><body>");
p.print("Item added"+"<br>");
p.print("<a href='all.html'>back</a>");
p.print("</body></html>");
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}
