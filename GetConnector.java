import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
/**
* Servlet implementation class GetConnector
*/
@WebServlet("/GetConnector")
public class GetConnector extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public GetConnector() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
PrintWriter pw = response.getWriter();
String un=request.getParameter("username");
String pn=request.getParameter("password");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/user1",
"root", "root");
PreparedStatement ps = c.prepareStatement("select * from login where email=? and pass=?");
ps.setString(1, un);
ps.setString(2, pn);
ResultSet rs = ps.executeQuery();
while (rs.next())
{
pw.println("valid user login successfully");
return;
}
pw.println("invalid user");
return;
}
catch (Exception e )
{
e.printStackTrace();
}
}
}