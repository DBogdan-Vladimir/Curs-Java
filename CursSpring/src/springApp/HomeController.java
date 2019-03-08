package springApp;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; //o trebuit sa il import TOT ce e aici, ceva nu am importat bine
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String user(@RequestParam(name="userName") String user, Model model) {
		System.out.println("User Page Requested");
		
			
		model.addAttribute("userName", user);
		return "user";
	}
	
	@RequestMapping(value="/visitor", method=RequestMethod.POST)
	public String visitor(@RequestParam(name="visitorName") String visitor, Model model, Locale locale) {
		System.out.println("Home page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("visitorName", visitor);
		model.addAttribute("serverTime", formattedDate);
		
		return "visitor";
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public String addEmployee(@RequestParam(name="name") String eName, @RequestParam(name="id") String eId, 
									@RequestParam(name="contactNumber") String eContactNumber, Model model) 
	{
		model.addAttribute("name", eName);
		model.addAttribute("id", eId);
		model.addAttribute("contactNumber", eContactNumber);
		
		return "employee";
}
	
	@RequestMapping(value="/calculator", method=RequestMethod.POST)
	public String calculator(@RequestParam(name="f1") String f1, @RequestParam(name="operation") String operation, 
									@RequestParam(name="f2") String f2, Model model) 
	{
		
			
			model.addAttribute("f1", f1);
			model.addAttribute("operation", operation);
			model.addAttribute("f2", f2);
			int result1 = Integer.parseInt(f1)+Integer.parseInt(f2); 
			int result2 = Integer.parseInt(f1)-Integer.parseInt(f2);
			int result3 = Integer.parseInt(f1)*Integer.parseInt(f2);
			int result4 = Integer.parseInt(f1)/Integer.parseInt(f2);
			if (operation.equals("+")) {model.addAttribute("result",result1);}
			if (operation.equals("-")) {model.addAttribute("result",result2);}
			if (operation.equals("*")) {model.addAttribute("result",result3);}
			if (operation.equals("/")) {model.addAttribute("result",result4);}
			return "calculator";
			
	}
	
}	
