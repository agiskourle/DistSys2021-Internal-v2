package gr.hua.dit.ds.housingsys.other;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthService {

	public String getcurrentUserDepartment() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    if(currentUserName.contains("dit")) {
		    	return "dit";
		    } else if (currentUserName.contains("geo")) {
		    	return "geo";
		    } else if (currentUserName.contains("ddn")) {
		    	return "ddn";
		    } else {
		    	return "Error1";
		    }
		} else {
			return "Error2";
		}
	}

}
