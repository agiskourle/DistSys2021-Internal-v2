package gr.hua.dit.ds.housingsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.ds.housingsys.dao.AuthorityDAO;
import gr.hua.dit.ds.housingsys.dao.UserDAO;

@RequestMapping("/admin/portal")
@Controller
public class AdminController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AuthorityDAO authorityDAO;

	@GetMapping("/add")
	public String showAdminAdd() {
		return "AddUser";
	}

	@PostMapping("/addUserForm")
	public String addUserForm(HttpServletRequest request, Model model) {
		try {
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		password = "$" + password;
		String authority = "ROLE_USER";
		if (request.getParameter("authority") == "ROLE_ADMIN")
			authority = "ROLE_ADMIN";
		if(userDAO.addUser(username, password)==1 && authorityDAO.addAuthority(username, authority)==1) {
			return "SuccessfulAction";
		} else {
			return "GenericError";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return "GenericError";
	}
	}

	@GetMapping("/update")
	public String showAdminUpdate() {
		return "UpdateUser";
	}

	@PostMapping("/updateUserForm")
	public String updateUserForm(HttpServletRequest request, Model model) {
		try {
			String username_old = request.getParameter("username_old");
			String username = request.getParameter("username");
			String password = request.getParameter("passwd");
			password = "$" + password;
			String authority = "ROLE_USER";
			if (request.getParameter("authority") == "ROLE_ADMIN")
				authority = "ROLE_ADMIN";
			
			if(authorityDAO.deleteAuthority(username_old)==1 && userDAO.deleteUser(username_old)==1) {
				if(userDAO.addUser(username, password)==1 && authorityDAO.addAuthority(username, authority)==1) {
					return "SuccessfulAction";
				} else {
					return "GenericError";
				}
			} else {
				return "GenericError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

	@GetMapping("/delete")
	public String showAdminDelete() {
		return "DeleteUser";
	}

	@PostMapping("/deleteUserForm")
	public String deleteUserForm(HttpServletRequest request, Model model) {
		try {
			String username = request.getParameter("username");
			
			if(authorityDAO.deleteAuthority(username)==1 && userDAO.deleteUser(username)==1) {
					return "SuccessfulAction";

			} else {
				return "GenericError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}
}
