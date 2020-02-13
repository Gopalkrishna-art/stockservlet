import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
class Buy extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String item=rq.getParameter("item");
int no=Integer.parseInt(rq.getParameter("no"));
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="shop",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
PrintWriter pe=rs.getWriter();
String k="select name,no from stock where name='"+item+"'";
ResultSet rk=c.createStatement().executeQuery(k);
String r="";
if(rk.next()){
r="update stock set no=? where name=?";
PreparedStatement p=c.prepareStatement(r);
p.setString(2,item);
p.setInt(1,rk.getInt(2)+no);
p.execute();
pe.print("<html><body>");
pe.print("Item added"+"<br>");
pe.print("<a href='all.html'>back</a>");
pe.print("</body></html>");
}
else{
pe.print("<html><body>");
pe.print("no item found to buy"+"<br>");
pe.print("<a href='all.html'>back</a>");
pe.print("</body></html>");
}
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}

