package com.neptunesoftwaregroup.application;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

@SuppressWarnings("serial")
public class WebSession extends AuthenticatedWebSession {

	public WebSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String username, String password) {

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
