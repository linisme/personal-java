package ssm.controllter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ssm.po.User;
import ssm.service.impl.ServiceImpl;



@Controller
public class HomeController {
	@Autowired
	@Qualifier("serviceimpl")
	private ServiceImpl serviceimpl;
	
	@RequestMapping("/try")
	public ModelAndView show()throws Exception{
//		
		User user1 = serviceimpl.findUserById(3);
		User user2 = serviceimpl.findUserById(8);
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("LIST", list);
		modelandview.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		return modelandview;
	}
	
	@RequestMapping("/submit")
	public String submit(MultipartFile image)throws Exception{
		String s = image.getOriginalFilename();
		System.out.println(s);
		return "redirect:/try";
		
	}
}
