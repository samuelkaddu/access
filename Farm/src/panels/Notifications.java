package panels;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.neptunesoftwaregroup.serializable.Notification;

@SuppressWarnings("serial")
public class Notifications extends Panel {

	public Notifications(String id, Model<Notification> model) {
		super(id);
		TextField<String> name = new TextField<String>("name", new PropertyModel<String>(model, "name"));
//		TextField<String> target = new TextField<String>("target", new Model<>());
//		target.setOutputMarkupId(true);

		TextArea<String> desc = new TextArea<String>("desc", new PropertyModel<String>(model, "desc"));
		// FeedbackPanel feedback = new FeedbackPanel("feedback");
		Form<Notification> form = new Form<Notification>("notiform", model) {
			protected void onSubmit() {
				Notification department = this.getModelObject();

			};

		};

		add(form);
		form.add(name);
		form.add(desc);
		// add(feedback);
		
		
		
//		
//		form.add(new AjaxSubmitLink("submit", form) {
//			@Override
//			protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {
//				super.onAfterSubmit(target, form);
//				target.appendJavaScript(
//						updated ? "alert('Changes saved succesfully')" : "alert('Unable to save your changes.')");
//				if (updated) {
//					Panel newPanel = new ListDepartments("panel");
//					newPanel.setOutputMarkupId(true);
//					MasterPage page = (MasterPage) getPage();
//					page.getReplacedPanel().replaceWith(newPanel);
//					if (target != null) {
//						target.add(newPanel);
//					}
//					page.setReplacedPanel(newPanel);
//				}
//			}
//		});
		
		
		
		
		
		
//		form.add(new AjaxLink<Void>("cancel") {
//			@Override
//			public void onClick(AjaxRequestTarget target) {
//				Panel newPanel = new ListDepartments("panel");
//				newPanel.setOutputMarkupId(true);
//				MasterPage page = (MasterPage) getPage();
//				page.getReplacedPanel().replaceWith(newPanel);
//				if (target != null) {
//					target.add(newPanel);
//				}
//				page.setReplacedPanel(newPanel);
//			}
//		});

	}

}
