package pages;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.neptunesoftwaregroup.serializable.User;

@SuppressWarnings("serial")
public class LoginPage extends WebPage {
	@Override
	protected void onConfigure() {
		super.onConfigure();
		if (AuthenticatedWebSession.get().isSignedIn())
			setResponsePage(MasterPage.class);
	}

	public LoginPage() {

		Model<User> model = new Model<User>(new User());

		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);

		StatelessForm<User> form = new StatelessForm<User>("loginform", model) {
			protected void onSubmit() {
				User user = this.getModelObject();

				boolean isAuthenticated = AuthenticatedWebSession.get().signIn(user.getUser_id().trim(),
						user.getPasswd());

				if (isAuthenticated)
					setResponsePage(MasterPage.class);
				else if (user.getUser_id().equalsIgnoreCase("SYSTEM")) {
					feedback.error("User SYSTEM NOT ALLOWED");
				} else {
					feedback.error(getSession().getAttribute("state"));
				}
			}
		};
		add(form);

		TextField<String> user = new TextField<String>("login_id", new PropertyModel<String>(model, "user_id"));
		user.setRequired(true);

		PasswordTextField paswd = new PasswordTextField("password", new PropertyModel<String>(model, "passwd"));
		paswd.setRequired(true);

		form.add(user);
		form.add(paswd);
	}
}
