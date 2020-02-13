import java.io.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
class Add extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String item=rq.getParameter("item");
int no=Integer.parseInt(rq.getParameter("no"));
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="shop",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
PrintWriter pt=rs.getWriter();
String k="select name from stock where name='"+item+"'";
ResultSet rk=c.createStatement().executeQuery(k);
if(rk.next()){
pt.print("Item already added");
}
else{
String r="insert into stock values(?,?)";
PreparedStatement p=c.prepareStatement(r);
p.setString(1,item);
p.setInt(2,no);
p.execute();
pt.print("<html><body>");
pt.print("Item added"+"<br>");
pt.print("<a href='all.html'>back</a>");
pt.print("</body></html>");
}
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}
