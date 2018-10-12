package pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import panels.Dashboard;

@SuppressWarnings("serial")
public class MasterPage extends WebPage {
	private String user;// to store the user name for the user who ia currently logged inFs
	private Panel replacedPanel;

	@Override
	protected void onConfigure() {
		super.onConfigure();
		AuthenticatedWebApplication app = (AuthenticatedWebApplication) getApplication();
		if (!AuthenticatedWebSession.get().isSignedIn())
			app.restartResponseAtSignInPage();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		user = (String) getSession().getAttribute("user");
		if (user != null)
			setupLinks();
		else
			signOut();

	}

	public Panel getReplacedPanel() {
		return replacedPanel;
	}

	public void setReplacedPanel(Panel replacedPanel) {
		this.replacedPanel = replacedPanel;
	}

	private void signOut() {
		getSession().invalidate();
		AuthenticatedWebSession.get().signOut();
		setResponsePage(LoginPage.class);
	}

	private void setupLinks() {
		replacedPanel = new Dashboard("panel");
		replacedPanel.setOutputMarkupId(true);
		// UserRole role = (UserRole) getSession().getAttribute("user_role");

		add(replacedPanel);
		add(new Label("login_id", user));
		add(new AjaxFallbackLink<MasterPage>("dashboard") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				Panel newPanel = new Dashboard("panel");
				newPanel.setOutputMarkupId(true);
				replacedPanel.replaceWith(newPanel);
				if (target != null) {
					target.add(newPanel);
				}
				replacedPanel = newPanel;
			}
		});

	}

}
