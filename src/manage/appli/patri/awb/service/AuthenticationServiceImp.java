package manage.appli.patri.awb.service;

import javax.annotation.Resource;
import javax.faces.bean.ManagedProperty;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


public class AuthenticationServiceImp implements AuthenticationService {

	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		
		
		try {
			Authentication authenticate = (Authentication) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					username, password));
					if (authenticate.isAuthenticated()) {
					SecurityContextHolder.getContext().setAuthentication(
					authenticate);   
					return true;
					}
				} catch (AuthenticationException e) {  
					}
				return false;
	}

}
