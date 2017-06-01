package mypackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public class login extends HttpServlet{	
	static String username = null;
	static String password = null;
	static String registerusername = null;
	static String registerpassword = null;
	static String Repeatregisterpassword = null;
	static String id = null;
	static String USERNAME = null;
	private JSONObject json = new JSONObject();
	private Map<String,String> map = new HashMap<String,String>();
	private Map<String,String> srocemap = new HashMap<String,String>();
	private Map<String,String> current = new HashMap<String,String>();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		map.put("林超", "1245");
		map.put("lhdn", "14545");
		map.put("ldhk", "12654345");
		srocemap.put("林超", "0:20:30");
		srocemap.put("lhdn", "0:11:44");
		srocemap.put("ldhk", "0:0:35");
		current.put("林超", "0:0:22");
		current.put("lhdn", "0:10:32");
		current.put("ldhk", "0:6:27");
		username = req.getParameter("username");			
		password = req.getParameter("password");
		registerusername = req.getParameter("registerusername");
		registerpassword = req.getParameter("registerpassword");
		Repeatregisterpassword = req.getParameter("Repeatregisterpassword");
		id = req.getParameter("id");
		HttpSession session = req.getSession();	
		USERNAME = (String)session.getAttribute("USERNAME");
		String sroce = srocemap.get(USERNAME);
		
		if(id.equals("0")){
			if(USERNAME == null){				
				resp.getWriter().write("0");
			}else if(USERNAME != null){
				resp.setContentType("text/html; charset=UTF-8");
				json.put("username", USERNAME);
				json.put("sroce", sroce);
				json.put("jduge","1");
				String s = json.toString();
				resp.getWriter().write(s);
			}
		}else if(id.equals("1")){
			if(!map.containsKey(username)){				
				resp.getWriter().write("2");				
			}else if(map.containsKey(username)&&!map.get(username).equals(password)){				
				resp.getWriter().write("3");				
			}else if(map.containsKey(username)&&map.get(username).equals(password)){
				session.setAttribute("USERNAME", username);
				json.put("username", USERNAME);
				json.put("sroce", sroce);
				json.put("jduge","1");
				String s = json.toString();
				resp.getWriter().write(s);				
			}
		}else if(id.equals("2")){
			if(registerusername.equals("")){
				resp.getWriter().write("5");
			}else if(!registerusername.equals("")&&map.containsKey(registerusername)){
				resp.getWriter().write("6");
			}else if(!registerusername.equals("")&&!map.containsKey(registerusername)){
				if(registerpassword.equals("")){
					resp.getWriter().write("7");
				}else if(!registerpassword.equals("")&&!registerpassword.equals(Repeatregisterpassword)){
					resp.getWriter().write("8");
				}else if(!registerpassword.equals("")&&registerpassword.equals(Repeatregisterpassword)){
					map.put(registerusername, registerpassword);
					session.setAttribute("USERNAME", registerusername);
					srocemap.put(registerusername, "没有记录");
					json.put("username", registerusername);
					json.put("sroce", sroce);
					json.put("jduge","1");
					String s = json.toString();
					resp.getWriter().write(s);
					
				}
			}
		}
		
		/*
		if(username == ""&&USERNAME == null){
			resp.getWriter().write("");	
		}else if(username == ""&&USERNAME != null){			
			String sroce = srocemap.get(USERNAME);
			JSONObject json = new JSONObject();
			resp.setContentType("text/html; charset=UTF-8");
			json.put("username", USERNAME);
			json.put("sroce", sroce);
			String s = json.toString();
			resp.getWriter().write(s);
		}else if(username != ""){
			if(!map.containsKey(username)){
				System.out.println("username is not exit");
				resp.getWriter().write("1");
			}else if(map.containsKey(username)&&!map.get(username).equals(password)){
				System.out.println("password is wrong");
				resp.getWriter().write("0");
			}
			else if(map.containsKey(username)&&map.get(username).equals(password)){
				System.out.println("登陆成功");				
				session.setAttribute("USERNAME", username);
				session.setAttribute("PASSWORD", password);				
				String sroce = srocemap.get(username);
				JSONObject json = new JSONObject();
				resp.setContentType("text/html; charset=UTF-8");
				json.put("username", username);
				json.put("sroce", sroce);
				String s = json.toString();
				resp.getWriter().write(s);	
			}
			
		}	
		*/	
//		req.setAttribute("USENAME", username);
//		req.setAttribute("PASSWORD", password);
//		System.out.println(username);
//		System.out.println(password);
	}

}
