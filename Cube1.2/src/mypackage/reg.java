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

public class reg extends HttpServlet{	
	private String regname = null;
	private String regpassword = null;
	private String repassword = null;
	private Map<String,String> regnamemap = new HashMap<String,String>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		regnamemap.put("�ֳ�", "1245");
		regnamemap.put("lhdn", "14545");
		regnamemap.put("ldhk", "12654345");
		regname = req.getParameter("registerusername");
		regpassword = req.getParameter("registerpassword");
		repassword = req.getParameter("Repeatregisterpassword");
		System.out.println(regname);
		System.out.println(regpassword);
		System.out.println(repassword);
		if(regname==""){
			resp.getWriter().write("");
			System.out.println("�û�������Ϊ��");
		}else if(regnamemap.containsKey(regname)){
			resp.getWriter().write("4");
			System.out.println("�û����ѱ�ע��");
		}else if(!regnamemap.containsKey(regname)&&regpassword==""){
			resp.getWriter().write("5");
			System.out.println("���벻��Ϊ��");
		}else if(!regnamemap.containsKey(regname)&&!regpassword.equals(repassword)){
			resp.getWriter().write("6");
			System.out.println("���벻һ��");
		}else if(!regnamemap.containsKey(regname)&&regpassword.equals(repassword)){			
			resp.getWriter().write("7");
			regnamemap.put(regname, regpassword);
			System.out.println("ע��ɹ�");			
		}
	}

}
