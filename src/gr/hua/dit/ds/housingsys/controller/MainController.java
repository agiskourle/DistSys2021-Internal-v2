package gr.hua.dit.ds.housingsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/admin/portal")
	public String showAdmin() {
		return "Portal";
	}
	
	/*
	@GetMapping("**")
	public String redirect() {
		return "redirect:/home";
	}
	*/
	
	@GetMapping("/home/**")
	public String redirectHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/admin/**")
	public String redirectAdmin() {
		return "redirect:admin/portal";
	}
	
	/*
	 * @RequestMapping(value="**", method = RequestMethod.GET) public String
	 * redirect(){ return "redirect:/home"; }
	 */

}
