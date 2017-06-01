package mypackage;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
public class test extends HttpServlet{
	static String username = null;
	static String password = null;
	static String registerusername = null;	
	static String registerpassword = null;
	static String Repeatregisterpassword = null;	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject json = new JSONObject();
		response.setContentType("text/html; charset=UTF-8");
		json.put("1","0:0:46");
		json.put("2","0:0:59");
		json.put("3","0:1:03");
		json.put("4","0:1:04");
		json.put("5","0:1:56");
		json.put("6","0:2:03");
		json.put("7","0:2:04");
		json.put("8","0:3:17");
		json.put("9","0:4:49");	
		String s = json.toString();		
		response.getWriter().write(s);	
//		System.out.println("get it now");
		//resp.getWriter().write("<a href=https://www.baidu.com/?tn=95113951_hao_pg>Hello !</a>");
			
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(registerusername);
//		MyJDBC myjdbc = new MyJDBC();
//		myjdbc.connectMySQL();
//		myjdbc.insert(username, password);		
//		ServletContext context = getServletContext();
//		if(false){	
////			response.getWriter().write("<b>密码不一致，请重新输入！</b>");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("thesamepassword.html");
//			dispatcher.forward(request, response);
//
//		}else{
//				RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
//				dispatcher.forward(request, response);
//			}
				
	}

	
}
