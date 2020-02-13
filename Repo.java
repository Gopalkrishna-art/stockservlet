import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
class Repo extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="shop",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
PrintWriter pt=rs.getWriter();
String q="select * from stock";
ResultSet r=c.createStatement().executeQuery(q);
while(r.next())
pt.print(r.getString(1)+"----"+r.getInt(2)+"<br>");
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}


