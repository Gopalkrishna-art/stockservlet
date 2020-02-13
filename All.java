import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
class All extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String opt=rq.getParameter("opt");
if(opt.equals("a"))
rs.sendRedirect("add.html");
else if(opt.equals("d"))
rs.sendRedirect("del.html");
else if(opt.equals("b"))
rs.sendRedirect("buy.html");
else if(opt.equals("r"))
rs.sendRedirect("repo");
else
rs.sendRedirect("sell.html");
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}
