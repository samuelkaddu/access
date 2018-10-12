package com.neptunesoftwaregroup.application;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import com.neptunesoftwaregroup.serializable.User;

@SuppressWarnings("serial")
public class WebSession extends AuthenticatedWebSession {
	User authenticated = null;

	public WebSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String username, String password) {

	//	setAttribute("state", "Authentication failed.");
		setAttribute("user","true");
		
		return true;
	}

//	
//	if (authenticated != null && "Active".equalsIgnoreCase(authenticated.getRec_st().trim())) {
//		setAttribute("user_role", api.getRole(Integer.parseInt(authenticated.getRole_id())));
	//setAttribute("user", authenticated.getLogin_id());
//	}

	@Override
	public Roles getRoles() {
		Roles resultRoles = new Roles();
		if (isSignedIn()) {
			resultRoles.add("SIGNED_IN");
			resultRoles.add(Roles.ADMIN);
		}
		return resultRoles;
	}

	@Override
	public void signOut() {
		super.signOut();
	}

}
