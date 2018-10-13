package com.neptunesoftwaregroup.application;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import utilities.UserDao;

@SuppressWarnings("serial")
public class WebSession extends AuthenticatedWebSession {
	// User authenticated = null;

	public WebSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String username, String password) {
		UserDao dao = new UserDao();
		String login_id = dao.isAuthenticated(username, password);
		if (login_id != null && login_id.equalsIgnoreCase(username)) {
			setAttribute("user", login_id.toUpperCase());
			return true;
		}
		setAttribute("state", "Authentication failed.");
		return false;
	}


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
